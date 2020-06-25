package com.mmt.douban.service;

import com.mmt.douban.mapper.CommentMapper;
import com.mmt.douban.mapper.MovieMapper;
import com.mmt.douban.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeMovieService {
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    CommentMapper commentMapper;

    @Cacheable(cacheNames = "home",key = "#type",unless = "#result==null")
    public List<Movie> getTopTenMovieByType(String type) {
        if ("其他".equals(type)) {
            return movieMapper.getTopTenOtherMovie();
        } else {
            return movieMapper.getTopTenTypeMovie(type);
        }
    }

    @Cacheable(cacheNames = "movie",key = "#id",unless = "#result==null")
    public Movie getMovieAllInfById(Integer id) {
        return movieMapper.getMovieAllInfById(id);
    }

    @Cacheable(cacheNames = "home",key = "'HighScoreMovie'",unless = "#result==null")
    public List<Movie> getHighScoreMovie() {
        return movieMapper.getHighScoreMovie();
    }

    @Cacheable(cacheNames = "home",key = "'NewCommentMovie'",unless = "#result==null")
    public List<Movie> getNewCommentMovie() {
        List<Integer> IDs = commentMapper.getNewCommentMovieId();
        return movieMapper.getMovieByIDs(IDs);
    }

    @Cacheable(cacheNames = "home",key = "'MyHighScoreMovie'",unless = "#result==null")
    public List<Movie> getMyHighScoreMovie() {
        List<Integer> IDs = commentMapper.getMyHighScoreMovieId();
        return movieMapper.getMovieByIDs(IDs);
    }
}
