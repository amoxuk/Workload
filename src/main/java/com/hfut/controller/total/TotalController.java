package com.hfut.controller.total;

import com.alibaba.fastjson.JSON;
import com.hfut.entity.AjaxResult;
import com.hfut.exception.CustomException;
import com.hfut.service.TotalService;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class TotalController {
    @Resource(name = "totalServiceImpl")
    private TotalService totalService;

    private Logger logger = Logger.getLogger(TotalController.class);

    @RequestMapping(value = "/total/count/{years}/{location}/{college}/{teacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf8")
    @ResponseBody
    public String getLocalTotal(@PathVariable("years") Integer years,
                                @PathVariable("location") Integer location,/*1落地0异地*/
                                @PathVariable("teacher") String teacher,
                                @PathVariable("college") String college) {
        AjaxResult result = new AjaxResult();
        logger.info(years + "," + location + "," + teacher + "," + college);
        System.out.println(college);
        if (location == 1) {
            result.setData(totalService.getTotalByName(years, teacher,college, TotalService.LOCAL));
        } else {
            result.setData(totalService.getTotalByName(years, teacher,college, TotalService.REMOTE));
        }

        result.ok();
        return JSON.toJSONString(result);
    }





    @RequestMapping(value = "/total/download/{years}/{location}/{college}/{teacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf8")
    @ResponseBody
    public void downloadTotal(HttpServletRequest request, HttpServletResponse response,
                              @PathVariable("years") Integer years,
                              @PathVariable("location") Integer location,
                              @PathVariable("teacher") String teacher,
                              @PathVariable("college") String college
    ) throws CustomException, IOException {
        String path;
        try {
            path = totalService.download(request, years, teacher,college, location);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        File f = new File(path);
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.setContentType("application/x-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + years + URLEncoder.encode("年工作量汇总", "UTF-8") + ".xls");
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
