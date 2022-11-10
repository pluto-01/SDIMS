package com.zed.web.adminServlet.visitor;

import com.alibaba.fastjson.JSON;
import com.zed.entity.Visitor;
import com.zed.service.VisitorService;
import com.zed.service.impl.VisitorServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectVisitorServlet")
public class SelectVisitorServlet extends HttpServlet {
    private VisitorService visitorService = new VisitorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //visitorService

        List<Visitor> vsts = visitorService.selectVisitor();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(vsts);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
