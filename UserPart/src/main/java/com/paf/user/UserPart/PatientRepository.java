package com.paf.user.UserPart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class PatientRepository {
	
	//DB Connection
 Connection con = null;
     
     public PatientRepository() 
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

   //retrive  patient details from database
	public List<Patient> getPatients() {
		
		List<Patient> patients = new ArrayList<>();
		String sql = "select * from user";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Patient p = new Patient();
				  p.setUid(rs.getInt(1));
				  p.setFname(rs.getNString(2));
				  p.setLname(rs.getNString(3));
				  p.setTelNo(rs.getInt(4));
				  p.setEmail(rs.getNString(5));
				  p.setAge(rs.getInt(6));
				  p.setGender(rs.getNString(7));
				  p.setNicNo(rs.getNString(8));
				  p.setPassword(rs.getNString(9));
				  p.setUsername(rs.getNString(10));
				  patients.add(p);

			}
		}
		 catch(Exception e){
			   System.out.println(e);
		 }
		return patients;
	}
	  //Retrieve unique patient details from database
	public Patient getPatient(int uid) 
	{
		String sql = "select * from user where uid="+uid;
		Patient p = new Patient();
		try 
		{
			Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(sql);
		    if(rs.next())
		    {
		    	  p.setUid(rs.getInt(1));
				  p.setFname(rs.getNString(2));
			      p.setLname(rs.getNString(3));
				  p.setTelNo(rs.getInt(4));
				  p.setEmail(rs.getNString(5));
				  p.setAge(rs.getInt(6));
				  p.setGender(rs.getNString(7));
				  p.setNicNo(rs.getNString(8));
				  p.setPassword(rs.getNString(9));
				  p.setUsername(rs.getNString(10));
		    }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		 return p;
	}

	//inserting patient details to database
	public void insertPatient(Patient p1) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, p1.getUid());
			  st.setString(2, p1.getFname());
			  st.setString(3, p1.getLname());
			  st.setInt(4, p1.getTelNo());
			  st.setString(5, p1.getEmail());
			  st.setInt(6,p1.getAge());
			  st.setString(7, p1.getGender());
			  st.setString(8, p1.getNicNo());
			  st.setString(9, p1.getPassword());
			  st.setString(10, p1.getUsername());
	          st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
	}
	
	
	
}