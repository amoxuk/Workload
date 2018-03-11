package com.hfut.service;

import com.hfut.entity.Expriment;

import java.util.List;

public interface ExprimentService {
        List<Expriment> findAllLoad(Integer page, Integer limit) throws Exception;

        int getCount() throws Exception;

        boolean updateLoad(Expriment workload) throws Exception;

        boolean removeLoad(Integer id) throws Exception;

        boolean insertLoad(Expriment workload) throws Exception;

        List<Expriment> insertLoadByList(List<Expriment> list) throws Exception;

        boolean removeLoad(List list);
}
