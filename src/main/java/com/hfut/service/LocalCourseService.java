package com.hfut.service;

import com.hfut.entity.LocalCourseWorkload;

import java.util.List;

public interface LocalCourseService {


    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(LocalCourseWorkload workload) throws Exception;

    boolean removeLoad(Integer id);

    boolean insertLoad(LocalCourseWorkload workload) throws Exception;

    List<LocalCourseWorkload> insertLoadByList(List<LocalCourseWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;

    List<LocalCourseWorkload> getList(Integer years, String teacher, Integer page, Integer limit) throws Exception;

}
