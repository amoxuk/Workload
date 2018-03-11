package com.hfut.mapper;

import com.hfut.entity.LocalTotal;
import com.hfut.entity.LocalTotalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocalTotalMapper {
    int countByExample(LocalTotalExample example);

    int deleteByExample(LocalTotalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LocalTotal record);

    int insertSelective(LocalTotal record);

    List<LocalTotal> selectByExample(LocalTotalExample example);

    LocalTotal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LocalTotal record, @Param("example") LocalTotalExample example);

    int updateByExample(@Param("record") LocalTotal record, @Param("example") LocalTotalExample example);

    int updateByPrimaryKeySelective(LocalTotal record);

    int updateByPrimaryKey(LocalTotal record);
}