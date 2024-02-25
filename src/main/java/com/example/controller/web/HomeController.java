package com.example.controller.web;

import com.example.model.AccountModel;
import com.example.service.impl.AccountService;
import com.example.utils.FormUtil;
import com.example.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/home", "/login"})
public class HomeController extends HttpServlet {

    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String action = req.getParameter("action");
        if(action != null && action.equals("login")) {
            AccountModel accountModel = FormUtil.toModel(AccountModel.class, req);
            AccountModel acc = accountService.Login(accountModel.getUsername(), accountModel.getPassword());
            if(acc.getUsername() != null && acc.getPassword() != null) {
                resp.sendRedirect(req.getContextPath()+"/home");
            } else {
                resp.sendRedirect(req.getContextPath()+"/login?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
}
