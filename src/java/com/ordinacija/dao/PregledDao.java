package com.ordinacija.dao;

/**
 *
 * @author Nikola Stojicevic
 */

import java.util.*;  
import java.sql.*; 
import com.ordinacija.model.*;
  
public class PregledDao {  
  
    public static Connection getConnection(){  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordinacija","root","");  
        }catch(ClassNotFoundException | SQLException ex){System.out.println(ex);}  
        return con;  
    }
    
    public int save(Pregled p){  
        int status = 0;  
        try{  
            try (Connection con = PregledDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into pregledi (id_pacijenta,id_lekara,datum,nalaz) values (?,?,?,?)");
                ps.setInt(1,p.getId_pacijenta());
                ps.setInt(2,p.getId_lekara());
                ps.setString(3,p.getDatum());
                ps.setString(4,p.getNalaz());
                
                status=ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int update(Pregled p){
        int status = 0;  
        try{  
            try (Connection con = PregledDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update pregledi set id_pacijenta=?, id_lekara=?, datum=?, nalaz=? where id=?");
                ps.setInt(1,p.getId_pacijenta());
                ps.setInt(2,p.getId_lekara());
                ps.setString(3,p.getDatum());
                ps.setString(4,p.getNalaz());
                ps.setInt(5,p.getId());
                
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }    
    
    public Pregled getPregledById(int id){  
        Pregled p = new Pregled();  
          
        try{  
            try (Connection con = PregledDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from pregledi where id=?");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    p.setId(rs.getInt(1));
                    p.setId_pacijenta(rs.getInt(4));
                    p.setId_lekara(rs.getInt(5));
                    p.setDatum(rs.getString(2));
                    p.setNalaz(rs.getString(3));
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return p;  
    }  
    
    public List<Pregled> getAllPregledi(){  
        
        List<Pregled> listaP = new ArrayList<>();  
          
        try{  
            try (Connection con = PregledDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from pregledi");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Pregled p = new Pregled();
                    p.setId(rs.getInt(1));
                    p.setId_pacijenta(rs.getInt(4));
                    p.setId_lekara(rs.getInt(5));
                    p.setDatum(rs.getString(2));
                    p.setNalaz(rs.getString(3));
                    listaP.add(p);
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return listaP;  
    }
    
    public List<Pregled> getAllPreglediByPid(int idp){  
        
        List<Pregled> listaPbn = new ArrayList<>();  
          
        try{  
            try (Connection con = PregledDao.getConnection()) 
            {
                PreparedStatement ps=con.prepareStatement("select * from pregledi where id_pacijenta=?");
                ps.setInt(1, idp);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Pregled p = new Pregled();
                    p.setId(rs.getInt(1));
                    p.setId_pacijenta(rs.getInt(4));
                    p.setId_lekara(rs.getInt(5));
                    p.setDatum(rs.getString(2));
                    p.setNalaz(rs.getString(3));
                    listaPbn.add(p);
                }
            }  
        }
        catch(SQLException ex){ex.getMessage();}  
          
        return listaPbn;  
    }
} 