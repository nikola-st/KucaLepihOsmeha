package com.ordinacija.controller;

import com.ordinacija.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchCenovnikServlet extends HttpServlet {
    
    private static final String LIST = "/listacenovnika.jsp";

    private CenovnikDao dao = new CenovnikDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("trazi");
        
        String rd = LIST;
        
        request.setAttribute("usluge", dao.getAllCenovnikByName(name));
        
        request.getRequestDispatcher(rd).forward(request, response);
    }
}