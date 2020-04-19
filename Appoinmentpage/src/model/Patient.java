package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Patient {
	//A common method to connect to the DB
	private Connection connect()
	{
	Connection con = null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	//Provide the correct details: DBServer/DBName, username, password
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project", "root", "");
	}
	catch (Exception e)
	{e.printStackTrace();}
	return con;
	}
	
	
	
	public String insertpatientapp( String pname, String specialist,String hospital,String doctor) //,Date  Adate,Time time

	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for inserting."; }
	// create a prepared statement
	String query = " insert into appointment(AppointmentID,`patientname`,`Specialist`,`Hospital`,`Doctor`)"             //`Adate`,` time`
	+ " values (?, ?, ?, ?, ?)";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setInt(1, 0);
	preparedStmt.setString(2, pname);
	
	//preparedStmt.setDate(3, Adate);
	//preparedStmt.setTime(4, time);
	preparedStmt.setString(3, specialist);
	preparedStmt.setString(4, hospital);
	preparedStmt.setString(5, doctor);
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Inserted successfully";
	}
	catch (Exception e)
	{
	output = "Error while inserting the item.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	public String readPatients()
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for reading."; }
	// Prepare the html table to be displayed
	output = "<table border=\"1\">"
			+ "<tr>"
			+ "<th>patientname</th>"
			+ "<th>Specialist Name</th>"
			+ "<th>Hospital Name</th>"
			+ "<th>Doctor Name</th>"
			+"<th>Update</th>"
			+"<th>Remove</th>"
			+ "</tr>";
			
			
			
	String query = "select * from appointment";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
	while (rs.next())
	{
	String AppointmentID = Integer.toString(rs.getInt("AppointmentID"));
	String patientname = rs.getString("pname");
	String Specialist = rs.getString("specialist");
	String Hospital = Double.toString(rs.getDouble("hospital"));
	String Doctor = rs.getString("doctor");
	// Add into the html table
	
	
	
	output += "<td>" + patientname + "</td>";
	output += "<td>" +  Specialist + "</td>";
	output += "<td>" + Hospital + "</td>";
	output += "<td>" + Doctor + "</td>";
	// buttons
	output +="<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
	+ "<td><form method=\"post\" action=\"appointment.jsp\">"
	+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
	+ "<input name=\"AppointmentID\" type=\"hidden\" value=\"" + AppointmentID 
	+"\">" + "</form></td></tr>";
	}
	con.close();
	// Complete the html table
	output += "</table>";
	}
	catch (Exception e)
	{
	output = "Error while reading the Patients.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
	
	
	
	
	public String updateappointment(String AppointmentID, String pname, String specialist, String hospital, String doctor)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for updating."; }
	// create a prepared statement
	String query = "UPDATE appointment SET patientname=? Specialist=?,Hospital=?,String Doctor=? WHERE itemID=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setString(1, pname);
	preparedStmt.setString(2, specialist);
	preparedStmt.setString(3, hospital);
	preparedStmt.setString(4, doctor);
	preparedStmt.setInt(5, Integer.parseInt(AppointmentID));
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Updated successfully";
	}
	catch (Exception e)
	{
	output = "Error while updating the item.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	public String deleteAppointment(String AppointmentID)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for deleting."; }
	// create a prepared statement
	String query = "delete from appointment where AppointmentID=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setInt(1, Integer.parseInt(AppointmentID));
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Deleted successfully";
	}
	catch (Exception e)
	{
	output = "Error while deleting the item.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	
	}


