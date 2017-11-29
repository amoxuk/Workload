package com.hfut.service;

import com.hfut.entity.RemoteGraduateWorkload;

import java.util.List;

public interface RemoteGraService {

    List<RemoteGraduateWorkload> findAllLoad(Integer offset, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(RemoteGraduateWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    List<RemoteGraduateWorkload> insertLoadByList(List<RemoteGraduateWorkload> list) throws Exception;

    boolean insertLoad(RemoteGraduateWorkload workload) throws Exception;

    boolean removeLoad(List list);
}
