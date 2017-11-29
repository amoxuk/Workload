package com.hfut.service;

import com.hfut.entity.LocalExpWorkload;

import java.util.List;

public interface LocalExpService {
    List<LocalExpWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(LocalExpWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LocalExpWorkload workload) throws Exception;

    List<LocalExpWorkload> insertLoadByList(List<LocalExpWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;
}
