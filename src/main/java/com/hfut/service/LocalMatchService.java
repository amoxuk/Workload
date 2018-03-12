package com.hfut.service;

import com.hfut.entity.LMatchWorkload;

import java.util.List;

public interface LocalMatchService {
    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(LMatchWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LMatchWorkload workload) throws Exception;

    List<LMatchWorkload> insertLoadByList(List<LMatchWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;

    List<LMatchWorkload> getList(Integer years, String teacher, Integer page, Integer limit);
}
