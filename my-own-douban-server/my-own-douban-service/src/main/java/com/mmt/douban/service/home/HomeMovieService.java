package com.mmt.douban.service.home;

import com.mmt.douban.mapper.CommentMapper;
import com.mmt.douban.mapper.MovieMapper;
import com.mmt.douban.model.Movie;
import com.mmt.douban.model.MovieExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "c1")
public class HomeMovieService {
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    CommentMapper commentMapper;

    @Cacheable(key = "#type")
    public List<Movie> getMovieByType(String type) {
        if ("其他".equals(type)) {
            return movieMapper.getOtherMovie();
        } else {
            MovieExample movieExample = new MovieExample();
            movieExample.createCriteria().andCountriesLike("%" + type + "%");
            return movieMapper.selectByExample(movieExample);
        }
    }

    public Movie getMovieAllInfById(Integer id) {
        return movieMapper.getMovieAllInfById(id);
    }

    @Cacheable(key = "getMethodName()")
    public List<Movie> getHighScoreMovie() {
        return movieMapper.getHighScoreMovie();
    }

    @Cacheable(key = "getMethodName()")
    public List<Movie> getNewCommentMovie() {
        List<Integer> IDs = commentMapper.getNewCommentMovieId();
        return movieMapper.getMovieByIDs(IDs);
    }

    @Cacheable(key = "getMethodName()")
    public List<Movie> getMyHighScoreMovie() {
        List<Integer> IDs = commentMapper.getMyHighScoreMovieId();
        return movieMapper.getMovieByIDs(IDs);
    }
}
