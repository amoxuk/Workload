package com.hfut.service;

import com.hfut.entity.LProjectWorkload;

import java.util.List;

public interface LocalProjectService {
    List<LProjectWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(LProjectWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LProjectWorkload workload) throws Exception;

    List<LProjectWorkload> insertLoadByList(List<LProjectWorkload> list) throws Exception;

}
