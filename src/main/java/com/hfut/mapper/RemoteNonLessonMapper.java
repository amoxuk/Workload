package com.hfut.mapper;

import com.hfut.entity.RemoteNonLesson;
import com.hfut.entity.RemoteNonLessonExample;
import com.hfut.entity.RemoteNonLessonKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RemoteNonLessonMapper {
    int countByExample(RemoteNonLessonExample example);

    int deleteByExample(RemoteNonLessonExample example);

    int deleteByPrimaryKey(RemoteNonLessonKey key);

    int insert(RemoteNonLesson record);

    int insertSelective(RemoteNonLesson record);

    List<RemoteNonLesson> selectByExample(RemoteNonLessonExample example);

    RemoteNonLesson selectByPrimaryKey(RemoteNonLessonKey key);

    int updateByExampleSelective(@Param("record") RemoteNonLesson record, @Param("example") RemoteNonLessonExample example);

    int updateByExample(@Param("record") RemoteNonLesson record, @Param("example") RemoteNonLessonExample example);

    int updateByPrimaryKeySelective(RemoteNonLesson record);

    int updateByPrimaryKey(RemoteNonLesson record);
}