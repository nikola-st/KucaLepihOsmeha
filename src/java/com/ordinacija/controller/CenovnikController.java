package com.ordinacija.controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ordinacija.dao.*;
import com.ordinacija.model.*;
 
public class CenovnikController extends HttpServlet {
    
    private static final String INSERT_EDIT = "/cenovnik.jsp";
    private static final String LIST = "/listacenovnika.jsp";
    private static final String LIST_PUBLIC = "/cene.jsp";
    
    private CenovnikDao dao = new CenovnikDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String rd = "";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("delete")) {
            String cenovnikId = request.getParameter("cenovnikId");
            dao.delete(Integer.parseInt(cenovnikId));
            rd = LIST;
            request.setAttribute("usluge", dao.getAllCenovnik());    
        } 
        
        else if (action.equalsIgnoreCase("edit")) {
            String cenovnikId = request.getParameter("cenovnikId");
            Cenovnik cenovnik = dao.getCenovnikById(Integer.parseInt(cenovnikId));
            rd = INSERT_EDIT;
            request.setAttribute("cenovnik", cenovnik);
        }
        
        else if (action.equalsIgnoreCase("lista")) {
            rd = LIST;
            request.setAttribute("usluge", dao.getAllCenovnik());
        }
        
        else if (action.equalsIgnoreCase("listaPublic")) {
            rd = LIST_PUBLIC;
            request.setAttribute("usluge", dao.getAllCenovnik());
        }

        else {
            rd = INSERT_EDIT;
        }
        
        request.getRequestDispatcher(rd).forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        String id = request.getParameter("cenovnikID");
        String naziv = request.getParameter("naziv");
        String cena = request.getParameter("cena");

        if(id == null || id.isEmpty())
            {
                Cenovnik c = new Cenovnik (naziv, Float.parseFloat(cena));
                dao.save(c);
            }   

        else
            {
                Cenovnik cUpdate = new Cenovnik (Integer.parseInt(id), naziv, Float.parseFloat(cena));
                dao.update(cUpdate);
            }

        request.setAttribute("usluge", dao.getAllCenovnik());
        request.getRequestDispatcher(LIST).forward(request, response);
    }
}