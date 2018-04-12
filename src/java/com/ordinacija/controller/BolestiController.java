package com.ordinacija.controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ordinacija.dao.*;
import com.ordinacija.model.*;
 
public class BolestiController extends HttpServlet {
    
    private static final String INSERT_EDIT = "/bolesti.jsp";
    private static final String LIST = "/listabolesti.jsp";
    
    private BolestiDao dao = new BolestiDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String rd = "";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("delete")) {
            String bolestId = request.getParameter("bolestId");
            dao.delete(Integer.parseInt(bolestId));
            rd = LIST;
            request.setAttribute("bolesti", dao.getAllBolesti());    
        } 
        
        else if (action.equalsIgnoreCase("edit")) {
            String bolestId = request.getParameter("bolestId");
            Bolesti bolest = dao.getBolestById(Integer.parseInt(bolestId));
            rd = INSERT_EDIT;
            request.setAttribute("bolest", bolest);
        }
        
        else if (action.equalsIgnoreCase("lista")) {
            rd = LIST;
            request.setAttribute("bolesti", dao.getAllBolesti());
        }

        else {
            rd = INSERT_EDIT;
        }
        
        request.getRequestDispatcher(rd).forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        String id = request.getParameter("bolestID");
        String sifra = request.getParameter("sifra");
        String naziv = request.getParameter("naziv");
        String opis = request.getParameter("opis");

        if(id == null || id.isEmpty())
            {
                Bolesti b = new Bolesti (sifra, naziv, opis);
                dao.save(b);
            }   

        else
            {
                Bolesti bUpdate = new Bolesti (Integer.parseInt(id), sifra, naziv, opis );
                dao.update(bUpdate);
            }

        request.setAttribute("bolesti", dao.getAllBolesti());
        request.getRequestDispatcher(LIST).forward(request, response);
    }
}