package com.hfut.controller.total;

import com.alibaba.fastjson.JSON;
import com.hfut.entity.AjaxResult;
import com.hfut.service.TotalService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TotalController {
    @Resource(name = "totalServiceImpl")
    private TotalService totalService;



    @RequestMapping(value = "/total/local/{years}/{workload}/{teacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf8")
    @ResponseBody
    public String getLocalTotal(@PathVariable("years") Integer years, @PathVariable("workload") String workload, @PathVariable("teacher") String teacher) {
        AjaxResult result = new AjaxResult();
        if (!"all".equals(teacher)) {
            result.setData(totalService.getTotalByName(years, teacher, TotalService.LOCAL));

        } else {
            result.setData(totalService.getLocalTotal(years));

        }
        result.ok();
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/total/remote/{years}/{workload}/{teacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf8")

    @ResponseBody
    public String getRemoteTotal(@PathVariable("years") Integer years, @PathVariable("workload") String workload, @PathVariable("teacher") String teacher) {
        AjaxResult result = new AjaxResult();
        if (!"all".equals(teacher)) {
            result.setData(totalService.getTotalByName(years, teacher,TotalService.REMOTE));
        } else {
            result.setData(totalService.getRemoteTotal(years));
        }
        result.ok();

        return JSON.toJSONString(result);
    }
}
