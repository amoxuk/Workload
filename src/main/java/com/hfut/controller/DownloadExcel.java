package com.hfut.controller;

import com.hfut.exception.CustomException;
import com.hfut.service.*;
import com.hfut.service.impl.ExcelServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 * 下载房屋信息模板
 * @author ljr
 * @throws Exception
 */
@Controller
public class DownloadExcel {
    /**
     * 异地导出
     */
    @Resource(name = "remoteTeachServiceImpl")
    private RemoteTeachService teachService;
    @Resource(name = "remoteExpServiceImpl")
    private RemoteExpService expService;
    @Resource(name = "remoteDesignServiceImpl")
    private RemoteDesignService designService;
    @Resource(name = "remoteGraServiceImpl")
    private RemoteGraService graService;
    @Resource(name = "nonLessonServiceImpl")
    private NonLessonService nonLessonService;
    /**
     * 落地导出
     */
    @Resource(name = "localCourseServiceImpl")
    private LocalCourseService localCourseService;
    @Resource(name = "localExpServiceImpl")
    private LocalExpService localExpService;
    @Resource(name = "localGraPracticeServiceImpl")
    private LocalGraPracticeService localGraPracticeService;
    @Resource(name = "localDesignServiceImpl")
    private LocalDesignService localDesignService;
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

    @Resource(name = "excelServiceImpl")
    private ExcelService excelService;

    /**
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downdetail/{type}/{years}/{teacher}",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable("years") Integer years, @PathVariable("teacher") String teacher, @PathVariable("type") String type) throws Exception {

        response.setContentType("text/html;charset=UTF-8");
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        request.setCharacterEncoding("UTF-8");
        String separator = File.separator;
        String rootpath = request.getSession().getServletContext().getRealPath(separator + "upload");
        String fileName = new Date().getTime() + ".xls";
        String path = rootpath + separator + fileName;

        switch (type) {
            case ExcelServiceImpl.REMOTE_TEACH:
                excelService.outTeachWorkload(path, teachService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.REMOTE_EXP:
                excelService.outExpWorkload(path, expService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.REMOTE_DESIGN:
                excelService.outDesignWorkload(path, designService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.REMOTE_GRA:
                excelService.outGraduateWorkload(path, graService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_COURSE:
                excelService.outLCourseWorkload(path, localCourseService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_EXP:
                excelService.outLExpWorkload(path, localExpService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_DESIGN:
                excelService.outLDesignWorkload(path, localDesignService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_GRA_PRACTICE:
                excelService.outLGraPracticeWorkload(path, localGraPracticeService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_GRA_DESIGN:
                excelService.outLGraDesignWorkload(path, localGraDesignService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_PRACTICE:
                excelService.outLPracticeDesignWorkload(path, localPracticeService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_PROJECT:
                excelService.outLProjectWorkload(path, localProjectService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_MATCH:
                excelService.outLMatchWorkload(path, localMatchService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.LOACAL_NET:
                excelService.outLNetWorkload(path, localNetService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.EXP:
                excelService.outExpriment(path, exprimentService.getList(years, teacher, -1,0));
                break;
            case ExcelServiceImpl.REMOTE_NON_LESSON:
                excelService.outNonLesson(path, nonLessonService.getList(years, teacher, -1,0));
                break;
            default:
                return;
        }

        File f = new File(path);
        try {
            response.setContentType("application/x-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Content-Length", String.valueOf(f.length()));
            in = new BufferedInputStream(new FileInputStream(f));
            out = new BufferedOutputStream(response.getOutputStream());
            byte[] data = new byte[1024];
            int len = 0;
            while (-1 != (len = in.read(data, 0, data.length))) {
                out.write(data, 0, len);
            }
        } catch (Exception e) {
            throw new CustomException("下载文件异常");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            f.delete();
        }

    }
}
