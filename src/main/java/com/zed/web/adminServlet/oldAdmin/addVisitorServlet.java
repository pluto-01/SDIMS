package com.zed.web.adminServlet.oldAdmin;

import com.alibaba.fastjson.JSON;
import com.zed.entity.Visitor;
import com.zed.service.VisitorService;
import com.zed.service.impl.VisitorServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addVisitorServlet")
public class addVisitorServlet extends HttpServlet {
    private VisitorService visitorService = new VisitorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Visitor visitor = JSON.parseObject(params, Visitor.class);

        //调用方法
        visitorService.addVisitor(visitor);

        //添加成功则提示
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
