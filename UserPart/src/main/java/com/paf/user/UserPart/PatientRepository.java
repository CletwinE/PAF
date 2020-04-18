package com.paf.user.UserPart;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
}