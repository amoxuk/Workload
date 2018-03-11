package com.hfut.mapper;

import com.hfut.entity.LocalTotalView;
import com.hfut.entity.LocalTotalViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalTotalViewMapper {
    int countByExample(LocalTotalViewExample example);

    int deleteByExample(LocalTotalViewExample example);

    int insert(LocalTotalView record);

    int insertSelective(LocalTotalView record);

    List<LocalTotalView> selectByExample(LocalTotalViewExample example);

    int updateByExampleSelective(@Param("record") LocalTotalView record, @Param("example") LocalTotalViewExample example);

    int updateByExample(@Param("record") LocalTotalView record, @Param("example") LocalTotalViewExample example);
}