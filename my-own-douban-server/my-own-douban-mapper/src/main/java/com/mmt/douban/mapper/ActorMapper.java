package com.mmt.douban.mapper;

import com.mmt.douban.model.Actor;
import com.mmt.douban.model.ActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActorMapper {
    long countByExample(ActorExample example);

    int deleteByExample(ActorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Actor record);

    int insertSelective(Actor record);

    List<Actor> selectByExample(ActorExample example);

    Actor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Actor record, @Param("example") ActorExample example);

    int updateByExample(@Param("record") Actor record, @Param("example") ActorExample example);

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);

    int addActors(@Param("actors") List<Actor> actors);
}