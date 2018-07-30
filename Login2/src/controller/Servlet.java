package controller;

import util.DBHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import method.MD;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet rs0;
        ResultSet rs1;
        MD md=new MD();

        response.setCharacterEncoding("UTF-8");//防止乱码
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");//获取username的值，并赋值
        String pass=request.getParameter("password");//获取password的值，并赋值
        String password=md.convertMD5(pass);//加密后
        String sql0="select username from news_user where username= '"+username+"' ";
        String sql1="select password from news_user where password= '"+password+"' ";
        Connection con=null;

        try{
            con=DBHelp.getConnection();
            Statement stmt1=con.createStatement();
            Statement stmt2=con.createStatement();
            rs0=stmt1.executeQuery(sql0);
            rs1=stmt2.executeQuery(sql1);

            if (rs0.next()&&rs1.next()){ //判断用户密码正确性
                HttpSession session=request.getSession();
                session.setAttribute("loginuser",username);//用session置入用户名
                request.getRequestDispatcher("/login_Success").forward(request,response);//转发至login_Success处理

            }
            else {
                response.sendRedirect("/login_False");
            }
        }catch (Exception e){}



    }
}