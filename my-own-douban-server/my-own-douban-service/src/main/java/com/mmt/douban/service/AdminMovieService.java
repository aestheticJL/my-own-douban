package com.mmt.douban.service;

import com.mmt.douban.mapper.*;
import com.mmt.douban.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminMovieService {
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    DirectorMapper directorMapper;
    @Autowired
    WriterMapper writerMapper;
    @Autowired
    ActorMapper actorMapper;
    @Autowired
    MovieDirectorMapper movieDirectorMapper;
    @Autowired
    MovieWriterMapper movieWriterMapper;
    @Autowired
    MovieActorMapper movieActorMapper;

    @Transactional
    @CacheEvict(cacheNames = "home", allEntries = true)
    public boolean addMovieInf(Movie movie) {
        movieMapper.insertSelective(movie);
        List<Director> directors = movie.getDirectors();
        List<Writer> writers = movie.getWriters();
        List<Actor> actors = movie.getActors();
        directorMapper.addDirectors(directors);
        writerMapper.addWriters(writers);
        actorMapper.addActors(actors);
        Integer mid = movie.getId();
        movieDirectorMapper.addMD(mid, directors);
        movieWriterMapper.addMW(mid, writers);
        movieActorMapper.addMA(mid, actors);
        return true;
    }

    public List<Movie> getAllMovie() {
        return movieMapper.selectByExample(new MovieExample());
    }

    public Movie getMovieById(Integer id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(cacheNames = "home", allEntries = true),
            @CacheEvict(cacheNames = "movie", key = "#id")
    })
    public boolean deleteMovie(Integer id) {
        MovieActorExample movieActorExample = new MovieActorExample();
        movieActorExample.createCriteria().andMidEqualTo(id);
        movieActorMapper.deleteByExample(movieActorExample);
        MovieWriterExample movieWriterExample = new MovieWriterExample();
        movieWriterExample.createCriteria().andMidEqualTo(id);
        movieWriterMapper.deleteByExample(movieWriterExample);
        MovieDirectorExample movieDirectorExample = new MovieDirectorExample();
        movieDirectorExample.createCriteria().andMidEqualTo(id);
        movieDirectorMapper.deleteByExample(movieDirectorExample);
//        movieActorMapper.deleteActorAndAssociated(id);
//        movieWriterMapper.deleteWriterAndAssociated(id);
//        movieDirectorMapper.deleteDirectorAndAssociated(id);
        movieMapper.deleteByPrimaryKey(id);
        return true;
    }
}
