package com.zed.web;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.zed.entity.Bill;
import com.zed.entity.Repair;
import com.zed.service.BillService;
import com.zed.service.RepairService;
import com.zed.service.impl.BillServiceImpl;
import com.zed.service.impl.RepairServiceImpl;
import com.zed.web.adminServlet.BaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@WebServlet("/worker/*")
public class WorkerServlet extends BaseServlet {
    private RepairService repairService = new RepairServiceImpl();
    public void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        String value = "";
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)) {
                value = URLDecoder.decode(cookie.getValue(), "utf-8");
                break;
            }
        }
        String jsonString = JSON.toJSONString(value);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectRepair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Repair> repairs = repairService.selectRepair();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(repairs);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void editRepairInfoByWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Repair repair = JSON.parseObject(params, Repair.class);

        //调用方法
        repairService.editRepairInfoByWorker(repair);

        //添加成功则提示
        response.getWriter().write("success");
    }


}
