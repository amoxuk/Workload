package com.hfut.controller.local;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hfut.entity.AjaxResult;
import com.hfut.entity.LMatchWorkload;
import com.hfut.service.LocalMatchService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MatchController {
    @Resource(name = "localMatchServiceImpl")
    private LocalMatchService matchService;

    @RequestMapping(value = "/LMatch/{years}/{teacher}",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getLoadList(HttpServletRequest request, @PathVariable("years") Integer years, @PathVariable("teacher") String teacher) throws Exception {
        String limitParam = request.getParameter("limit");
        String pageParam = request.getParameter("page");
        Integer page, limit;
        if (limitParam == null) {
            limit = 10;
        } else {
            limit = Integer.valueOf(limitParam);
        }
        if (pageParam == null) {
            page = 0;
        } else {
            page = (Integer.valueOf(pageParam) - 1) * limit;
        }
        System.out.println(page + " " + limit);

        List<LMatchWorkload> list = matchService.getList(years, teacher, page, limit);

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCount(matchService.getCount(years, teacher));
        ajaxResult.ok();
        ajaxResult.setData(list);
        String json = JSON.toJSONString(ajaxResult);
        return json;
    }

    @RequestMapping(value = "/saveLocalMatch",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String saveLoad(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();
        AjaxResult ajaxResult = new AjaxResult();
        if (req.get("data") != null) {
            JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
            LMatchWorkload workload;
            workload = JSON.parseObject(String.valueOf(jsonObject), LMatchWorkload.class);

            if (matchService.updateLoad(workload)) {
                ajaxResult.ok();
                ajaxResult.setMsg("保存成功");
            } else {
                ajaxResult.failed();
                ajaxResult.setMsg("保存失败");
            }
        } else {
            ajaxResult.failed();
            ajaxResult.setMsg("参数错误");
        }
        return JSON.toJSONString(ajaxResult);
    }

    @RequestMapping(value = "/removeLocalMatch",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String removeLoad(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();

        AjaxResult ajaxResult = new AjaxResult();
        if (req.get("data") != null) {
            JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
            LMatchWorkload workload;
            workload = JSON.parseObject(String.valueOf(jsonObject), LMatchWorkload.class);
            if (matchService.removeLoad(workload.getId())) {
                ajaxResult.ok();
                ajaxResult.setMsg("删除成功");
            } else {
                ajaxResult.failed();
                ajaxResult.setMsg("删除失败");
            }
        } else {
            ajaxResult.failed();
            ajaxResult.setMsg("参数错误");
        }
        return JSON.toJSONString(ajaxResult);
    }
}
