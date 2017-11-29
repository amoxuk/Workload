package com.hfut.service;

import com.hfut.entity.LGraPracticeWorkload;

import java.util.List;

public interface LocalGraPracticeService {
    List<LGraPracticeWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(LGraPracticeWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LGraPracticeWorkload workload) throws Exception;

    List<LGraPracticeWorkload> insertLoadByList(List<LGraPracticeWorkload> list) throws Exception;

    boolean removeLoad(List list);
}
