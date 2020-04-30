package life.drift.movie.service.impl;

import life.drift.movie.mapper.*;
import life.drift.movie.model.*;
import life.drift.movie.service.IFindService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindService implements IFindService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private UserMapper userMapper;

    //查看 精选影评
    @Override
    public ServerResponse findSelectedReview() {

        ReviewExample reviewExample = new ReviewExample();
        reviewExample.createCriteria()
                .andIsSelectedEqualTo(1);
        reviewExample.setOrderByClause("comment_count desc");
        List<Review> reviewList = reviewMapper.selectByExampleWithBLOBs(reviewExample);

        if (reviewList.size() == 0) {
            return null;
        }

        Set<Long> targetMovie = reviewList.stream().map(review -> review.getMovieId()).collect(Collectors.toSet());
        List<Long> movieIds = new ArrayList<>();
        movieIds.addAll(targetMovie);

        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria()
                .andIdIn(movieIds);
        List<Movie> movies = movieMapper.selectByExample(movieExample);
        Map<Long, Movie> movieMap = movies.stream().collect(Collectors.toMap(movie -> movie.getId(), movie -> movie));

        List<ReviewVO> reviewVOList = reviewList.stream().map(review -> {
            ReviewVO reviewVO = new ReviewVO();
            BeanUtils.copyProperties(review, reviewVO);
            reviewVO.setCreateTime(DateUtil.date2String(review.getCreateTime()));
            reviewVO.setUpdateTime(DateUtil.date2String(review.getUpdateTime()));

            reviewVO.setMovieName(movieMap.get(review.getMovieId()).getMovieName());
            reviewVO.setMovieAvatar(movieMap.get(review.getMovieId()).getMovieAvatar());
            reviewVO.setDirector(movieMap.get(review.getMovieId()).getDirector());
            reviewVO.setActor(movieMap.get(review.getMovieId()).getActor());
            reviewVO.setCountry(movieMap.get(review.getMovieId()).getCountry());
            reviewVO.setScore(movieMap.get(review.getMovieId()).getScore());
            reviewVO.setCategory(movieMap.get(review.getMovieId()).getCategory());
            reviewVO.setShowTime(DateUtil.date2String(movieMap.get(review.getMovieId()).getShowTime()));

            return reviewVO;
        }).collect(Collectors.toList());

        return ServerResponse.createServerResponseBySuccess(reviewVOList);
    }

    //查看 精选动态
    @Override
    public ServerResponse findSelectedPost() {
        PostExample postExample = new PostExample();
        postExample.createCriteria()
                .andIsSelectedEqualTo(1);
        postExample.setOrderByClause("comment_count desc");
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

}
