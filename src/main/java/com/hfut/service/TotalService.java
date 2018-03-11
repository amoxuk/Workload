package com.hfut.service;

import java.util.List;

public interface TotalService {

    Integer REMOTE = 1;
    Integer LOCAL = 2;

    List getRemoteTotal(Integer years);


    List getLocalTotal(Integer years);

    List getTotalByName(Integer years, String teacher, Integer local);
}
