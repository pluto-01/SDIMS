package com.zed.web.adminServlet.student;

import com.alibaba.fastjson.JSON;
import com.zed.entity.Page;
import com.zed.entity.StuInfo;
import com.zed.service.StuInfoService;
import com.zed.service.impl.StuInfoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByPageServlet")
public class SelectByPageServlet extends HttpServlet {


    private StuInfoService stuInfoService = new StuInfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");

        //接收 当前页码 和 每页展示条数 url?currentPage&pageSize
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        if (_currentPage == null)
            _currentPage = "1";
        if (_pageSize == null)
            _pageSize = "5";
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //调用service
        Page<StuInfo> page = stuInfoService.selectByPage(currentPage, pageSize);
        //将数据转为JSON
        String jsonString = JSON.toJSONString(page);

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
