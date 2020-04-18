package life.drift.movie.common;

import life.drift.movie.mapper.PostExtMapper;
import life.drift.movie.model.Post;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.PostListVO;
import life.drift.movie.vo.PostVO;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Const {

    @Autowired
    private PostExtMapper postExtMapper;

    @Autowired
    private IUserService userService;

    public static final String CURRENT_USER = "USER";

    public PostListVO getPost(List<Post> postList) {
        PostListVO postListVO = new PostListVO();
//        postList = postExtMapper.selectAll();

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
