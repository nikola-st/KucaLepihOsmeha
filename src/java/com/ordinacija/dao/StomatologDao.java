package com.ordinacija.dao;

/**
 *
 * @author Nikola Stojicevic
 */

import java.util.*;  
import java.sql.*; 
import com.ordinacija.model.*;
  
public class StomatologDao {  
  
    public static Connection getConnection(){  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordinacija","root","");  
        }catch(ClassNotFoundException | SQLException ex){System.out.println(ex);}  
        return con;  
    }
    
    public int save(Stomatolog s){  
        int status = 0;  
        try{  
            try (Connection con = StomatologDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into lekar (username, pass) values (?,?)");
                ps.setString(1,s.getUsername());
                ps.setString(2,s.getPass());
                
                status=ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int update(Stomatolog s){
        int status = 0;  
        try{  
            try (Connection con = StomatologDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update lekar set username=?, pass=? where id=?");
                ps.setString(1,s.getUsername());
                ps.setString(2,s.getPass());
                ps.setInt(3,s.getId());
                
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int delete(int id){  
        int status = 0;  
        try{  
            try (Connection con = StomatologDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from lekar where id=?");
                ps.setInt(1,id);
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public Stomatolog getStomatologById(int id){  
        Stomatolog s = new Stomatolog();  
          
        try{  
            try (Connection con = StomatologDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from lekar where id=?");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    s.setId(rs.getInt(1));
                    s.setUsername(rs.getString(2));
                    s.setPass(rs.getString(3));
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return s;  
    }

    public boolean validate(String username, String password){  
        boolean status = false;  
          
        try{  
            try (Connection con = StomatologDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from lekar where username=? and pass=?");
                ps.setString(1,username);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                status = rs.next();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
     public Stomatolog getStomatolog(String username, String password){  
        Stomatolog s = new Stomatolog();  
          
        try{  
            try (Connection con = StomatologDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from lekar where username=? and pass=?");
                ps.setString(1,username);
                ps.setString(1,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    s.setId(rs.getInt(1));
                    s.setUsername(rs.getString(2));
                    s.setPass(rs.getString(3));
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return s;  
    }   
    
    public List<Stomatolog> getAllStomatolozi(){  
        
        List<Stomatolog> listaS = new ArrayList<>();  
          
        try{  
            try (Connection con = StomatologDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from lekar");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Stomatolog s = new Stomatolog();
                    s.setId(rs.getInt(1));
                    s.setUsername(rs.getString(2));
                    s.setPass(rs.getString(3));
                    listaS.add(s);
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return listaS;  
    }
    
    public List<Stomatolog> getAllStomatoloziByName(String name){  
        
        List<Stomatolog> listaSbn = new ArrayList<>();  
          
        try{  
            try (Connection con = StomatologDao.getConnection()) 
            {
                PreparedStatement ps=con.prepareStatement("select * from pacijenti where username=?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Stomatolog s = new Stomatolog();
                    s.setId(rs.getInt(1));
                    s.setUsername(rs.getString(2));
                    s.setPass(rs.getString(3));
                    listaSbn.add(s);
                }
            }  
        }
        catch(SQLException ex){ex.getMessage();}  
          
        return listaSbn;  
    }
} 