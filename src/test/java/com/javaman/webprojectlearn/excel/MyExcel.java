package com.javaman.webprojectlearn.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;


public class MyExcel {

    @Test
    @Ignore
    public void getExcel() throws UnsupportedEncodingException {
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


//            response.setContentType("application/vnd.ms-excel");
//            response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
//            stream = response.getOutputStream();

            if (null != hssfWorkbook && null != stream) {
                hssfWorkbook.write(stream);
                stream.flush();
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void exportExcel(/*ShopNewDailyStockRspVo daily,*/ HttpServletResponse response) {
        try {

            //Workbook
            Workbook wb = new XSSFWorkbook();

//            //sheet1
//            this.inExcelSheet(wb, daily, ins);
//            //sheet12
//            this.outExcelSheet(wb, daily, outs);

            String fileName = "StockDaily-"+System.currentTimeMillis()+".xlsx";

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition","attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.flushBuffer();

            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun1(){
        //设置千分位 和保留4位小数
        String str="23231.121255";
        DecimalFormat df=new DecimalFormat("#,##0.0000");
        String s = df.format(new BigDecimal(str).setScale(4, BigDecimal.ROUND_HALF_UP));
        System.out.println(s);
    }

}
