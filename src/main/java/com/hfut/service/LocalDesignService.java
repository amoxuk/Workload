package com.hfut.service;

import com.hfut.entity.LocalDesignWorkload;

import java.util.List;

public interface LocalDesignService {
    List<LocalDesignWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;


    boolean updateLoad(LocalDesignWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LocalDesignWorkload workload) throws Exception;

    List<LocalDesignWorkload> insertLoadByList(List<LocalDesignWorkload> list) throws Exception;
}
