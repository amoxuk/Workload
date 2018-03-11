package com.hfut.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TotalService {

    Integer LOCAL = 1;
    Integer  REMOTE  = 2;

    List getRemoteTotal(Integer years);


    List getLocalTotal(Integer years);

    List getTotalByName(Integer years, String teacher, Integer local);


    String download(HttpServletRequest request, Integer years, String teacher, Integer local) throws Exception;
}
