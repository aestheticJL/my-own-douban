package com.mmt.douban.mapper;

import com.mmt.douban.model.Actor;
import com.mmt.douban.model.MovieActor;
import com.mmt.douban.model.MovieActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieActorMapper {
    long countByExample(MovieActorExample example);

    int deleteByExample(MovieActorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MovieActor record);

    int insertSelective(MovieActor record);

    List<MovieActor> selectByExample(MovieActorExample example);

    MovieActor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MovieActor record, @Param("example") MovieActorExample example);

    int updateByExample(@Param("record") MovieActor record, @Param("example") MovieActorExample example);

    int updateByPrimaryKeySelective(MovieActor record);

    int updateByPrimaryKey(MovieActor record);

    int addMA(@Param("mid") Integer mid, @Param("actors") List<Actor> actors);
}