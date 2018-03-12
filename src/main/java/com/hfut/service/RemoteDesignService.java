package com.hfut.service;

import com.hfut.entity.RemoteDesignWorkload;

import java.util.List;

public interface RemoteDesignService {

    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(RemoteDesignWorkload workload)  throws Exception;

    boolean removeLoad(Integer id)  throws Exception;

    List<RemoteDesignWorkload> insertLoadByList(List<RemoteDesignWorkload> list) throws Exception;

    boolean insertLoad(RemoteDesignWorkload workload) throws Exception;

    boolean removeLoad(List list);

    List<RemoteDesignWorkload> getList(Integer years, String teacher, Integer page, Integer limit);
}
