package com.zed.web.adminServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String requestURI = req.getRequestURI();
        // System.out.println(requestURI);
        //2.获取最后一段路径 ==>方法名
        int index = requestURI.lastIndexOf("/");
        String methodName = requestURI.substring(index + 1);  //   /select
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method = aClass.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            try {
                method.invoke(this,req,resp);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}
