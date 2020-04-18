package com.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


public class HospitalRepository
{
 
     
     Connection con = null;
     
     public HospitalRepository() 
     {
    	 
    	 String url = "jdbc:mysql://localhost:3306/healthcareapiproject";
    	 String username = "root";
    	 String password ="";
    	 
    	 try
    	 {
    	    Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection(url,username,password);		 
    
    	 }catch(Exception e) {
    		 System.out.println(e);
    	 }

     }
     
     
     
     public List<Hospital>getHospitals(){
    	 
    	 List<Hospital> hospitals = new ArrayList<>();
    	 String sql = "select * from hospital";
    	 try 
    	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  while(rs.next())
			  {
				  Hospital h = new Hospital();
				  h.setHid(rs.getInt(1));
				  h.setName(rs.getNString(2));
				  h.setRegID(rs.getNString(3));
				  h.setAddress(rs.getNString(4));
				  h.setTelNo(rs.getNString(5));
				  
				  hospitals.add(h);
			  }
			
		    } 
    	 catch (Exception e) 
    	  {
			
		   System.out.println(e);
		  }
    	  
    	 return hospitals;
     }
     
     
     
     
     
     
     
     public Hospital getHospital(int hid)
     
     {
    	 String sql = "select * from hospital where hid="+hid;
    	  Hospital h = new Hospital();
    	 try 
    	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  if(rs.next())
			  {
				
				  h.setHid(rs.getInt(1));
				  h.setName(rs.getNString(2));
			      h.setRegID(rs.getNString(3));
				  h.setAddress(rs.getNString(4));
				  h.setTelNo(rs.getNString(5));		
			  }
			
		    } 
    	 catch (Exception e) 
    	  {
			
		   System.out.println(e);
		  } 
    	 return h;
     }

	public void create(Hospital h1) 
	{
		String sql = "insert into hospital values(?,?,?,?,?)";
   	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, h1.getHid());
		  st.setString(2, h1.getName());
		  st.setString(3, h1.getRegID());
		  st.setString(4, h1.getAddress());
		  st.setString(5, h1.getTelNo());
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	
	public void update(Hospital h1) 
	{
		String sql = "update hospital set name=?,regID=?,address=?,telNo=? where hid=?";
   	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		 
		  st.setString(1, h1.getName());
		  st.setString(2, h1.getRegID());
          st.setString(3, h1.getAddress());
		  st.setString(4, h1.getTelNo());
		  st.setInt(5, h1.getHid());
		
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}



	public void delete( int hid) {

		String sql = "delete from hospital where hid=?";
   	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, hid);
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
		
	}
	
	
}
