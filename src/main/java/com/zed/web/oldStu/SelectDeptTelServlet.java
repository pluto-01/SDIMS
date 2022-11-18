package com.zed.web.oldStu;

import com.alibaba.fastjson.JSON;
import com.zed.entity.StuInfo;
import com.zed.service.StuInfoService;
import com.zed.service.impl.StuInfoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectDeptTelServlet")
public class SelectDeptTelServlet extends HttpServlet {
    private StuInfoService stuInfoService = new StuInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用UserService查询

        List<StuInfo> tels = stuInfoService.selectDepartmentTel();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(tels);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
