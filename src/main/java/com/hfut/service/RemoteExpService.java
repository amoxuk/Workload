package com.hfut.service;

import com.hfut.entity.RemoteExpWorkload;

import java.util.List;

public interface RemoteExpService {


    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(RemoteExpWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(RemoteExpWorkload workload) throws Exception;

    List<RemoteExpWorkload> insertLoadByList(List<RemoteExpWorkload> list) throws Exception;

    boolean removeLoad(List list);

    List<RemoteExpWorkload> getList(Integer years, String teacher, Integer page, Integer limit);
}
