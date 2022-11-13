package com.zed.web.adminServlet;

import com.alibaba.fastjson.JSON;
import com.zed.entity.Page;
import com.zed.entity.StuInfo;
import com.zed.entity.Visitor;
import com.zed.service.StuInfoService;
import com.zed.service.VisitorService;
import com.zed.service.impl.StuInfoServiceImpl;
import com.zed.service.impl.VisitorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet{
    private StuInfoService stuInfoService = new StuInfoServiceImpl();
    private VisitorService visitorService = new VisitorServiceImpl();
    public void selectStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //调用UserService查询

        List<StuInfo> stus = stuInfoService.selectStu();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(stus);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public void addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        StuInfo stuInfo = JSON.parseObject(params, StuInfo.class);

        //调用方法
        stuInfoService.add(stuInfo);

        //添加成功则提示
        response.getWriter().write("success");
    }
    public void deleteStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
    public void editInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        StuInfo stuInfo = JSON.parseObject(params, StuInfo.class);

        //调用方法
        stuInfoService.editStuInfo(stuInfo);

        //添加成功则提示
        response.getWriter().write("success");
    }
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //接收 当前页码 和 每页展示条数 url?currentPage&pageSize
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

//        Cookie[] cookies = request.getCookies();
//        Cookie sCookie = null;
//        String cookievalue = "";
//        for (int i = 0; i < cookies.length; i++){
//            sCookie =cookies[i];
//            if (sCookie.getName() !=null && sCookie.getName().equals("username"))
//                cookievalue = URLDecoder.decode(sCookie.getValue(),"utf-8");
//        }



        //获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //转为StuInfo
        StuInfo stuInfo = JSON.parseObject(params,StuInfo.class);

        //调用service
        Page<StuInfo> page = stuInfoService.selectByPageAndCondition(currentPage, pageSize,stuInfo);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(page);
//        String jsonString2 = JSON.toJSONString(cookievalue);
        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
//        response.getWriter().write(jsonString2);
    }
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
    public void addVisitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    public void selectVisitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //visitorService

        List<Visitor> vsts = visitorService.selectVisitor();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(vsts);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


}

