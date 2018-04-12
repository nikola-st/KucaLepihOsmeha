package com.ordinacija.controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ordinacija.dao.*;
import com.ordinacija.model.*;
import javax.servlet.http.HttpSession;
 
public class PregledController extends HttpServlet {
    
    private static final String INSERT = "/pregled.jsp";
    private static final String EDIT = "/editpregled.jsp";
    private static final String LIST = "/listapregleda.jsp";
    private static final String LIST_ALL = "/listasvihpregleda.jsp";
    
    private PregledDao dao = new PregledDao();
    private PacijentDao daop = new PacijentDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String rd = "";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("edit")) {
            String pregledId = request.getParameter("pregledID");
            Pregled pregled = dao.getPregledById(Integer.parseInt(pregledId));
            rd = EDIT;
            request.setAttribute("pregled", pregled);
        }
        
        else if (action.equalsIgnoreCase("lista")) {
            String pacijentId = request.getParameter("pacijentId");
            rd = LIST;
            request.setAttribute("preglediP", dao.getPregledById(Integer.parseInt(pacijentId)));
            request.setAttribute("pacijentP", daop.getPacijentById(Integer.parseInt(pacijentId)));
        } 
        else if(action.equalsIgnoreCase("novi")) {
            
            //HttpSession session=request.getSession(true); 
            //String id = (String)session.getAttribute("id");
            String pacijentId = request.getParameter("pacijentId");
                    
            rd = INSERT;
            request.setAttribute("pacijentID", pacijentId);
            //request.setAttribute("lekarID", id);
        }
        else{
            
            rd = LIST_ALL;
            request.setAttribute("preglediP", dao.getAllPregledi());
        } 
        request.getRequestDispatcher(rd).forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        String id = request.getParameter("pregledID");
        String idP = request.getParameter("pacijentID");
        String idL = request.getParameter("lekarID");
        String datum = request.getParameter("datum");
        String nalaz = request.getParameter("nalaz");

        if(id == null || id.isEmpty())
            {
                Pregled p = new Pregled (Integer.parseInt(idP), Integer.parseInt(idL), datum, nalaz);
                dao.save(p);
            }   

        else
            {
                Pregled pUpdate = new Pregled (Integer.parseInt(id), Integer.parseInt(idP), Integer.parseInt(idL), datum, nalaz);
                dao.update(pUpdate);
            }

        request.setAttribute("preglediP", dao.getAllPreglediByPid(Integer.parseInt(idP)));
        request.getRequestDispatcher(LIST).forward(request, response);
    }
}