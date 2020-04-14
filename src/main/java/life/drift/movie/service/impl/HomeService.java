package life.drift.movie.service.impl;

import com.github.pagehelper.PageHelper;
import life.drift.movie.mapper.MovieExtMapper;
import life.drift.movie.mapper.MovieMapper;
import life.drift.movie.model.Movie;
import life.drift.movie.service.IHomeService;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService implements IHomeService {
    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieExtMapper movieExtMapper;


}
