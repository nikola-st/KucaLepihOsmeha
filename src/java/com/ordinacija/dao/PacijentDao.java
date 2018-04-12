package com.ordinacija.dao;

/**
 *
 * @author Nikola Stojicevic
 */

import java.util.*;  
import java.sql.*; 
import com.ordinacija.model.*;
  
public class PacijentDao {  
  
    public static Connection getConnection(){  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordinacija","root","");  
        }catch(ClassNotFoundException | SQLException ex){System.out.println(ex);}  
        return con;  
    }
    
    public int save(Pacijent p){  
        int status = 0;  
        try{  
            try (Connection con = PacijentDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into pacijenti (ime,prezime,adresa,telefon) values (?,?,?,?)");
                ps.setString(1,p.getIme());
                ps.setString(2,p.getPrezime());
                ps.setString(3,p.getAdresa());
                ps.setString(4,p.getTelefon());
                
                status=ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int update(Pacijent p){
        int status = 0;  
        try{  
            try (Connection con = PacijentDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update pacijenti set ime=?, prezime=?, adresa=?, telefon=? where id=?");
                ps.setString(1,p.getIme());
                ps.setString(2,p.getPrezime());
                ps.setString(3,p.getAdresa());
                ps.setString(4,p.getTelefon());
                ps.setInt(5,p.getId());
                
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int delete(int id){  
        int status = 0;  
        try{  
            try (Connection con = PacijentDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from pacijenti where id=?");
                ps.setInt(1,id);
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public Pacijent getPacijentById(int id){  
        Pacijent p = new Pacijent();  
          
        try{  
            try (Connection con = PacijentDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from pacijenti where id=?");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    p.setId(rs.getInt(1));
                    p.setIme(rs.getString(2));
                    p.setPrezime(rs.getString(3));
                    p.setAdresa(rs.getString(4));
                    p.setTelefon(rs.getString(5));
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return p;  
    }  
    
    public List<Pacijent> getAllPacijenti(){  
        
        List<Pacijent> listaP = new ArrayList<>();  
          
        try{  
            try (Connection con = PacijentDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from pacijenti");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Pacijent p = new Pacijent();
                    p.setId(rs.getInt(1));
                    p.setIme(rs.getString(2));
                    p.setPrezime(rs.getString(3));
                    p.setAdresa(rs.getString(4));
                    p.setTelefon(rs.getString(5));
                    listaP.add(p);
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return listaP;  
    }
    
    public List<Pacijent> getAllPacijentiByName(String name){  
        
        List<Pacijent> listaPbn = new ArrayList<>();  
          
        try{  
            try (Connection con = PacijentDao.getConnection()) 
            {
                PreparedStatement ps=con.prepareStatement("select * from pacijenti where ime=?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Pacijent p = new Pacijent();
                    p.setId(rs.getInt(1));
                    p.setIme(rs.getString(2));
                    p.setPrezime(rs.getString(3));
                    p.setAdresa(rs.getString(4));
                    p.setTelefon(rs.getString(5));
                    listaPbn.add(p);
                }
            }  
        }
        catch(SQLException ex){ex.getMessage();}  
          
        return listaPbn;  
    }
} 