package com.hfut.service;

import com.hfut.entity.RemoteNonLesson;

import java.util.List;

public interface NonLessonService {

    List<RemoteNonLesson> getList(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;


    boolean updateLoad(RemoteNonLesson workload)  throws Exception;

    boolean removeLoad(Integer id)  throws Exception;

    List<RemoteNonLesson> insertLoadByList(List<RemoteNonLesson> list) throws Exception;

    boolean insertLoad(RemoteNonLesson workload) throws Exception;

    boolean removeLoad(List list);
}
