package com.hfut.mapper;

import com.hfut.entity.RemoteTotal;
import com.hfut.entity.RemoteTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemoteTotalMapper {
    int countByExample(RemoteTotalExample example);

    int deleteByExample(RemoteTotalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RemoteTotal record);

    int insertSelective(RemoteTotal record);

    List<RemoteTotal> selectByExample(RemoteTotalExample example);

    RemoteTotal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RemoteTotal record, @Param("example") RemoteTotalExample example);

    int updateByExample(@Param("record") RemoteTotal record, @Param("example") RemoteTotalExample example);

    int updateByPrimaryKeySelective(RemoteTotal record);

    int updateByPrimaryKey(RemoteTotal record);
}