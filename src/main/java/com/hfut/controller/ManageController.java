package com.hfut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hfut.entity.*;
import com.hfut.service.*;
import com.hfut.util.GLOBAL;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ManageController {

    @Resource(name = "remoteTeachServiceImpl")
    private RemoteTeachService remoteTeachService;
    @Resource(name = "remoteExpServiceImpl")
    private RemoteExpService remoteExpService;
    @Resource(name = "remoteDesignServiceImpl")
    private RemoteDesignService remoteDesignService;
    @Resource(name = "remoteGraServiceImpl")
    private RemoteGraService remoteGraService;
    @Resource(name = "nonLessonServiceImpl")
    private NonLessonService nonLessonService;


    @Resource(name = "localCourseServiceImpl")
    private LocalCourseService localCourseService;
    @Resource(name = "localExpServiceImpl")
    private LocalExpService localExpService;
    @Resource(name = "localDesignServiceImpl")
    private LocalDesignService localDesignService;
    @Resource(name = "localGraPracticeServiceImpl")
    private LocalGraPracticeService localGraPracticeService;
    @Resource(name = "localGraDesignServiceImpl")
    private LocalGraDesignService localGraDesignService;
    @Resource(name = "localPracticeServiceImpl")
    private LocalPracticeService localPracticeService;
    @Resource(name = "localProjectServiceImpl")
    private LocalProjectService localProjectService;
    @Resource(name = "localMatchServiceImpl")
    private LocalMatchService localMatchService;
    @Resource(name = "localNetServiceImpl")
    private LocalNetService localNetService;
    @Resource(name = "exprimentServiceImpl")
    private ExprimentService exprimentService;


    @RequestMapping(value = "/{place}/{type}/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String add(@PathVariable("place") String place, @PathVariable("type") String type, HttpServletRequest request) throws Exception {
        AjaxResult result = new AjaxResult();
        String val = request.getParameter("data");

        System.out.println(val);


        if (val == null) {
            result.failed();
            return JSON.toJSONString(result);
        } else {
            System.out.println(val);

        }

        boolean tag = false;
        Object object;
        String url = "/" + place + "/" + type;
        try {
            switch (url) {
                case GLOBAL.LOCAL_TEACH_PRACTICE:

                    object = JSON.parseObject(val, LPracticeWorkload.class);
                    tag = localPracticeService.insertLoad((LPracticeWorkload) object);
                    break;
                case GLOBAL.LOCAL_TEACH_COURSE:
                    object = JSON.parseObject(val, LocalCourseWorkload.class);
                    tag = localCourseService.insertLoad((LocalCourseWorkload) object);
                    break;
                case GLOBAL.LOCAL_EXPRIMENT:
                    object = JSON.parseObject(val, LocalExpWorkload.class);
                    tag = localExpService.insertLoad((LocalExpWorkload) object);
                    break;
                case GLOBAL.LOCAL_COMPETITION:
                    object = JSON.parseObject(val, LMatchWorkload.class);
                    tag = localMatchService.insertLoad((LMatchWorkload) object);
                    break;
                case GLOBAL.LOCAL_COURSE_DESIGN:
                    object = JSON.parseObject(val, LocalDesignWorkload.class);
                    tag = localDesignService.insertLoad((LocalDesignWorkload) object);
                    break;
                case GLOBAL.LOCAL_EXP:
                    object = JSON.parseObject(val, Expriment.class);
                    tag = exprimentService.insertLoad((Expriment) object);
                    break;
                case GLOBAL.LOCAL_GRADUATE_DESIGN:
                    object = JSON.parseObject(val, LGraDesignWorkload.class);
                    tag = localGraDesignService.insertLoad((LGraDesignWorkload) object);
                    break;
                case GLOBAL.LOCAL_GRADUATE_PRACTICE:
                    object = JSON.parseObject(val, LGraPracticeWorkload.class);
                    tag = localGraPracticeService.insertLoad((LGraPracticeWorkload) object);
                    break;
                case GLOBAL.LOCAL_NET_COURSE:
                    object = JSON.parseObject(val, LNetWorkload.class);
                    tag = localNetService.insertLoad((LNetWorkload) object);
                    break;
                case GLOBAL.LOCAL_PROJECT:
                    object = JSON.parseObject(val, LProjectWorkload.class);
                    tag = localProjectService.insertLoad((LProjectWorkload) object);
                    break;
                case GLOBAL.LOCAL_TRAINAXE:
                    object = JSON.parseObject(val, LocalExpWorkload.class);
                    /*
                    TODO
                    tag = localCourseService.insertLoad(object);*/
                    break;
                case GLOBAL.LOCAL_PUBLISH_TEXTBOOK:
                    /*
                    TODO
                    tag = localCourseService.insertLoad(object);*/
                    break;
                case GLOBAL.REMOTE_TEACH_COURSE:
                    object = JSON.parseObject(val, RemoteTeachWorkload.class);
                    tag = remoteTeachService.insertLoad((RemoteTeachWorkload) object);
                    break;
                case GLOBAL.REMOTE_COURSE_DESIGN:
                    object = JSON.parseObject(val, RemoteDesignWorkload.class);
                    tag = remoteDesignService.insertLoad((RemoteDesignWorkload) object);
                    break;
                case GLOBAL.REMOTE_EXPRIMENT:
                    object = JSON.parseObject(val, RemoteExpWorkload.class);
                    tag = remoteExpService.insertLoad((RemoteExpWorkload) object);
                    break;
                case GLOBAL.REMOTE_GRADUATE_DESIGN:
                    object = JSON.parseObject(val, RemoteGraduateWorkload.class);
                    tag = remoteGraService.insertLoad((RemoteGraduateWorkload) object);
                    break;
                case GLOBAL.REMOTE_NON_LESSON:
                    object = JSON.parseObject(val, RemoteNonLesson.class);
                    tag = nonLessonService.insertLoad((RemoteNonLesson) object);
                    break;
                default:

            }
            if (tag) {
                result.ok();
                result.setMsg("插入成功！");
            } else {
                result.failed();
                result.setMsg("插入失败，请检查数据！");
            }

        } catch (NullPointerException nop) {
            nop.printStackTrace();
            result.failed();
            result.setMsg("插入失败，请检查数据！");
        }

        return JSON.toJSONString(result);

    }

    @RequestMapping(value = "/{place}/{type}/delete",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String moveout(@PathVariable("place") String place, @PathVariable("type") String type, HttpServletRequest request) throws Exception {
        AjaxResult result = new AjaxResult();
        String val = request.getParameter("data");

        System.out.println(val);


        List list = JSON.parseArray(val);
        if (list == null) {
            result.failed();
            return JSON.toJSONString(result);
        } else {
            System.out.println(list.toString());

        }

        boolean tag = false;

        String url = "/" + place + "/" + type;

        try {
            switch (url) {
                case GLOBAL.LOCAL_TEACH_PRACTICE:
                    tag = localPracticeService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_TEACH_COURSE:
                    tag = localCourseService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_EXPRIMENT:
                    tag = localExpService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_COMPETITION:
                    tag = localMatchService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_COURSE_DESIGN:
                    tag = localDesignService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_EXP:
                    tag = exprimentService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_GRADUATE_DESIGN:
                    tag = localGraDesignService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_GRADUATE_PRACTICE:
                    tag = localGraPracticeService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_NET_COURSE:
                    tag = localNetService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_PROJECT:
                    tag = localProjectService.removeLoad(list);
                    break;
                case GLOBAL.LOCAL_TRAINAXE:
                    /*
                    TODO
                    tag = localCourseService.insertLoad(object);*/
                    break;
                case GLOBAL.LOCAL_PUBLISH_TEXTBOOK:
                    /*
                    TODO
                    tag = localCourseService.insertLoad(object);*/
                    break;
                case GLOBAL.REMOTE_TEACH_COURSE:
                    tag = remoteTeachService.removeLoad(list);
                    break;
                case GLOBAL.REMOTE_COURSE_DESIGN:
                    tag = remoteDesignService.removeLoad(list);
                    break;
                case GLOBAL.REMOTE_EXPRIMENT:
                    tag = remoteExpService.removeLoad(list);
                    break;
                case GLOBAL.REMOTE_GRADUATE_DESIGN:
                    tag = remoteGraService.removeLoad(list);
                    break;
                case GLOBAL.REMOTE_NON_LESSON:
                    tag = nonLessonService.removeLoad(list);
                    break;
                default:

            }
            if (tag) {
                result.ok();
                result.setMsg("删除成功！");
            } else {
                result.failed();
                result.setMsg("删除失败，请检查数据！");
            }

        } catch (NullPointerException nop) {
            nop.printStackTrace();
            result.failed();
            result.setMsg("删除失败，请检查数据！");
        }
        return JSON.toJSONString(result);

    }
}
