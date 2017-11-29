package com.hfut.service;

import com.hfut.entity.LMatchWorkload;

import java.util.List;

public interface LocalMatchService {
    List<LMatchWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(LMatchWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LMatchWorkload workload) throws Exception;

    List<LMatchWorkload> insertLoadByList(List<LMatchWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;
}
