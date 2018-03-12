package com.hfut.service;

import com.hfut.entity.RemoteGraduateWorkload;

import java.util.List;

public interface RemoteGraService {


    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(RemoteGraduateWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    List<RemoteGraduateWorkload> insertLoadByList(List<RemoteGraduateWorkload> list) throws Exception;

    boolean insertLoad(RemoteGraduateWorkload workload) throws Exception;

    boolean removeLoad(List list);

    List<RemoteGraduateWorkload> getList(Integer years, String teacher, Integer page, Integer limit);
}
