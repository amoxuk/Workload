package com.hfut.controller;

import com.hfut.entity.AjaxResult;
import com.hfut.service.TeachingService;
import org.apache.log4j.Logger;
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
public class TeachingController {
    @Resource(name = "teachingServiceImpl")
    private TeachingService teachingService;

    private Logger logger = Logger.getLogger(TeachingController.class);

    @RequestMapping(value = "/upload/teaching",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String uploadTeaching(@RequestParam(value = "file", required = false)
                                      MultipartFile buildInfo,
                              HttpServletRequest request,
                              HttpServletResponse response) {

        if (!buildInfo.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("/upload") + File.separatorChar + buildInfo.getOriginalFilename();
            File file;//需要先保存在本地

            AjaxResult ajaxResult = new AjaxResult();
            List list = null;
            file = new File(path);
            try {
                buildInfo.transferTo(file);
                logger.info(path);
                //解析
                teachingService.saveAsData(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "failed";
    }

}

