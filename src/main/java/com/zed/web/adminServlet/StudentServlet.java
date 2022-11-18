package com.zed.web.adminServlet;


import com.alibaba.fastjson.JSON;
import com.zed.entity.*;
import com.zed.service.*;
import com.zed.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.List;

@WebServlet("/stu/*")
public class StudentServlet extends BaseServlet {
    private StuInfoService stuInfoService = new StuInfoServiceImpl();
    private VisitorService visitorService = new VisitorServiceImpl();
    private ItemService itemService = new ItemServiceImpl();

    private RepairService repairService = new RepairServiceImpl();
    private BillService billService = new BillServiceImpl();


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
        StuInfo stuInfo = JSON.parseObject(params, StuInfo.class);
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

    public void addItemIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Item item = JSON.parseObject(params, Item.class);

        //调用方法
        itemService.addItemIn(item);

        //添加成功则提示
        response.getWriter().write("success");
    }

    public void addItemOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Item item = JSON.parseObject(params, Item.class);

        //调用方法
        itemService.addItemOut(item);

        //添加成功则提示
        response.getWriter().write("success");
    }

    public void selectDeptInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        String value = "";
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)) {
                value = URLDecoder.decode(cookie.getValue(), "utf-8");
                break;
            }
        }

        //转为StuInfo
        List<StuInfo> deptInfo = stuInfoService.selectDeptInfo(value);
//        System.out.println(deptInfo);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(deptInfo);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void addRepairInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Repair repair = JSON.parseObject(params, Repair.class);

        //调用方法
        repairService.addRepairInfo(repair);

        //添加成功则提示
        response.getWriter().write("success");
    }

    public void selectDeptBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        String value = "";
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)) {
                value = URLDecoder.decode(cookie.getValue(), "utf-8");
                break;
            }
        }
        Calendar cal = Calendar.getInstance();
        int _year = cal.get(Calendar.YEAR);
        int _month = cal.get(Calendar.MONTH ) + 1;
        String year =  _year + "-";
        String month = "";
        if(_month < 10)
            month = "0" + _month;
        else
            month = _month + "";
        String date = year + month;
        //转为StuInfo
        List<Bill> bills = billService.selectDeptBill(value,date);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(bills);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectAllBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        String value = "";
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)) {
                value = URLDecoder.decode(cookie.getValue(), "utf-8");
                break;
            }
        }
        //转为StuInfo
        List<Bill> bills = billService.selectAllBill(value);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(bills);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

}
