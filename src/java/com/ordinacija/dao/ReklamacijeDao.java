package com.ordinacija.dao;

/**
 *
 * @author Nikola Stojicevic
 */

import java.util.*;  
import java.sql.*; 
import com.ordinacija.model.*;
  
public class ReklamacijeDao {  
  
    public static Connection getConnection(){  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordinacija","root","");  
        }catch(ClassNotFoundException | SQLException ex){System.out.println(ex);}  
        return con;  
    }
    
    public int save(Reklamacija r){  
        int status = 0;  
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into reklamacija (datum, opis, status, id_pacijenta) values (?,?,?,?)");
                ps.setString(1,r.getDatum());
                ps.setString(2,r.getOpis());
                ps.setString(3,r.getStatus());
                ps.setInt(4,r.getId_pacijenta());
                
                status=ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int update(Reklamacija r){
        int status = 0;  
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update reklamacija set datum=?, opis=?, status=?, id_pacijenta=? where id=?");
                ps.setString(1,r.getDatum());
                ps.setString(2,r.getOpis());
                ps.setString(3,r.getStatus());
                ps.setInt(4,r.getId_pacijenta());
                ps.setInt(5,r.getId());
                
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int delete(int id){  
        int status = 0;  
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from reklamacija where id=?");
                ps.setInt(1,id);
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public boolean solve(int id){
        boolean status = false;   
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update reklamacija set status=resena where id_pacijenta=?");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                status = rs.next();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    } 
    
    public Reklamacija getReklamacijaById(int id, int id_pacijenta){  
        Reklamacija r = new Reklamacija();  
          
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from reklamacija where id=? and id_pacijenta=?");
                ps.setInt(1,id);
                ps.setInt(2,id_pacijenta);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    r.setId(rs.getInt(1));
                    r.setDatum(rs.getString(2));
                    r.setOpis(rs.getString(3));
                    r.setStatus(rs.getString(4));
                    r.setId_pacijenta(rs.getInt(5));
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return r;  
    }  
    
    public List<Reklamacija> getAllReklamacije(){  
        
        List<Reklamacija> listaR = new ArrayList<>();  
          
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from reklamacija");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Reklamacija r = new Reklamacija();
                    r.setId(rs.getInt(1));
                    r.setDatum(rs.getString(2));
                    r.setOpis(rs.getString(3));
                    r.setStatus(rs.getString(4));
                    r.setId_pacijenta(rs.getInt(5));
                    listaR.add(r);
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return listaR;  
    }
    
    public List<Reklamacija> getAllPacijentReklamacije(int id){  
        
        List<Reklamacija> listaR = new ArrayList<>();  
        int idP = id;  
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from reklamacija where id_pacijenta=?");
                ps.setInt(1,idP);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Reklamacija r = new Reklamacija();
                    r.setId(rs.getInt(1));
                    r.setDatum(rs.getString(2));
                    r.setOpis(rs.getString(3));
                    r.setStatus(rs.getString(4));
                    r.setId_pacijenta(rs.getInt(5));
                    listaR.add(r);
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return listaR;  
    }
    
    public List<Reklamacija> getAllReklamacijeByStatus(){  
        
        List<Reklamacija> listaRbs = new ArrayList<>();  
          
        try{  
            try (Connection con = ReklamacijeDao.getConnection()) 
            {
                PreparedStatement ps=con.prepareStatement("select * from pacijenti where status=neresena");
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Reklamacija r = new Reklamacija();
                    r.setId(rs.getInt(1));
                    r.setDatum(rs.getString(2));
                    r.setOpis(rs.getString(3));
                    r.setStatus(rs.getString(4));
                    r.setId_pacijenta(rs.getInt(5));
                    listaRbs.add(r);
                }
            }  
        }
        catch(SQLException ex){ex.getMessage();}  
          
        return listaRbs;  
    }
} 