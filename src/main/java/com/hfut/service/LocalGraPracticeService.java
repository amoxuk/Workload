package com.hfut.service;

import com.hfut.entity.LGraPracticeWorkload;

import java.util.List;

public interface LocalGraPracticeService {

    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(LGraPracticeWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LGraPracticeWorkload workload) throws Exception;

    List<LGraPracticeWorkload> insertLoadByList(List<LGraPracticeWorkload> list) throws Exception;

    boolean removeLoad(List list);

    List<LGraPracticeWorkload> getList(Integer years, String teacher, Integer page, Integer limit) throws Exception;
}
