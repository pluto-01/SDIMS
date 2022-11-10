package com.zed.web.adminServlet.student;

import com.alibaba.fastjson.JSON;
import com.zed.pojo.Page;
import com.zed.pojo.StuInfo;
import com.zed.service.StuInfoService;
import com.zed.service.impl.StuInfoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectByPageAndConditionServlet")
public class SelectByPageAndConditionServlet extends HttpServlet {
    private StuInfoService stuInfoService = new StuInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收 当前页码 和 每页展示条数 url?currentPage&pageSize
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //转为StuInfo
        StuInfo stuInfo = JSON.parseObject(params,StuInfo.class);

        //调用service
        Page<StuInfo> page = stuInfoService.selectByPageAndCondition(currentPage, pageSize,stuInfo);

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
