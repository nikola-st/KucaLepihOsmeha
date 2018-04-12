package com.ordinacija.controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ordinacija.dao.*;
import com.ordinacija.model.*;
import javax.servlet.http.HttpSession;
 
public class StomatologController extends HttpServlet {
    
    private static final String RD = "PacijentController?action=lista";
    private static final String GRESKA ="login.jsp";
    
    private StomatologDao dao = new StomatologDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username !=null && username.length()>0 && password!=null && password.length()>0){
               
                if(dao.validate(username, password)){
                    Stomatolog s = dao.getStomatolog(username, password);
                    String idStomatologa = Integer.toString(s.getId());
                    
                    HttpSession session=request.getSession();  
                    
                    session.setAttribute("stomatolog",username);
                    session.setAttribute("id", idStomatologa);
                    
                    request.getRequestDispatcher(RD).forward(request, response);
                }else{
                    request.setAttribute("poruka", "Pogresan username ili password");
                    request.getRequestDispatcher(GRESKA).forward(request, response);
                }
            }
        else
            {
                request.setAttribute("poruka", "Morate uneti sve podatke!");
                request.getRequestDispatcher(GRESKA).forward(request, response);
        }   
    }
}