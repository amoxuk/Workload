package com.hfut.service;

import com.hfut.entity.RemoteExpWorkload;

import java.util.List;

public interface RemoteExpService {

    List<RemoteExpWorkload> findAllLoad(Integer offset, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(RemoteExpWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(RemoteExpWorkload workload) throws Exception;

    List<RemoteExpWorkload> insertLoadByList(List<RemoteExpWorkload> list) throws Exception;
}
