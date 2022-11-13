package com.zed.web.adminServlet;


import com.alibaba.fastjson.JSON;
import com.zed.entity.StuInfo;
import com.zed.service.StuInfoService;
import com.zed.service.impl.StuInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/stu/*")
public class StudentServlet extends BaseServlet{
    private StuInfoService stuInfoService = new StuInfoServiceImpl();
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    public void selectDeptTelByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //转为StuInfo
        StuInfo stuInfo = JSON.parseObject(params,StuInfo.class);

        //调用service
        List<StuInfo> tels = stuInfoService.selectTelByCondition(stuInfo);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(tels);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public void selectDeptTel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用UserService查询

        List<StuInfo> tels = stuInfoService.selectDepartmentTel();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(tels);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

}
