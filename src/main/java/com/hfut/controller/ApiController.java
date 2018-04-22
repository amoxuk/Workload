package com.hfut.controller;

import com.hfut.entity.AjaxResult;
import com.hfut.entity.Total;
import com.hfut.service.TotalService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class ApiController {
    @Resource(name = "totalServiceImpl")
    private TotalService totalService;

    @RequestMapping(
            value = "/api/total/{year}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"
    )
    @ResponseBody
    public String getYearTeacherTotal(HttpServletResponse response, @PathVariable("year") Integer year) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        AjaxResult<List<Total>> ajaxResult = new AjaxResult<>();
        List<Total> list = totalService.getTotalByYear(year);
        ajaxResult.setData(list);
        return ajaxResult.toString();
    }
    @RequestMapping(
            value = "/api/total/{teacher}/{year}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"
    )
    @ResponseBody
    public String getTeacherTotal(HttpServletResponse response, @PathVariable("teacher") String teacher, @PathVariable("year") Integer year) throws UnsupportedEncodingException {
        AjaxResult<Double> ajaxResult = new AjaxResult<>();
        teacher = URLDecoder.decode(teacher, "utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*");

        Double total = totalService.getTotalByNameYear(teacher, year);

        ajaxResult.setData(total);
        return ajaxResult.toString();
    }

}
