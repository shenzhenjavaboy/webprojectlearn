package com.javaman.webprojectlearn.controller;

import com.javaman.webprojectlearn.mapper.UserMapper;
import com.javaman.webprojectlearn.pojo.Employee;
import com.javaman.webprojectlearn.pojo.User;
import com.javaman.webprojectlearn.service.impl.UserServiceImpl;
import com.javaman.webprojectlearn.strage.PointSendText;
import com.javaman.webprojectlearn.strage.PointTypeEnum;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    //swagger
    @RequestMapping("/swagger")
    @ResponseBody
    public String swaggerTest() {
        return "hello swagger";
    }

    //查询
    @RequestMapping("/query")
    public ModelAndView query() throws Exception {
        //List<User> user = userMapper.getUser();
        ModelAndView ma = new ModelAndView();
        ma.setViewName("index");
        ma.addObject("msg", userService.query());

        System.out.println(userService.query());
       // System.out.println(dept.toString());
        return ma;
    }
@Autowired
private PointSendText pointSendText;
    @RequestMapping("/strage")
    public void strage() throws Exception {
       pointSendText.sendPoint(PointTypeEnum.A,10);
    }
    //增加
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestParam(value = "name") String userName, String sex, String telPhone) {
        User user = new User();
        user.setName(userName);
        user.setSex(sex);
        user.setTelphone(telPhone);
        Integer result = userService.addUser(user);
        if (result == 1) {
            return "增加用户成功。。";
        }
        return "增加用户失败。。";
    }

    //修改
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(String sex, @RequestParam(value = "phone") String telPhone) {
        User user = new User();
        user.setSex(sex);
        user.setTelphone(telPhone);
        Integer result = userService.updateUser(user);
        if (result != 1) {
            return "修改失败。。";
        }
        return "修改成功。。";
    }

    //删除用户
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam(value = "phone") String telPhone) {
        User user = new User();
        user.setTelphone(telPhone);
        Integer result = userService.deleteUser(user);
        System.out.println(result);
        if (result != 1) {
            return "删除失败。。";
        }
        return "删除成功。。";
    }

    //前端传入json 数据，再将数据传到前端
    @RequestMapping(value = "/tojson", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView testJson(@RequestBody Employee employee) {
        System.out.println(employee.getList());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("msg1", employee);

        return modelAndView;
    }

    @RequestMapping("/geterror")
    @ResponseBody
    public String getError(){
        int i=1/0;
        return "error";

    }


    public void getWorkBook(@PathVariable("name") String userName){


        System.out.println(userName);
    }

    @GetMapping("/getWorkBook")
    @ResponseBody
    private void exportExcel(/*ShopNewDailyStockRspVo daily,*/ HttpServletResponse response) {
        try {

            //Workbook
           Workbook wb = new XSSFWorkbook();

//            //sheet1
//            this.inExcelSheet(wb, daily, ins);
//            //sheet12
//            this.outExcelSheet(wb, daily, outs);
            getExcel(response);
            String fileName = "StockDaily-"+System.currentTimeMillis()+".xlsx";

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition","attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.flushBuffer();

//            OutputStream ouputStream = response.getOutputStream();
//            wb.write(ouputStream);
//            ouputStream.flush();
//            ouputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getExcel( HttpServletResponse response) throws UnsupportedEncodingException {
        //导出
        //Excel
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        Sheet sheet = hssfWorkbook.createSheet("sheet1");
        //表头字体

        Font headerFont = hssfWorkbook.createFont();

        headerFont.setFontName("微软雅黑");
        headerFont.setFontHeightInPoints((short) 18);

        int rowNum = 0;

        //设置列宽
        for (int i = 0; i < 24; i++) {
            sheet.setColumnWidth(i, 1800);
        }

        //第一行
        Row r0 = sheet.createRow(rowNum++);
        r0.setHeight((short) 800);
        Cell c00 = r0.createCell(0);
        c00.setCellValue("数据");
        /// c00.setCellStyle(headerStyle);
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 23));

        //第二行
        Row r1 = sheet.createRow(rowNum++);
        r1.setHeight((short) 500);
        String[] row_first = {"统计项目","","","活动日期","","","","活动名称","","","","活动地点","","","","小计","","","","",""};
        for (int i = 0; i < row_first.length; i++) {
            Cell tempCell = r1.createCell(i);
            tempCell.setCellValue(row_first[i]);
            //tempCell.setCellStyle(commonStyle);
        }
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 4));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 7));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 8, 9));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 12));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 13, 14));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 15, 17));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 18, 23));

        //第三行
        Row r2 = sheet.createRow(rowNum++);
        r2.setHeight((short) 700);
        String[] row_second = {"断面编号","","","1","","", "2","","", "3","","", "4","","", "5","","","-","","","","",""};
        for (int i = 0; i < row_second.length; i++) {
            Cell tempCell = r2.createCell(i);
            tempCell.setCellValue(row_second[i]);
            //tempCell.setCellStyle(commonStyle);
        }
        //合并单元格
        
        sheet.addMergedRegion(new CellRangeAddress(2,2,0,2));
        sheet.addMergedRegion(new CellRangeAddress(2,2,3,5));
        sheet.addMergedRegion(new CellRangeAddress(2,2,6,8));
        sheet.addMergedRegion(new CellRangeAddress(2,2,9,11));
        sheet.addMergedRegion(new CellRangeAddress(2,2,12,14));
        sheet.addMergedRegion(new CellRangeAddress(2,2,15,17));
        sheet.addMergedRegion(new CellRangeAddress(2,2,18,23));

        //输出
        OutputStream stream = null;
        try {
            // 文件名
            String fileName = "报表名称.xls";

            // 处理文件名包含特殊字符出现的乱码问题
            String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36";

            userAgent = userAgent.toLowerCase();
            if (userAgent.contains("msie") || userAgent.contains("trident") || userAgent.contains("edge")) {
                if (fileName.length() > 150) {// 解决IE 6.0问题
                    fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                } else {
                    fileName = URLEncoder.encode(fileName, "UTF-8");
                }
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }


            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
            stream = response.getOutputStream();

            if (null != hssfWorkbook && null != stream) {
                hssfWorkbook.write(stream);
                stream.flush();
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
