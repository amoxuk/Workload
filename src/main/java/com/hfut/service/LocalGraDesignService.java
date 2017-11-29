package com.hfut.service;

import com.hfut.entity.LGraDesignWorkload;

import java.util.List;

public interface LocalGraDesignService {
    List<LGraDesignWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(LGraDesignWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LGraDesignWorkload workload) throws Exception;

    List<LGraDesignWorkload> insertLoadByList(List<LGraDesignWorkload> list) throws Exception;

    boolean removeLoad(List list);
}
