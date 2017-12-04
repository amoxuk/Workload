package com.hfut.mapper;

import com.hfut.entity.RemoteTeachWorkload;
import com.hfut.entity.RemoteTeachWorkloadExample;
import com.hfut.entity.RemoteTeachWorkloadKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemoteTeachWorkloadMapper {
    int countByExample(RemoteTeachWorkloadExample example);

    int deleteByExample(RemoteTeachWorkloadExample example);

    int deleteByPrimaryKey(RemoteTeachWorkloadKey key);

    int insert(RemoteTeachWorkload record);

    int insertSelective(RemoteTeachWorkload record);

    List<RemoteTeachWorkload> selectByExample(RemoteTeachWorkloadExample example);

    RemoteTeachWorkload selectByPrimaryKey(RemoteTeachWorkloadKey key);

    int updateByExampleSelective(@Param("record") RemoteTeachWorkload record, @Param("example") RemoteTeachWorkloadExample example);

    int updateByExample(@Param("record") RemoteTeachWorkload record, @Param("example") RemoteTeachWorkloadExample example);

    int updateByPrimaryKeySelective(RemoteTeachWorkload record);

    int updateByPrimaryKey(RemoteTeachWorkload record);
}