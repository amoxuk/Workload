package com.hfut.controller.remote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hfut.entity.AjaxResult;
import com.hfut.entity.RemoteNonLesson;
import com.hfut.service.NonLessonService;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class RemoteNonLessonController {
    @Resource(name = "nonLessonServiceImpl")
    private NonLessonService service;

    Logger logger = Logger.getLogger(RemoteNonLessonController.class);
    @RequestMapping(value = "/RNonLesson/{years}/{teacher}",
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

        List<RemoteNonLesson> list = service.getList(years, teacher, page, limit);

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCount(service.getCount(years, teacher));
        ajaxResult.ok();
        ajaxResult.setData(list);
        return JSON.toJSONString(ajaxResult);
    }
    @RequestMapping(value = "/nonLesson/save",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String  updataRecord(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();
        AjaxResult ajaxResult = new AjaxResult();
        if (req.get("data") != null) {
            JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
            RemoteNonLesson workload;
            workload = JSON.parseObject(String.valueOf(jsonObject), RemoteNonLesson.class);
            logger.info(workload.toString());

            if (service.updateLoad(workload)) {
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

    @RequestMapping(value = "/nonLesson/remove",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String listRemove(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();

        AjaxResult ajaxResult = new AjaxResult();
        if (req.get("data") != null) {
            JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
            RemoteNonLesson workload;
            workload = JSON.parseObject(String.valueOf(jsonObject), RemoteNonLesson.class);
            if (service.removeLoad(workload.getId())) {
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
