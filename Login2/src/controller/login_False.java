package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

public class login_False extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ResultSet rs0;
        ResultSet rs1;
        int flag;


        response.setCharacterEncoding("UTF-8");//防止乱码
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");//获取username的值，并赋值
        String password=request.getParameter("password");//获取password的值，并赋值
        String sql0="select username from news_user where username= '"+username+"' ";
        String sql1="select password from news_user where password= '"+password+"' ";
        Connection con=null;

        try{
            con=DBHelp.getConnection();
            Statement stmt1=con.createStatement();
            Statement stmt2=con.createStatement();
            rs0=stmt1.executeQuery(sql0);
            rs1=stmt2.executeQuery(sql1);

            if (rs0.next()){ //判断用户密码正确性
                out.println("密码错误哦，请重新登陆！");
                flag=1;
            }
            else {
                out.println("这个用户名不存在呦");
                flag=2;
            }
        }catch (Exception e){}
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
