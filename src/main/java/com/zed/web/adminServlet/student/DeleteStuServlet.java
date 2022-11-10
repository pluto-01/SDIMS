package com.zed.web.adminServlet.student;

import com.alibaba.fastjson.JSON;
import com.zed.service.StuInfoService;
import com.zed.service.impl.StuInfoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteStuServlet")
public class DeleteStuServlet extends HttpServlet {
    private StuInfoService stuInfoService = new StuInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为int类型
       int id = JSON.parseObject(params, int.class);

        //调用方法
        stuInfoService.deleteStuInfo(id);

        //添加成功则提示
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
