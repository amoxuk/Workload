package com.hfut.controller.remote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hfut.entity.AjaxResult;
import com.hfut.entity.RemoteTeachWorkload;
import com.hfut.service.RemoteTeachService;
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

public class RemoteCourseController {
    @Resource(name = "remoteTeachServiceImpl")
    private RemoteTeachService teachService;

    @RequestMapping(value = "/RTeach/{years}/{teacher}",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getLoadList(HttpServletRequest request, @PathVariable("years") Integer years, @PathVariable("teacher") String teacher) throws Exception {
        String limitParam = request.getParameter("limit");
        String pageParam = request.getParameter("page");
        Integer page, limit;

        if (limitParam == null) {
            limit = 30;
        } else {
            limit = Integer.valueOf(limitParam);
        }
        if (pageParam == null) {
            page = 0;
        } else {
            page = (Integer.valueOf(pageParam) - 1) * limit;
        }
        System.out.println(page + " " + limit);

        List<RemoteTeachWorkload> list = teachService.getList(years,teacher,page, limit);

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCount(teachService.getCount(years,teacher));
        ajaxResult.ok();
        ajaxResult.setData(list);
        String json = JSON.toJSONString(ajaxResult);
        return json;
    }

    @RequestMapping(value = "/saveRemote",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String saveRemote(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();
        AjaxResult ajaxResult = new AjaxResult();
        JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
        RemoteTeachWorkload workload;
        workload = JSON.parseObject(String.valueOf(jsonObject), RemoteTeachWorkload.class);
        if (teachService.updateLoad(workload)) {
            ajaxResult.ok();
            ajaxResult.setMsg("保存成功");
        } else {
            ajaxResult.failed();
            ajaxResult.setMsg("保存失败");
        }

        return JSON.toJSONString(ajaxResult);
    }

    @RequestMapping(value = "/removeRemote",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String removeRemote(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();

        AjaxResult ajaxResult = new AjaxResult();

        JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
        RemoteTeachWorkload workload;
        workload = JSON.parseObject(String.valueOf(jsonObject), RemoteTeachWorkload.class);
        if (teachService.removeLoad(workload.getId())) {
            ajaxResult.ok();
            ajaxResult.setMsg("删除成功");
        } else {
            ajaxResult.failed();
            ajaxResult.setMsg("删除失败");
        }
        return JSON.toJSONString(ajaxResult);

    }
}
