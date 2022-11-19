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
import java.util.List;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {
    private StuInfoService stuInfoService = new StuInfoServiceImpl();
    private VisitorService visitorService = new VisitorServiceImpl();
    private ItemService itemService = new ItemServiceImpl();
    private PropertyService propertyService = new PropertyServiceImpl();
    private RepairService repairService = new RepairServiceImpl();
    private BillService billService = new BillServiceImpl();

    public void selectStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用UserService查询

        List<StuInfo> stus = stuInfoService.selectStu();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(stus);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    public void deleteStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    public void editInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收 当前页码 和 每页展示条数 url?currentPage&pageSize
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();
        System.out.println(params);
        //转为StuInfo
        StuInfo stuInfo = JSON.parseObject(params, StuInfo.class);
        System.out.println(stuInfo);
        //调用service
        Page<StuInfo> page = stuInfoService.selectByPageAndCondition(currentPage, pageSize, stuInfo);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(page);
        System.out.println(jsonString);
        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    //    public void addVisitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//
//        //接收以JSON格式传来的数据
//        BufferedReader br = request.getReader();
//        String params = br.readLine();//JSON字符串
//
//        //将JSON字符串转为StuInfo对象
//        Visitor visitor = JSON.parseObject(params, Visitor.class);
//
//        //调用方法
//        visitorService.addVisitor(visitor);
//
//        //添加成功则提示
//        response.getWriter().write("success");
//    }
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

    public void selectItemIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemService.selectItemIn();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(items);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    //    public void addItemIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//
//        //接收以JSON格式传来的数据
//        BufferedReader br = request.getReader();
//        String params = br.readLine();//JSON字符串
//
//        //将JSON字符串转为StuInfo对象
//        Item item = JSON.parseObject(params, Item.class);
//
//        //调用方法
//        itemService.addItemIn(item);
//
//        //添加成功则提示
//        response.getWriter().write("success");
//    }
    public void selectItemOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemService.selectItemOut();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(items);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    //    public void addItemOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//
//        //接收以JSON格式传来的数据
//        BufferedReader br = request.getReader();
//        String params = br.readLine();//JSON字符串
//
//        //将JSON字符串转为StuInfo对象
//        Item item = JSON.parseObject(params, Item.class);
//
//        //调用方法
//        itemService.addItemOut(item);
//
//        //添加成功则提示
//        response.getWriter().write("success");
//    }
    public void selectProperty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Property> props = propertyService.selectProperty();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(props);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void addProperty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Property property = JSON.parseObject(params, Property.class);

        //调用方法
        propertyService.addProperty(property);

        //添加成功则提示
        response.getWriter().write("success");
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

    public void editRepairInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Repair repair = JSON.parseObject(params, Repair.class);

        //调用方法
        repairService.editRepairInfo(repair);

        //添加成功则提示
        response.getWriter().write("success");
    }

    public void selectBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bill> bills = billService.selectBill();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(bills);

        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectBillByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //转为StuInfo
        Bill bill = JSON.parseObject(params, Bill.class);

        //调用service
        List<Bill> bills = billService.selectBillByCondition(bill);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(bills);
        //写数据
        //防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void editBillInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Bill bill = JSON.parseObject(params, Bill.class);

        //调用方法
        billService.editBill(bill);

        //添加成功则提示
        response.getWriter().write("success");
    }

    public void addBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //接收以JSON格式传来的数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //将JSON字符串转为StuInfo对象
        Bill bill = JSON.parseObject(params, Bill.class);

        //调用方法
        billService.addBill(bill);

        //添加成功则提示
        response.getWriter().write("success");
    }

}

