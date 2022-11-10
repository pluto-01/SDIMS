package com.zed.web.adminServlet.student;

import com.zed.mapper.LoginMapper;
import com.zed.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户名及密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String value = request.getParameter("identity");

        //调用MyBatis查询

        //获取SqlSessionFactory对象  来源：MyBatis官网
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        //调用方法
        User user1 = loginMapper.select1(username, password);
        User user2 = loginMapper.select2(username, password);
        User user3 = loginMapper.select3(username,password);
        //释放资源
        sqlSession.close();


        //获取对应字符输出流，并设置 content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //判断user不为null，则登录成功  否则登录失败
        if (value.equals("1")) {
            if (user1 != null) {
                request.getRequestDispatcher("/user-admin.html").forward(request, response);
//                HttpSession session = request.getSession();
//                session.setAttribute("getUserName",user1);
//
//                String contextPath =request.getContextPath();
//                response.sendRedirect(contextPath+"/getUserInfoServlet");

            }
            else
                writer.write("登录失败");
        }
        if (value.equals("2")) {
            if (user2 != null)

            {
//                HttpSession session = request.getSession();
//                session.setAttribute("getUserInfo",user2);

//                String contextPath =request.getContextPath();
//                response.sendRedirect(contextPath+"/getUserInfoServlet");
                request.getRequestDispatcher("/user-stu.html").forward(request, response);
            }
            else
                writer.write("登录失败");
        }
        if (value.equals("3")) {
            if (user3 != null)
                request.getRequestDispatcher("/user-worker.html").forward(request, response);
            else
                writer.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
