package com;



import model.Patient;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;



@Path("/project")
public class AppointmentServices {
	Patient patientObj = new Patient();
	
	
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatients()
	{
	return patientObj.readPatients();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertpatientapp(
	@FormParam("patientname") String patientname,
	@FormParam("Specialist") String Specialist,
	@FormParam("Hospital") String Hospital,
	@FormParam("Doctor") String Doctor)
	{
	String output = patientObj.insertpatientapp(patientname,Specialist,Hospital,Doctor);
	return output;
	}
	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateappointment(String itemData)
	{
	//Convert the input string to a JSON object
	JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
	//Read the values from the JSON object
	String AppointmentID = itemObject.get("AppointmentID").getAsString();
	String patientname = itemObject.get("patientname").getAsString();
	String Specialist = itemObject.get("Specialist").getAsString();
	String Hospital = itemObject.get("i,Hospital").getAsString();
	String Doctor = itemObject.get("Doctor").getAsString();
	String output = patientObj.updateappointment(AppointmentID, patientname,Specialist,Hospital,Doctor);
	return output;
	}
	

}
