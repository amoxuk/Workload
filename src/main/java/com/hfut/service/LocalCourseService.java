package com.hfut.service;

import com.hfut.entity.LocalCourseWorkload;

import java.util.List;

public interface LocalCourseService {


    List<LocalCourseWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(LocalCourseWorkload workload) throws Exception;

    boolean removeLoad(Integer id);

    boolean insertLoad(LocalCourseWorkload workload) throws Exception;

    List<LocalCourseWorkload> insertLoadByList(List<LocalCourseWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;
}
