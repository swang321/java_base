package com.example.demo.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.demo.util.listener.ExcelListener;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author: whh
 * @Date: 2020/8/6 9:43
 * @Description: 注解形式   excel 导入 导出
 */
@Slf4j
public class EasyExcelUtil {
    /**
     * 简易下载 其他功能可扩展
     *
     * @param sheetName sheet 名字
     * @param data      数据列表
     * @param tClass    Class.class
     * @param response  response
     */
    public static void downExcel(String sheetName, List<?> data, Class<?> tClass, HttpServletResponse response) {
        // 这里注意 反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = sheetName + DateUtil.format(DateTime.now().toJdkDate(), DatePattern.PURE_DATETIME_MS_PATTERN);
        try {
            String fileAllName = URLEncoder.encode(fileName, String.valueOf(StandardCharsets.UTF_8));
            response.setHeader("Content-disposition", "attachment;filename=" + fileAllName + ExcelTypeEnum.XLSX.getValue());
            EasyExcel.write(response.getOutputStream(), tClass).sheet(sheetName).doWrite(data);
        } catch (IOException e) {
            log.error("导出excel错误:{}", e.getMessage());
        }
    }

    /**
     * 批量导入
     *
     * @param inputStream 流
     * @param clazz       对于转换得实体类 class
     * @return List<T>
     */
    public static <T> List<T> readExcel(final InputStream inputStream, final Class<?> clazz) {
        if (null == inputStream) {
            log.error("导入excel错误 the inputStream is null!");
            throw new NullPointerException("the inputStream is null!");
        }
        ExcelListener<T> listener = new ExcelListener<>();
        ExcelReaderBuilder read = EasyExcelFactory.read(inputStream, listener);
        read.head(clazz);
        read.doReadAll();
        return listener.getRows();
    }
}
