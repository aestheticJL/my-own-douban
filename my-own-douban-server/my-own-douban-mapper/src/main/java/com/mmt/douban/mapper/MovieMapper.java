package com.mmt.douban.mapper;

import com.mmt.douban.model.Movie;
import com.mmt.douban.model.MovieExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {
    long countByExample(MovieExample example);

    int deleteByExample(MovieExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExample(MovieExample example);

    Movie selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    Movie getMovieAllInfById(Integer id);

    List<Movie> getTopTenOtherMovie();

    List<Movie> getMovieByIDs(@Param("IDs") List<Integer> IDs);

    List<Movie> getHighScoreMovie();

    List<Movie> getTopTenTypeMovie(@Param("type") String type);
}