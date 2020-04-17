package life.drift.movie.service.impl;

import com.github.pagehelper.PageHelper;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.MovieExtMapper;
import life.drift.movie.mapper.MovieMapper;
import life.drift.movie.mapper.PostExtMapper;
import life.drift.movie.mapper.PostMapper;
import life.drift.movie.model.Movie;
import life.drift.movie.model.Post;
import life.drift.movie.service.IHomeService;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.MovieVO;
import life.drift.movie.vo.PostListVO;
import life.drift.movie.vo.PostVO;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService implements IHomeService {

    @Autowired
    private PostExtMapper postExtMapper;

    @Autowired
    private IUserService userService;

    //添加动态
    @Override
    public ServerResponse insert(String postContent, Long userId) {
        Post post = new Post();
        post.setUserId(userId);
        post.setPostContent(postContent);

        int result = postExtMapper.insert(post);
        if (result < 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.POST_FAIL.getCode(), ResponseErrorCode.POST_FAIL.getMsg());
        }

        return ServerResponse.createServerResponseBySuccess();
    }

    //查看所有动态
    @Override
    public ServerResponse findPost() {
        PostListVO post = getPost();
        return ServerResponse.createServerResponseBySuccess(post);
    }

    public PostListVO getPost() {
        PostListVO postListVO = new PostListVO();
        List<Post> postList = postExtMapper.selectAll();

        List<PostVO> postVOList = new ArrayList();

        for (Post post : postList) {
            PostVO postVO = new PostVO();
            postVO.setId(post.getId());
            postVO.setPostContent(post.getPostContent());
            postVO.setCommentCount(post.getCommentCount());
            postVO.setLikeCount(post.getLikeCount());
            postVO.setCreateTime(DateUtil.date2String(post.getCreateTime()));
            postVO.setUpdateTime(DateUtil.date2String(post.getUpdateTime()));
            postVO.setIsSelected(post.getIsSelected());

            ServerResponse serverResponse = userService.selectByUserId(post.getUserId());
            UserVO userVO = (UserVO) serverResponse.getData();

            postVO.setUserId(post.getUserId());
            postVO.setUserName(userVO.getUsername());
            postVO.setUserAvatar(userVO.getAvatarUrl());

            postVOList.add(postVO);

        }

        postListVO.setPostVOList(postVOList);

        return postListVO;
    }


}
