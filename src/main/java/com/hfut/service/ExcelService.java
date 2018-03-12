package com.hfut.service;

import com.hfut.entity.*;
import com.hfut.exception.CustomException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ExcelService {

    List inTeachWorkload(File file) throws CustomException;

    void outTeachWorkload(String file, List<RemoteTeachWorkload> list) throws Exception;

    List inExpWorkLoad(File file) throws IOException;

    void outExpWorkload(String file, List<RemoteExpWorkload> list) throws Exception;

    List inDesignList(File file) throws Exception;

    void outDesignWorkload(String path, List<RemoteDesignWorkload> list) throws Exception;

    void outGraduateWorkload(String path, List<RemoteGraduateWorkload> list) throws Exception;

    List inGraduateWorkload(File file) throws Exception;

    void outLCourseWorkload(String path, List<LocalCourseWorkload> list)throws Exception;

    List inLCourseWorkload(File file) throws Exception;

    List inLExpWorkload(File file) throws Exception;

    void outLExpWorkload(String path, List<LocalExpWorkload> list) throws Exception;

    List inLDesignWorkload(File file) throws Exception;

    void outLDesignWorkload(String path, List<LocalDesignWorkload> list) throws Exception;


    List inLGraPracticeWorkload(File file) throws Exception;


    void outLGraPracticeWorkload(String path, List<LGraPracticeWorkload> list) throws Exception;

    void outLGraDesignWorkload(String path, List<LGraDesignWorkload> list) throws Exception;

    List inLGraDesignWorkload(File file) throws Exception;

    //落地教师教学实习
    List inLPracticeWorkload(File file) throws Exception;
    void outLPracticeDesignWorkload(String path, List<LPracticeWorkload> list) throws Exception;

    void outLProjectWorkload(String path, List<LProjectWorkload> list) throws Exception;
    List inLProjectWorkload(File file) throws Exception;

    void outLMatchWorkload(String path, List<LMatchWorkload> list) throws Exception;
    List inLMatchWorkload(File file) throws Exception;

    void outLNetWorkload(String path, List<LNetWorkload> list) throws Exception;

    List inLNetWorkload(File file) throws Exception;

    void outExpriment(String path, List<Expriment> list) throws Exception;

    List inExpriment(File file) throws Exception;

    void outNonLesson(String path, List<RemoteNonLesson> list) throws Exception;
    List inNonLesson(File file) throws Exception;

}
