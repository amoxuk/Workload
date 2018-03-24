package com.hfut.service;

import com.hfut.entity.Teacher;
import com.hfut.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public interface TeacherService {

    List getTeacherList(String type, Integer page, Integer limit);

    void deleteTeacher(String name);

    boolean addTeacher(Teacher teacher) throws CustomException;

    boolean updateTeacher(Teacher teacher) throws CustomException;

    List getTeacherList(String college, String teacher, Integer type, Integer page, Integer limit);

    boolean deleteTeacher(ArrayList<Integer> list);

    List<String> getCollege();
}
