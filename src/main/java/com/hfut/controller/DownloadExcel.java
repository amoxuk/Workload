package com.hfut.controller;

import com.hfut.exception.CustomException;
import com.hfut.service.*;
import com.hfut.service.impl.ExcelServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

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


    @Resource(name = "excelServiceImpl")
    private ExcelService excelService;

    /**
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downRemote",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=UTF-8");
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        request.setCharacterEncoding("UTF-8");
        String separator = File.separator;
        String rootpath = request.getSession().getServletContext().getRealPath(separator + "upload");
        String fileName = "workload.xls";
        String path = rootpath + separator + fileName;

        String type = request.getParameter("type");

        switch (type) {
            case ExcelServiceImpl.REMOTE_TEACH:
                excelService.outTeachWorkload(path, teachService.findAllLoad(0, teachService.getCount()));
                break;
            case ExcelServiceImpl.REMOTE_EXP:
                excelService.outExpWorkload(path, expService.findAllLoad(0, expService.getCount()));
                break;
            case ExcelServiceImpl.REMOTE_DESIGN:
                excelService.outDesignWorkload(path, designService.findAllLoad(0, designService.getCount()));
                break;
            case ExcelServiceImpl.REMOTE_GRA:
                excelService.outGraduateWorkload(path, graService.findAllLoad(0, graService.getCount()));
                break;
            case ExcelServiceImpl.LOACAL_COURSE:
                excelService.outLCourseWorkload(path, localCourseService.findAllLoad(0, localCourseService.getCount()));
                break;
            case ExcelServiceImpl.LOACAL_EXP:
                excelService.outLExpWorkload(path, localExpService.findAllLoad(0, localExpService.getCount()));
                break;
            case ExcelServiceImpl.LOACAL_DESIGN:
                excelService.outLDesignWorkload(path, localDesignService.findAllLoad(0, localDesignService.getCount()));
                break;
            case ExcelServiceImpl.LOACAL_GRA_PRACTICE:
                excelService.outLGraPracticeWorkload(path, localGraPracticeService.findAllLoad(0, localGraPracticeService.getCount()));
                break;
            case ExcelServiceImpl.LOACAL_GRA_DESIGN:
                excelService.outLGraDesignWorkload(path, localGraDesignService.findAllLoad(0, localGraDesignService.getCount()));
                break;
            case ExcelServiceImpl.LOACAL_PRACTICE:
                excelService.outLPracticeDesignWorkload(path, localPracticeService.findAllLoad(0, localPracticeService.getCount()));
                break;
            case ExcelServiceImpl.LOACAL_PROJECT:
                excelService.outLProjectWorkload(path, localProjectService.findAllLoad(0, localProjectService.getCount()));
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
