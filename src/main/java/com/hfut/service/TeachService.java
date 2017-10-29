package com.hfut.service;

import com.hfut.entity.WorkLoad;

import java.util.List;

public interface TeachService {
    List<WorkLoad> findAllWorkLoad(int page, int limit) throws Exception;

    boolean inserAllWorkLoad(List<WorkLoad> workLoads) throws Exception;

    boolean updateWorkLoad(WorkLoad workLoad) throws Exception;

    boolean updateWorkLoad(List<WorkLoad> workLoads) throws Exception;

    WorkLoad findByTeacher(String teacher) throws Exception;

    WorkLoad findByYear(int year) throws Exception;

    int getWorkLoadCount() throws Exception;


}
