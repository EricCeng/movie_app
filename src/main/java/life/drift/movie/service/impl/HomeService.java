package life.drift.movie.service.impl;

import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.*;
import life.drift.movie.model.*;
import life.drift.movie.service.IHomeService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.PostVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HomeService implements IHomeService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostExtMapper postExtMapper;

    //添加动态
    @Override
    public ServerResponse insert(String postContent, Long userId) {
        Post post = new Post();
        post.setUserId(userId);
        post.setCreator(userId);
        post.setPostContent(postContent);
        post.setCommentCount(0L);
        post.setLikeCount(0L);

        int result = postExtMapper.insert(post);
        if (result < 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.POST_FAIL.getCode(), ResponseErrorCode.POST_FAIL.getMsg());
        }

        return ServerResponse.createServerResponseBySuccess();
    }

    //查看所有动态
    @Override
    public ServerResponse findPost() {
        PostExample postExample = new PostExample();
        postExample.setOrderByClause("create_time desc");
        List<Post> postList = postMapper.selectByExampleWithBLOBs(postExample);

        if (postList.size() == 0) {
            return null;
        }

        Set<Long> targetUser = postList.stream().map(post -> post.getUserId()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>();
        userIds.addAll(targetUser);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));

        List<PostVO> postVOList = postList.stream().map(post -> {
            PostVO postVO = new PostVO();
            BeanUtils.copyProperties(post, postVO);
            postVO.setCreateTime(DateUtil.date2String(post.getCreateTime()));
            postVO.setUpdateTime(DateUtil.date2String(post.getUpdateTime()));
            postVO.setUserName(userMap.get(post.getUserId()).getUsername());
            postVO.setUserAvatar(userMap.get(post.getUserId()).getAvatarUrl());
            return postVO;
        }).collect(Collectors.toList());
        return ServerResponse.createServerResponseBySuccess(postVOList);
    }

    //查看单条动态内容
    @Override
    public ServerResponse selectPostById(Long id) {
        Post post = postMapper.selectByPrimaryKey(id);

        if (post == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.POST_NOT_FOUND.getCode(), ResponseErrorCode.POST_NOT_FOUND.getMsg());
        }
        User user = userMapper.selectByPrimaryKey(post.getUserId());

        PostVO postVO = new PostVO();
        BeanUtils.copyProperties(post, postVO);
        postVO.setCreateTime(DateUtil.date2String(post.getCreateTime()));
        postVO.setUpdateTime(DateUtil.date2String(post.getUpdateTime()));
        postVO.setUserName(user.getUsername());
        postVO.setUserAvatar(user.getAvatarUrl());

        return ServerResponse.createServerResponseBySuccess(postVO);
    }
}
