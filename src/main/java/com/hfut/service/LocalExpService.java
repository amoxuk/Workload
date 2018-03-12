package com.hfut.service;

import com.hfut.entity.LocalExpWorkload;

import java.util.List;

public interface LocalExpService {

    int getCount(Integer years,String teacher) throws Exception;

    boolean updateLoad(LocalExpWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LocalExpWorkload workload) throws Exception;

    List<LocalExpWorkload> insertLoadByList(List<LocalExpWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;

    List<LocalExpWorkload> getList(Integer years,String teacher, Integer page, Integer limit) throws Exception;
}
