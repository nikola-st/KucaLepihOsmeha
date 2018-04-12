package com.ordinacija.dao;

/**
 *
 * @author Nikola Stojicevic
 */

import java.util.*;  
import java.sql.*; 
import com.ordinacija.model.*;
  
public class BolestiDao {  
  
    public static Connection getConnection(){  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordinacija","root","");  
        }catch(ClassNotFoundException | SQLException ex){System.out.println(ex);}  
        return con;  
    }
    
    public int save(Bolesti b){  
        int status = 0;  
        try{  
            try (Connection con = BolestiDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into bolesti (sifra, naziv, opis) values (?,?,?)");
                ps.setString(1,b.getSifra());
                ps.setString(2,b.getNaziv());
                ps.setString(3,b.getOpis());
                
                status=ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int update(Bolesti b){
        int status = 0;  
        try{  
            try (Connection con = BolestiDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update bolesti set sifra=?, naziv=?, opis=? where id=?");
                ps.setString(1,b.getSifra());
                ps.setString(2,b.getNaziv());
                ps.setString(3,b.getOpis());
                ps.setInt(4,b.getId());
                
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public int delete(int id){  
        int status = 0;  
        try{  
            try (Connection con = PacijentDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from bolesti where id=?");
                ps.setInt(1,id);
                status = ps.executeUpdate();
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return status;  
    }  
    
    public Bolesti getBolestById(int id){  
        Bolesti b = new Bolesti();  
          
        try{  
            try (Connection con = BolestiDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from bolesti where id=?");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    b.setId(rs.getInt(1));
                    b.setSifra(rs.getString(2));
                    b.setNaziv(rs.getString(3));
                    b.setOpis(rs.getString(4));
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return b;  
    }  
    
    public List<Bolesti> getAllBolesti(){  
        
        List<Bolesti> listaB = new ArrayList<>();  
          
        try{  
            try (Connection con = BolestiDao.getConnection()) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM `bolesti` ORDER BY `bolesti`.`sifra` ASC");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Bolesti b = new Bolesti();
                    b.setId(rs.getInt(1));
                    b.setSifra(rs.getString(2));
                    b.setNaziv(rs.getString(3));
                    b.setOpis(rs.getString(4));
                    listaB.add(b);
                }
            }  
        }catch(SQLException ex){ex.getMessage();}  
          
        return listaB;  
    }
    
    public List<Bolesti> getAllBolestiByName(String name){  
        
        List<Bolesti> listaBbn = new ArrayList<>();  
          
        try{  
            try (Connection con = BolestiDao.getConnection()) 
            {
                PreparedStatement ps=con.prepareStatement("select * from bolesti where naziv=?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Bolesti b = new Bolesti();
                    b.setId(rs.getInt(1));
                    b.setSifra(rs.getString(2));
                    b.setNaziv(rs.getString(3));
                    b.setOpis(rs.getString(4));
                    listaBbn.add(b);;
                }
            }  
        }
        catch(SQLException ex){ex.getMessage();}  
          
        return listaBbn;  
    }
} 