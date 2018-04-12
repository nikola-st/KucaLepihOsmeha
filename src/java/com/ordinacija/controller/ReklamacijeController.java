package com.ordinacija.controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ordinacija.dao.*;
import com.ordinacija.model.*;
 
public class ReklamacijeController extends HttpServlet {
    
    private static final String LIST_A = "/listareklamacija.jsp";
    private static final String LIST = "/listapacijenata.jsp";
    private static final String LIST_R = "/listareklamacijaP.jsp";
    private static final String NEW = "/novareklamacija.jsp";
    
    private ReklamacijeDao dao = new ReklamacijeDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String rd = "";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("delete")) {
            String pacijentId = request.getParameter("pacijentId");
            dao.delete(Integer.parseInt(pacijentId));
            rd = LIST_R;
            request.setAttribute("reklamacijeP", dao.getAllPacijentReklamacije(Integer.parseInt(pacijentId)));    
        } 
        
        else if (action.equalsIgnoreCase("listaP")) {
            
            String pacijentId = request.getParameter("pacijentId");
            rd = LIST_R;
            request.setAttribute("reklamacijeP", dao.getAllPacijentReklamacije(Integer.parseInt(pacijentId)));
        
        }else if (action.equalsIgnoreCase("neresena")) {
            
            rd = LIST_A;
            request.setAttribute("reklamacije", dao.getAllReklamacijeByStatus());
        }
        else if (action.equalsIgnoreCase("new")) {
            String pacijentId = request.getParameter("pacijentId");
            
            rd = NEW;
            request.setAttribute("nova", pacijentId);
        }

        else {
            rd = LIST_A;
        }
        
        request.getRequestDispatcher(rd).forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
         String pacijentId = request.getParameter("id_pacijenta");
         String datum = request.getParameter("datum");
         String opis = request.getParameter("opis");
         String status = request.getParameter("status");
         
         Reklamacija r = new Reklamacija(Integer.parseInt(pacijentId), datum, opis, status);
            dao.save(r);
            request.setAttribute("reklamacijeP", dao.getAllPacijentReklamacije(Integer.parseInt(pacijentId)));
            request.getRequestDispatcher(LIST_R).forward(request, response);
        

        /*if(id == null || id.isEmpty())
            {
                Reklamacija r = new Reklamacija(Integer.parseInt(pacijentId), datum, opis, status);
                dao.save(r);
            }   

        else
            {
                Pacijent pUpdate = new Pacijent (Integer.parseInt(id), ime, prezime, adresa, telefon );
                dao.update(pUpdate);
            }

        request.setAttribute("pacijenti", dao.getAllPacijenti());
        request.getRequestDispatcher(LIST).forward(request, response);
    */
}
}