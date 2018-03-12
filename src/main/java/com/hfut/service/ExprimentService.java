package com.hfut.service;

import com.hfut.entity.Expriment;

import java.util.List;

public interface ExprimentService {
        int getCount(Integer years, String teacher) throws Exception;

        boolean updateLoad(Expriment workload) throws Exception;

        boolean removeLoad(Integer id) throws Exception;

        boolean insertLoad(Expriment workload) throws Exception;

        List<Expriment> insertLoadByList(List<Expriment> list) throws Exception;

        boolean removeLoad(List list);

        List<Expriment> getList(Integer years, String teacher, Integer page, Integer limit);
}
