package com.qf.Servlet;

import com.qf.Account.Account;
import com.qf.Account.AccountApi;
import com.qf.Account.AccountImp;
import com.sun.net.httpserver.Authenticator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AccountApi api = new AccountImp();
        Account account = api.findAccount(username,password);
        if (account!=null){
            resp.sendRedirect("./SuccessServlet");
        }else {
            resp.sendRedirect("./FailServlet");
        }
    }
}
