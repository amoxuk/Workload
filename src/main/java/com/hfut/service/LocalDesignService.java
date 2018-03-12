package com.hfut.service;

import com.hfut.entity.LocalDesignWorkload;

import java.util.List;

public interface LocalDesignService {
    boolean updateLoad(LocalDesignWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LocalDesignWorkload workload) throws Exception;

    List<LocalDesignWorkload> insertLoadByList(List<LocalDesignWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;

    int getCount(Integer years, String teacher);

    List<LocalDesignWorkload> getList(Integer years, String teacher, Integer page, Integer limit);
}
