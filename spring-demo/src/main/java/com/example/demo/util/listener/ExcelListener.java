package com.example.demo.util.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whh
 * @Date: 2020/8/6 9:45
 * @Description: 读取 excel 监听器
 */
@Slf4j
public class ExcelListener<T> extends AnalysisEventListener<T> {
    private final List<T> rows = new ArrayList<>();

    @Override
    public void invoke(T object, AnalysisContext context) {
        rows.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

    public List<T> getRows() {
        return rows;
    }

}