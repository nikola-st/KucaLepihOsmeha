package com.ordinacija.controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ordinacija.dao.*;
import com.ordinacija.model.*;
 
public class PacijentController extends HttpServlet {
    
    private static final String INSERT_EDIT = "/pacijent.jsp";
    private static final String LIST = "/listapacijenata.jsp";
    
    private PacijentDao dao = new PacijentDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String rd = "";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("delete")) {
            String pacijentId = request.getParameter("pacijentId");
            dao.delete(Integer.parseInt(pacijentId));
            rd = LIST;
            request.setAttribute("pacijenti", dao.getAllPacijenti());    
        } 
        
        else if (action.equalsIgnoreCase("edit")) {
            String pacijentId = request.getParameter("pacijentId");
            Pacijent pacijent = dao.getPacijentById(Integer.parseInt(pacijentId));
            rd = INSERT_EDIT;
            request.setAttribute("pacijent", pacijent);
        }
        
        else if (action.equalsIgnoreCase("lista")) {
            rd = LIST;
            request.setAttribute("pacijenti", dao.getAllPacijenti());
        }

        else {
            rd = INSERT_EDIT;
        }
        
        request.getRequestDispatcher(rd).forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        String id = request.getParameter("pacijentID");
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String adresa = request.getParameter("adresa");
        String telefon = request.getParameter("telefon");

        if(id == null || id.isEmpty())
            {
                Pacijent p = new Pacijent (ime, prezime, adresa, telefon);
                dao.save(p);
            }   

        else
            {
                Pacijent pUpdate = new Pacijent (Integer.parseInt(id), ime, prezime, adresa, telefon );
                dao.update(pUpdate);
            }

        request.setAttribute("pacijenti", dao.getAllPacijenti());
        request.getRequestDispatcher(LIST).forward(request, response);
    }
}