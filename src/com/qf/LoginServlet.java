package com.qf;

import com.qf.Account.Account;
import com.qf.Account.AccountApi;
import com.qf.Account.AccountImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("pass");
        AccountApi api = new AccountImp();
        Account account = api.findAccount(username,password);
        if (account==null){
            Cookie cookie = new Cookie("error","用户名或密码错误");
            response.addCookie(cookie);
            response.sendRedirect("login.jsp");
            return;
        }
        else if (remember!=null){
            Cookie cookie = new Cookie("pass","yes");
            Cookie cookie2 = new Cookie("error",null);
            response.addCookie(cookie);
            response.addCookie(cookie2);
        }else {
            Cookie cookie = new Cookie("pass","no");
            Cookie cookie2 = new Cookie("error",null);
            response.addCookie(cookie);
            response.addCookie(cookie2);
        }
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        response.sendRedirect("main.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
