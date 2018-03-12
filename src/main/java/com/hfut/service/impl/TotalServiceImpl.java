package com.hfut.service.impl;

import com.hfut.entity.LocalTotalView;
import com.hfut.entity.LocalTotalViewExample;
import com.hfut.entity.RemoteTotalView;
import com.hfut.entity.RemoteTotalViewExample;
import com.hfut.mapper.LocalTotalViewMapper;
import com.hfut.mapper.RemoteTotalViewMapper;
import com.hfut.service.TotalService;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class TotalServiceImpl implements TotalService {
    @Autowired
    private RemoteTotalViewMapper remoteMapper;
    @Autowired
    private LocalTotalViewMapper localMapper;

    Logger logger = Logger.getLogger(TotalServiceImpl.class);


    @Override
    public List  getRemoteTotal(Integer years) {
        RemoteTotalViewExample example = new RemoteTotalViewExample();
        RemoteTotalViewExample.Criteria criteria = example.createCriteria();
        criteria.andYearsEqualTo(years);
        List<RemoteTotalView> list = remoteMapper.selectByExample(example);
        return list;
    }

    @Override
    public List getLocalTotal(Integer years) {
        LocalTotalViewExample example = new LocalTotalViewExample();
        LocalTotalViewExample.Criteria criteria = example.createCriteria();
        criteria.andYearsEqualTo(years);
        List<LocalTotalView> list = localMapper.selectByExample(example);

        return list;
    }
    /**
     *
     * Integer REMOTE = 2;
     * Integer LOCAL = 1;
     *
     * */
    @Override
    public List getTotalByName(Integer years, String teacher, Integer local) {

        if (2 == local) {
            RemoteTotalViewExample example = new RemoteTotalViewExample();
            RemoteTotalViewExample.Criteria criteria = example.createCriteria();
            criteria.andYearsEqualTo(years);
            if (!"all".equals(teacher)) {
                criteria.andTeacherEqualTo(teacher);
            }
            List<RemoteTotalView> list = remoteMapper.selectByExample(example);
            return list;
        } else if (1 == local) {
            LocalTotalViewExample example = new LocalTotalViewExample();
            LocalTotalViewExample.Criteria criteria = example.createCriteria();

            criteria.andYearsEqualTo(years);
            if (!"all".equals(teacher)) {
                criteria.andTeacherEqualTo(teacher);
            }
            List<LocalTotalView> list = localMapper.selectByExample(example);
            return list;

        } else {
            return null;
        }
    }

    @Override
    public String download(HttpServletRequest request, Integer years, String teacher, Integer local) throws Exception {

        String separator = File.separator;
        String rootpath = request.getSession().getServletContext().getRealPath(separator + "upload");
        String fileName = new Date().getTime() + ".xls";

        String path = rootpath + separator + fileName;
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet(years+"年工作量汇总");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        String[] title;
        if (TotalService.LOCAL == local) {
            title = new String[]{"序号","学年", "教师", "课堂教学", "实验教学", "课程设计", "实习","毕业实习", "毕业设计", "指导创新创业项目", "辅导竞赛", "合计"};
        } else {
            title = new String[]{"序号","学年","教师" , "课堂教学" , "实验教学" , "课程设计" , "毕业设计" , "无课补贴" , "合计"};
        }


        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        int total = 0,line = 0;
        if (TotalService.LOCAL == local) {
            List<LocalTotalView> list = getTotalByName(years, teacher, local);
            //第五步插入数据

            for (int i = 0; i < list.size(); i++) {
                //创建行
                line = 0;
                row = sheet.createRow(i + 1);
                //创建单元格并且添加数据
                row.createCell(line++).setCellValue(i + 1);
                row.createCell(line++).setCellValue(years);
                row.createCell(line++).setCellValue(list.get(i).getTeacher());
                row.createCell(line++).setCellValue(list.get(i).getCourse());
                row.createCell(line++).setCellValue(list.get(i).getExpriment());
                row.createCell(line++).setCellValue(list.get(i).getDesign());
                row.createCell(line++).setCellValue(list.get(i).getPractice());
                row.createCell(line++).setCellValue(list.get(i).getGraduatePractice());
                row.createCell(line++).setCellValue(list.get(i).getGraduateDesign());
                row.createCell(line++).setCellValue(list.get(i).getProject());
                row.createCell(line++).setCellValue(list.get(i).getMatchs());
                row.createCell(line++).setCellValue(list.get(i).getTotal());
                row.createCell(line++).setCellValue("");
                total += list.get(i).getTotal();
            }
        } else {
            List<RemoteTotalView> list = getTotalByName(years, teacher, local);
            //第五步插入数据

            for (int i = 0; i < list.size(); i++) {
                //创建行
                line = 0;
                row = sheet.createRow(i + 1);
                //创建单元格并且添加数据
                //"序号","学年","教师" , "课堂教学" , "实验教学" , "课程设计" , "毕业设计" , "无课补贴" , "合计"
                row.createCell(line++).setCellValue(i + 1);
                row.createCell(line++).setCellValue(years);
                row.createCell(line++).setCellValue(list.get(i).getTeacher());
                row.createCell(line++).setCellValue(list.get(i).getCourse());
                row.createCell(line++).setCellValue(list.get(i).getExpriment());
                row.createCell(line++).setCellValue(list.get(i).getDesign());
                row.createCell(line++).setCellValue(list.get(i).getGraduate());
                row.createCell(line++).setCellValue(list.get(i).getNonLesson());
                row.createCell(line++).setCellValue(list.get(i).getTotal());
                row.createCell(line++).setCellValue("");
                total += list.get(i).getTotal();
            }
        }
        row = sheet.createRow(sheet.getLastRowNum() + 1);
        line = line - 3 > 0 ? line - 3 : 0;
        row.createCell(line).setCellValue("汇总");
        row.createCell(++line).setCellValue(total);

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        logger.info("工作量汇总文件生成成功:" + path);
        return path;
    }
}
