package com.hfut.controller.local;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hfut.entity.AjaxResult;
import com.hfut.entity.LGraPracticeWorkload;
import com.hfut.service.LocalGraPracticeService;
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
public class GraPracticeController {
    @Resource(name = "localGraPracticeServiceImpl")
    private LocalGraPracticeService practiceService;

    @RequestMapping(value = "/LGPractice/{years}/{teacher}",
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

        List<LGraPracticeWorkload> list = practiceService.getList(years,teacher,page, limit);

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCount(practiceService.getCount(years,teacher));
        ajaxResult.ok();
        ajaxResult.setData(list);
        String json = JSON.toJSONString(ajaxResult);
        return json;
    }

    @RequestMapping(value = "/saveLocalPractice",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String saveLoad(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();
        AjaxResult ajaxResult = new AjaxResult();
        if (req.get("data") != null) {
            JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
            LGraPracticeWorkload workload;
            workload = JSON.parseObject(String.valueOf(jsonObject), LGraPracticeWorkload.class);

            if (practiceService.updateLoad(workload)) {
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

    @RequestMapping(value = "/removeLocalPractice",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String removeLoad(HttpServletRequest request) throws Exception {
        Map<String, String[]> req = request.getParameterMap();

        AjaxResult ajaxResult = new AjaxResult();
        if (req.get("data") != null) {
            JSONObject jsonObject = JSON.parseObject(String.valueOf(req.get("data")[0]));
            LGraPracticeWorkload workload;
            workload = JSON.parseObject(String.valueOf(jsonObject), LGraPracticeWorkload.class);
            if (practiceService.removeLoad(workload.getId())) {
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
