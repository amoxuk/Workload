package com.hfut.service;

import com.hfut.entity.Teacher;

public interface TeacherService {
    Teacher findByName(String name) throws Exception;

}
