package com.hfut.controller;

import com.alibaba.fastjson.JSON;
import com.hfut.entity.AjaxResult;
import com.hfut.exception.CustomException;
import com.hfut.service.*;
import com.hfut.service.impl.ExcelServiceImpl;
import com.hfut.util.ToolKit;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadExcel {
    @Resource(name = "remoteTeachServiceImpl")
    private RemoteTeachService remoteTeachService;
    @Resource(name = "remoteExpServiceImpl")
    private RemoteExpService remoteExpService;
    @Resource(name = "remoteDesignServiceImpl")
    private RemoteDesignService designService;
    @Resource(name = "remoteGraServiceImpl")
    private RemoteGraService graService;
    @Resource(name = "excelServiceImpl")
    private ExcelService excelService;
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
    @Resource(name = "nonLessonServiceImpl")
    private NonLessonService nonLessonService;


    @RequestMapping(value = "/uploadExcel",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String importExcel(@RequestParam(value = "file", required = false)
                                      MultipartFile buildInfo,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        try {
            if (buildInfo != null) {
                String path = request.getSession().getServletContext().getRealPath("/upload") + File.separatorChar + buildInfo.getOriginalFilename();
                File file = ToolKit.getFileFromBytes(buildInfo.getBytes(), path);//需要先保存在本地
                List list = null;

                String type = request.getParameter("type");
                System.out.println(type);

                switch (type) {
                    case ExcelServiceImpl.REMOTE_TEACH:
                        list = excelService.inTeachWorkload(file);//这里是解析excel文件
                        list = remoteTeachService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.REMOTE_EXP:
                        list = excelService.inExpWorkLoad(file);//这里是解析excel文件
                        list = remoteExpService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.REMOTE_DESIGN:
                        list =excelService.inDesignList(file);
                        list = designService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.REMOTE_GRA:
                        list =excelService.inGraduateWorkload(file);
                        list = graService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_COURSE:
                        list =excelService.inLCourseWorkload(file);
                        list = localCourseService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_EXP:
                        list =excelService.inLExpWorkload(file);
                        list = localExpService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_DESIGN:
                        list =excelService.inLDesignWorkload(file);
                        list = localDesignService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_GRA_PRACTICE:
                        list =excelService.inLGraPracticeWorkload(file);
                        list = localGraPracticeService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_GRA_DESIGN:
                        list =excelService.inLGraDesignWorkload(file);
                        list = localGraDesignService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_PRACTICE:
                        list =excelService.inLPracticeWorkload(file);
                        list = localPracticeService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_PROJECT:
                        list =excelService.inLProjectWorkload(file);
                        list = localProjectService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_MATCH:
                        list =excelService.inLMatchWorkload(file);
                        list = localMatchService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.LOACAL_NET:
                        list =excelService.inLNetWorkload(file);
                        list = localNetService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.EXP:
                        list = excelService.inExpriment(file);
                        list = exprimentService.insertLoadByList(list);
                        break;
                    case ExcelServiceImpl.REMOTE_NON_LESSON:
                        list = excelService.inNonLesson(file);
                        list = nonLessonService.insertLoadByList(list);
                        break;
                    default:
                }
                ToolKit.deleteFile(path);
                AjaxResult ajaxResult = new AjaxResult();
                //这里做的是一个插入数据库功能
                if (list.size() == 0) {
                    ajaxResult.ok();
                    ajaxResult.setMsg("导入成功");
                } else {
                    ajaxResult.setMsg("导入数据产生错误！");
                    ajaxResult.failed();
                    ajaxResult.setData(list);
                }

                return JSON.toJSONString(ajaxResult);
            }

        } catch (CustomException | IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
