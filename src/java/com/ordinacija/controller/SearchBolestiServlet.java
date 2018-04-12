package com.ordinacija.controller;

import com.ordinacija.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchBolestiServlet extends HttpServlet {
    
    private static final String LIST = "/listabolesti.jsp";

    private BolestiDao dao = new BolestiDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("trazi");
        
        String rd = LIST;
        
        request.setAttribute("bolesti", dao.getAllBolestiByName(name));
        
        request.getRequestDispatcher(rd).forward(request, response);
    }
}