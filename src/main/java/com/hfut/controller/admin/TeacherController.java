package com.hfut.controller.admin;

import com.alibaba.fastjson.JSON;
import com.hfut.entity.AjaxResult;
import com.hfut.entity.Teacher;
import com.hfut.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class TeacherController {
    private Logger logger = Logger.getLogger(TeacherController.class);

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher/list/{type}",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = RequestMethod.GET)
    @ResponseBody
    public String getTeacher(HttpServletRequest request, @PathVariable("type") String type) {
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
        AjaxResult result;


        result = new AjaxResult<Teacher>();
        result.setData(teacherService.getTeacherList(type, page, limit));

        return result.toString();
    }

    @RequestMapping(value = "/teacher/{college}/{teacher}/{type}",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = RequestMethod.GET)
    @ResponseBody
    public String getTeacher(HttpServletRequest request, @PathVariable("college") String college, @PathVariable("teacher") String teacher, @PathVariable("type") Integer type) {
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
        AjaxResult result;


        result = new AjaxResult<Teacher>();
        result.setData(teacherService.getTeacherList(college, teacher,type, page, limit));

        return result.toString();
    }

    @RequestMapping(value = "/teacher/delete",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = RequestMethod.POST)
    @ResponseBody
    public String deleteTeacher(Teacher teacher) {
        AjaxResult result = new AjaxResult();
        if (teacher != null) {
            teacherService.deleteTeacher(teacher.getName());
            result.ok();
        } else {
            result.failed();
            result.setMsg("资源错误");
        }
        return result.toString();
    }

    @RequestMapping(value = "/teacher/delete/list",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = RequestMethod.POST)
    @ResponseBody
    public String deleteTeacher(@RequestParam(name = "data") String s) {
        ArrayList<Integer> list = (ArrayList<Integer>) JSON.parseArray(s, Integer.class);
        AjaxResult result = new AjaxResult();
        if (teacherService.deleteTeacher(list)) {
            result.ok();
        } else {
            result.failed();
            result.setMsg("用户不存在");
        }
        return result.toString();
    }

    @RequestMapping(value = "/teacher/add/{location}",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = RequestMethod.POST)
    @ResponseBody
    public String addTeacher(@RequestParam(name = "data") String req, @PathVariable("location") Integer location) {
        Teacher teacher = JSON.parseObject(req, Teacher.class);
        AjaxResult result = new AjaxResult();

        teacher.setLocation(1);

        logger.info(teacher);

        try {
            if (teacher != null) {
                if (location == 0) {
                    teacher.setLocation(0);
                } else {
                    teacher.setLocation(1);
                }
                teacherService.addTeacher(teacher);
                result.ok();
            } else {
                result.failed();
                result.setMsg("资源错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.failed();
            result.setMsg(e.getMessage());
            return result.toString();
        }
        return result.toString();

    }

    @RequestMapping(value = "/teacher",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = RequestMethod.POST)
    @ResponseBody
    public String updateTeacher(Teacher teacher) {

        AjaxResult result = new AjaxResult();

        logger.info(teacher);

        try {
            if (teacher != null) {
                if (teacherService.updateTeacher(teacher)) {
                    result.ok();
                } else {
                    result.setMsg("更新失败");
                    result.failed();
                }

            } else {
                result.failed();
                result.setMsg("资源错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.failed();
            result.setMsg(e.getMessage());
            return result.toString();
        }
        return result.toString();


    }


}
