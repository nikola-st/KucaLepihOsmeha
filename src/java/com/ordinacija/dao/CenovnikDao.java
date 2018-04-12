package com.ordinacija.dao;

/**
 *
 * @author Nikola Stojicevic
 */

import java.util.*;  
import java.sql.*; 
import com.ordinacija.model.*;
  
public class CenovnikDao {  
  
    public static Connection getConnection(){  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordinacija","root","");  
        }catch(ClassNotFoundException | SQLException ex){System.out.println(ex);}  
        return con;  
    }
    
    public int save(Cenovnik c){  
        int status = 0;  
        try{  
            try (Connection con = CenovnikDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into usluge (naziv,cena) values (?,?)");
                ps.setString(1,c.getNaziv());
                ps.setFloat(2,c.getCena());
                
                status=ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int update(Cenovnik c){
        int status = 0;  
        try{  
            try (Connection con = CenovnikDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update usluge set naziv=?, cena=? where id=?");
                ps.setString(1,c.getNaziv());
                ps.setFloat(2,c.getCena());
                ps.setInt(3,c.getId());
                
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int delete(int id){  
        int status = 0;  
        try{  
            try (Connection con = CenovnikDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from usluge where id=?");
                ps.setInt(1,id);
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public Cenovnik getCenovnikById(int id){  
        Cenovnik c = new Cenovnik();  
          
        try{  
            try (Connection con = CenovnikDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from usluge where id=?");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    c.setId(rs.getInt(1));
                    c.setNaziv(rs.getString(2));
                    c.setCena(rs.getFloat(3));
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return c;  
    }  
    
    public List<Cenovnik> getAllCenovnik(){  
        
        List<Cenovnik> listaC = new ArrayList<>();  
          
        try{  
            try (Connection con = CenovnikDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from usluge");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Cenovnik c = new Cenovnik();
                    c.setId(rs.getInt(1));
                    c.setNaziv(rs.getString(2));
                    c.setCena(rs.getFloat(3));
                    listaC.add(c);
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return listaC;  
    }
    
    public List<Cenovnik> getAllCenovnikByName(String name){  
        
        List<Cenovnik> listaCbn = new ArrayList<>();  
          
        try{  
            try (Connection con = CenovnikDao.getConnection()) 
            {
                PreparedStatement ps=con.prepareStatement("select * from usluge where naziv=?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Cenovnik c = new Cenovnik();
                    c.setId(rs.getInt(1));
                    c.setNaziv(rs.getString(2));
                    c.setCena(rs.getFloat(3));
                    listaCbn.add(c);
                }
            }  
        }
        catch(SQLException ex){ex.getMessage();}  
          
        return listaCbn;  
    }
} 