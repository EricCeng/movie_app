package life.drift.movie.controller;

import life.drift.movie.common.Const;
import life.drift.movie.service.IHomeService;
import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HomeController {
    @Autowired
    private IMovieService movieService;

    @Autowired
    private IHomeService homeService;

    //搜索
    @RequestMapping({"/search"})
    public ServerResponse searchMovie(@RequestParam(name = "keyword", required = false) String keyword,
                                      @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        ServerResponse serverResponse = movieService.searchMovie(keyword, pageNum, pageSize);
        return serverResponse;
    }

    //发布动态
    @RequestMapping({"/post/insert"})
    public ServerResponse insert(@RequestParam("postContent") String postContent,
                                 HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse insert = homeService.insert(postContent, userInfo.getId());
        return insert;
    }

    //查看所有动态
    @RequestMapping({"/", "/index"})
    public ServerResponse selectAllPost() {
        ServerResponse post = homeService.findPost();
        return post;
    }
}
