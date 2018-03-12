package com.hfut.service.impl;

import com.hfut.entity.*;
import com.hfut.exception.CustomException;
import com.hfut.service.ExcelService;
import com.hfut.util.POIUtil;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ExcelServiceImpl implements ExcelService {
    public static final String REMOTE_TEACH = "RTeach";
    public static final String REMOTE_EXP = "RExp";
    public static final String REMOTE_DESIGN = "RDesign";
    public static final String REMOTE_GRA = "RGra";
    public static final String REMOTE_NON_LESSON = "RNonLesson";

    public static final String LOACAL_COURSE = "LCourse";
    public static final String LOACAL_EXP = "LExp";
    public static final String LOACAL_DESIGN = "LDesign";
    public static final String LOACAL_GRA_PRACTICE = "LGPractice";
    public static final String LOACAL_GRA_DESIGN = "LGDesign";
    public static final String LOACAL_PRACTICE = "LPractice";
    public static final String LOACAL_NET = "LNet";
    public static final String LOACAL_PROJECT= "LProject";
    public static final String LOACAL_MATCH= "LMatch";
    public static final String LOACAL_AXE= "LAxe";
    public static final String LOACAL_BOOK= "LBook";
    public static final String LOACAL_TRAIN= "LTrain";

    public static final String EXP= "Exp";

    Logger logger = Logger.getLogger(ExcelServiceImpl.class);

    @Override
    public List inTeachWorkload(File file) throws CustomException {
        try {
            // 创建需要批量插入数据集合

            // 创建一个FileInputStream 文件输入流
            FileInputStream inputStream = new FileInputStream(file);
            // 创建对Excel工作簿文件的引用
            Workbook wookbook = null;
            String name = file.getName();
            String fileType = name.substring(name.lastIndexOf(".") + 1,
                    name.length());
            if (fileType.equals("xlsx")) {
                wookbook = new XSSFWorkbook(inputStream);
            } else if (fileType.equals("xls")) {
                wookbook = new HSSFWorkbook(inputStream);
            }
            // 在Excel文档中，第一张工作表的缺省索引是0
            Sheet sheet = wookbook.getSheetAt(0);
            // 获取到Excel文件中的所有行数
            int rows = sheet.getPhysicalNumberOfRows();

            // 创建对象
            List<RemoteTeachWorkload> list = new ArrayList<RemoteTeachWorkload>();
            RemoteTeachWorkload object;

            // 遍历行 从第二行开始遍历
            int line;
            for (int i = 1; i < rows; i++) {
                // 读取左上端单元格
                Row row = sheet.getRow(i);
                // 行不为空
                if (row != null) {
                    object = new RemoteTeachWorkload();

                    line = 0;
                    //获取老师
                    object.setCollege(POIUtil.getStringCell(row.getCell(line++)));
                    object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                    object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                    object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                    object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                    object.setTeachClass(POIUtil.getIntCell(row.getCell(line++)));
                    object.setPeriod(POIUtil.getFloatCell(row.getCell(line++)));
                    object.setCredit(POIUtil.getFloatCell(row.getCell(line++)));
                    object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                    object.setClassCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                    object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                    object.setMoney(POIUtil.getFloatCell(row.getCell(line++)));
                    object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                    // 将对象增加到集合中
                    list.add(object);
                }
            }

            System.out.println(list.toString());
            return list;
            // 返回集合

        } catch (IOException e) {
            throw new CustomException("创建导入excel对象报错！" + e);
        }
    }

    @Override
    public void outTeachWorkload(String file, List<RemoteTeachWorkload> list) throws Exception{

        String[] title = new String[]{"序号", "院系", "教师", "课程",
                "年级", "优选班级", "教学班", "课时", "学分", "人数",
                "班级系数", "工作量", "酬金", "备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("教师上课补贴");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getCollege());
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getTeachClass());
            row.createCell(line++).setCellValue(list.get(i).getPeriod());
            row.createCell(line++).setCellValue(list.get(i).getCredit());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getClassCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getMoney());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(file));

            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("teach Excel文件生成成功...");
    }

    @Override
    public List inExpWorkLoad(File file) throws IOException {
        // 创建一个FileInputStream 文件输入流
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        RemoteExpWorkload object;
        List<RemoteExpWorkload> list = new ArrayList<RemoteExpWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new RemoteExpWorkload();
                line = 0;
                object.setCollege(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeachClass(POIUtil.getIntCell(row.getCell(line++)));
                object.setPeriod(POIUtil.getFloatCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setReCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setTypeCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setMoney(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        System.out.println(list.toString());
        return list;

    }

    @Override
    public void outExpWorkload(String file, List<RemoteExpWorkload> list)throws Exception {

        String[] title = new String[]{"序号", "院系", "教师", "课程",
                "年级", "优选班级", "教学班", "课时", "人数",
                "重复系数M", "类别系数K", "工作量", "酬金", "备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("教师实验补贴");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getCollege());
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getTeachClass());
            row.createCell(line++).setCellValue(list.get(i).getPeriod());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getReCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getTypeCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getMoney());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(file));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("exp Excel文件生成成功...");
    }

    @Override
    public List inDesignList(File file) throws Exception {
        // 创建一个FileInputStream 文件输入流
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        RemoteDesignWorkload object;
        List<RemoteDesignWorkload> list = new ArrayList<RemoteDesignWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new RemoteDesignWorkload();
                line = 0;
                object.setCollege(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeachClass(POIUtil.getIntCell(row.getCell(line++)));
                object.setWeeks(POIUtil.getIntCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setLoadCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setMoney(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;

    }

    @Override
    public void outDesignWorkload(String path, List<RemoteDesignWorkload> list) throws Exception {

        String[] title = new String[]{"序号", "院系", "教师", "课程",
                "年级", "优选班级", "教学班", "周数", "人数",
                "系数K", "工作量", "酬金", "备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("课程设计补贴");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getCollege());
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getTeachClass());
            row.createCell(line++).setCellValue(list.get(i).getWeeks());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getLoadCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getMoney());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("design Excel文件生成成功...");
    }

    @Override
    public void outGraduateWorkload(String path, List<RemoteGraduateWorkload> list)throws Exception {
        String[] title = new String[]{"序号", "院系", "教师",
                "年级", "优选班级", "人数", "周数", "工作量",
                "酬金", "备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("课程设计补贴");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getCollege());
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getWeeks());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getMoney());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("design Excel文件生成成功...");
    }

    @Override
    public List inGraduateWorkload(File file) throws Exception {
        // 创建一个FileInputStream 文件输入流
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        RemoteGraduateWorkload object;
        List<RemoteGraduateWorkload> list = new ArrayList<RemoteGraduateWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new RemoteGraduateWorkload();
                line = 0;
                object.setCollege(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setWeeks(POIUtil.getIntCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setMoney(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;

    }

    @Override
    public void outLCourseWorkload(String path, List<LocalCourseWorkload> list)throws Exception {
        String[] title = new String[]{"序号", "教师","课程",
                "年级", "优选班级","教学班号","学时", "人数", "学分", "系数",
                "工作量", "备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("课程设计补贴");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getTeachClass());
            row.createCell(line++).setCellValue(list.get(i).getPeriod());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getCredit());
            row.createCell(line++).setCellValue(list.get(i).getCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("course Excel文件生成成功...");
    }

    @Override
    public List inLCourseWorkload(File file) throws Exception {
        // 创建一个FileInputStream 文件输入流
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LocalCourseWorkload object;
        List<LocalCourseWorkload> list = new ArrayList<LocalCourseWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LocalCourseWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeachClass(POIUtil.getIntCell(row.getCell(line++)));
                object.setPeriod(POIUtil.getFloatCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setCredit(POIUtil.getFloatCell(row.getCell(line++)));
                object.setCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;

    }

    @Override
    public List inLExpWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LocalExpWorkload object;
        List<LocalExpWorkload> list = new ArrayList<LocalExpWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LocalExpWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeachClass(POIUtil.getIntCell(row.getCell(line++)));
                object.setType(POIUtil.getStringCell(row.getCell(line++)));
                object.setPeriod(POIUtil.getFloatCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setTypeCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setLoadCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;

    }

    @Override
    public void outLExpWorkload(String path, List<LocalExpWorkload> list) throws Exception {
        String[] title = new String[]{"序号", "教师","课程",
                "年级", "优选班级","教学班号","实验类型", "学时", "人数", "类别系数",
                "工作量系数", "工作量","备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("课程设计补贴");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getTeachClass());
            row.createCell(line++).setCellValue(list.get(i).getType());
            row.createCell(line++).setCellValue(list.get(i).getPeriod());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getTypeCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getLoadCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("exp Excel文件生成成功...");

    }

    @Override
    public List inLDesignWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LocalDesignWorkload object;
        List<LocalDesignWorkload> list = new ArrayList<LocalDesignWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LocalDesignWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeachClass(POIUtil.getIntCell(row.getCell(line++)));
                object.setWeeks(POIUtil.getIntCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public void outLDesignWorkload(String path, List<LocalDesignWorkload> list) throws Exception {
        String[] title = new String[]{"序号", "教师","课程",
                "年级", "优选班级","教学班号", "周数", "人数",
                "工作量","备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("课程设计工作量");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getTeachClass());
            row.createCell(line++).setCellValue(list.get(i).getWeeks());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("exp Excel文件生成成功...");

    }

    @Override
    public List inLGraPracticeWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LGraPracticeWorkload object;
        List<LGraPracticeWorkload> list = new ArrayList<LGraPracticeWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LGraPracticeWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setCollege(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setMajor(POIUtil.getStringCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setWeeks(POIUtil.getIntCell(row.getCell(line++)));
                object.setPlace(POIUtil.getStringCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public void outLGraPracticeWorkload(String path, List<LGraPracticeWorkload> list) throws Exception {
        String[] title = new String[]{"序号", "教师","院系",
                "年级", "专业","人数", "周数", "实习地点",
                "工作量","备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("毕业设计工作量");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getCollege());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getMajor());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getWeeks());
            row.createCell(line++).setCellValue(list.get(i).getPlace());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("exp Excel文件生成成功...");

    }

    @Override
    public void outLGraDesignWorkload(String path, List<LGraDesignWorkload> list) throws Exception {
        String[] title = new String[]{"序号", "教师","年级",
                "专业班级", "周数","系数K", "人数", "工作量",
                "备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("毕业设计工作量");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getWeeks());
            row.createCell(line++).setCellValue(list.get(i).getCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("exp Excel文件生成成功...");

    }

    @Override
    public List inLGraDesignWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LGraDesignWorkload object;
        List<LGraDesignWorkload> list = new ArrayList<LGraDesignWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LGraDesignWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setWeeks(POIUtil.getIntCell(row.getCell(line++)));
                object.setCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public List inLPracticeWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LPracticeWorkload object;
        List<LPracticeWorkload> list = new ArrayList<LPracticeWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LPracticeWorkload();
                line = 0;
                object.setCollege(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setType(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setMajor(POIUtil.getStringCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setClassNumber(POIUtil.getIntCell(row.getCell(line++)));
                object.setWeeks(POIUtil.getIntCell(row.getCell(line++)));
                object.setPlace(POIUtil.getStringCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));

                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public void outLPracticeDesignWorkload(String path, List<LPracticeWorkload> list)  throws Exception{
        String[] title = new String[]{"序号", "系别","教师",
                "实习性质", "年级","专业", "人数", "班级数","周数","实习地点",
                "工作量","备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("毕业设计工作量");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getCollege());
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getType());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getMajor());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getWeeks());
            row.createCell(line++).setCellValue(list.get(i).getClassNumber());
            row.createCell(line++).setCellValue(list.get(i).getPlace());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Lprac Excel文件生成成功...");
    }

    @Override
    public void outLProjectWorkload(String path, List<LProjectWorkload> list) throws Exception {
        String[] title = new String[]{"序号","教师", "年级","项目编号",
                "项目名称", "项目类型","级别",
                "工作量","备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("毕业设计工作量");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getNumber());
            row.createCell(line++).setCellValue(list.get(i).getName());
            row.createCell(line++).setCellValue(list.get(i).getType());
            row.createCell(line++).setCellValue(list.get(i).getLevel());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Lproj Excel文件生成成功...");
    }

    @Override
    public List inLProjectWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LProjectWorkload object;
        List<LProjectWorkload> list = new ArrayList<LProjectWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LProjectWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setNumber(POIUtil.getStringCell(row.getCell(line++)));
                object.setName(POIUtil.getStringCell(row.getCell(line++)));
                object.setType(POIUtil.getStringCell(row.getCell(line++)));
                object.setLevel(POIUtil.getStringCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public void outLMatchWorkload(String path, List<LMatchWorkload> list) throws Exception {
        String[] title = new String[]{"序号","教师", "年级","项目编号",
                "项目名称", "竞赛性质","获奖等级",
                "工作量","备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("毕业设计工作量");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getNumber());
            row.createCell(line++).setCellValue(list.get(i).getName());
            row.createCell(line++).setCellValue(list.get(i).getType());
            row.createCell(line++).setCellValue(list.get(i).getLevel());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Lmatch Excel文件生成成功...");
    }

    @Override
    public List inLMatchWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LMatchWorkload object;
        List<LMatchWorkload> list = new ArrayList<LMatchWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LMatchWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setNumber(POIUtil.getStringCell(row.getCell(line++)));
                object.setName(POIUtil.getStringCell(row.getCell(line++)));
                object.setType(POIUtil.getStringCell(row.getCell(line++)));
                object.setLevel(POIUtil.getStringCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public void outLNetWorkload(String path, List<LNetWorkload> list) throws Exception {
        String[] title = new String[]{"序号","教师", "年级","课程",
                "答疑数", "工作量","备注", "签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        Sheet sheet = wb.createSheet("毕业设计工作量");

        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        Cell cell; //第一个单元格

        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getAnswer());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("LNet Excel文件生成成功...");
    }

    @Override
    public List inLNetWorkload(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        LNetWorkload object;
        List<LNetWorkload> list = new ArrayList<LNetWorkload>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new LNetWorkload();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                object.setAnswer(POIUtil.getIntCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));

                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public void outExpriment(String path, List<Expriment> list) throws Exception {
        String[] title = new String[]{"序号","教师", "年级","课程名称","实验类型",
                "教学班","优选班级", "学时","学分","人数","系数", "工作量","备注","签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();
        //第二步创建sheet
        Sheet sheet = wb.createSheet("实验人员教学工作量");
        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
        Cell cell; //第一个单元格
        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getLesson());
            row.createCell(line++).setCellValue(list.get(i).getType());
            row.createCell(line++).setCellValue(list.get(i).getTeachClass());
            row.createCell(line++).setCellValue(list.get(i).getGrades());
            row.createCell(line++).setCellValue(list.get(i).getPeroid());
            row.createCell(line++).setCellValue(list.get(i).getCredit());
            row.createCell(line++).setCellValue(list.get(i).getPeople());
            row.createCell(line++).setCellValue(list.get(i).getCoefficient());
            row.createCell(line++).setCellValue(list.get(i).getWorkload());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }
        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("LNet Excel文件生成成功...");
    }

    @Override
    public List inExpriment(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        Expriment object;
        List<Expriment> list = new ArrayList<Expriment>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new Expriment();
                line = 0;
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setLesson(POIUtil.getStringCell(row.getCell(line++)));
                object.setType(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeachClass(POIUtil.getIntCell(row.getCell(line++)));
                object.setGrades(POIUtil.getStringCell(row.getCell(line++)));
                object.setPeroid(POIUtil.getFloatCell(row.getCell(line++)));
                object.setCredit(POIUtil.getFloatCell(row.getCell(line++)));
                object.setPeople(POIUtil.getIntCell(row.getCell(line++)));
                object.setCoefficient(POIUtil.getFloatCell(row.getCell(line++)));
                object.setWorkload(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                logger.info(object.toString());

                list.add(object);
            }
        }
        return list;
    }

    @Override
    public void outNonLesson(String path, List<RemoteNonLesson> list) throws Exception {
        String[] title = new String[]{"序号","院系","教师", "年级","无课天数","周数",
                "总天数","补贴", "备注","签字"};
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();
        //第二步创建sheet
        Sheet sheet = wb.createSheet("异地教师无课补贴");
        //第三步创建行row:添加表头0行
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中
        Cell cell; //第一个单元格
        //第四步创建单元格
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //第五步插入数据
        int line;
        for (int i = 0; i < list.size(); i++) {
            //创建行
            line = 0;
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            row.createCell(line++).setCellValue(i + 1);
            row.createCell(line++).setCellValue(list.get(i).getColleage());
            row.createCell(line++).setCellValue(list.get(i).getTeacher());
            row.createCell(line++).setCellValue(list.get(i).getYears());
            row.createCell(line++).setCellValue(list.get(i).getDays());
            row.createCell(line++).setCellValue(list.get(i).getWeeks());
            row.createCell(line++).setCellValue(list.get(i).getAlldays());
            row.createCell(line++).setCellValue(list.get(i).getAllownce());
            row.createCell(line++).setCellValue(list.get(i).getNote());
            row.createCell(line++).setCellValue("");
        }
        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(new File(path));
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("LNet Excel文件生成成功...");
    }

    @Override
    public List inNonLesson(File file) throws Exception {
        FileInputStream inputStream = new FileInputStream(file);
        // 创建对Excel工作簿文件的引用
        Workbook wookbook = null;
        String name = file.getName();
        String fileType = name.substring(name.lastIndexOf(".") + 1,
                name.length());
        if (fileType.equals("xlsx")) {
            wookbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equals("xls")) {
            wookbook = new HSSFWorkbook(inputStream);
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        RemoteNonLesson object;
        List<RemoteNonLesson> list = new ArrayList<RemoteNonLesson>();
        int line;
        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                //获取老师
                object = new RemoteNonLesson();
                line = 0;
                object.setColleage(POIUtil.getStringCell(row.getCell(line++)));
                object.setTeacher(POIUtil.getStringCell(row.getCell(line++)));
                object.setYears(POIUtil.getIntCell(row.getCell(line++)));
                object.setDays(POIUtil.getIntCell(row.getCell(line++)));
                object.setWeeks(POIUtil.getIntCell(row.getCell(line++)));
                object.setAlldays(POIUtil.getIntCell(row.getCell(line++)));
                object.setAllownce(POIUtil.getFloatCell(row.getCell(line++)));
                object.setNote(POIUtil.getStringCell(row.getCell(line++)));
                // 将对象增加到集合中
                list.add(object);
            }
        }
        return list;
    }

}
