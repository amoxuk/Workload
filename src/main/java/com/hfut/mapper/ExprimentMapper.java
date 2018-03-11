package com.hfut.mapper;

import com.hfut.entity.Expriment;
import com.hfut.entity.ExprimentExample;
import com.hfut.entity.ExprimentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExprimentMapper {
    int countByExample(ExprimentExample example);

    int deleteByExample(ExprimentExample example);

    int deleteByPrimaryKey(ExprimentKey key);

    int insert(Expriment record);

    int insertSelective(Expriment record);

    List<Expriment> selectByExample(ExprimentExample example);

    Expriment selectByPrimaryKey(ExprimentKey key);

    int updateByExampleSelective(@Param("record") Expriment record, @Param("example") ExprimentExample example);

    int updateByExample(@Param("record") Expriment record, @Param("example") ExprimentExample example);

    int updateByPrimaryKeySelective(Expriment record);

    int updateByPrimaryKey(Expriment record);
}