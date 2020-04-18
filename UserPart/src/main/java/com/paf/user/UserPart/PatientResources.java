package com.paf.user.UserPart;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/patients")
public class PatientResources {
	
	PatientRepository repo = new PatientRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient>getPatients()throws SQLException
	{
		System.out.println("Patient called..");	
		return repo.getPatients();
	}
	
	@GET
	@Path("patient/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("uid") int uid)
	{
		return repo.getPatient(uid);
	}
	@POST
	@Path("/patient")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient insertPatient(Patient p1) 
	{
		repo.insertPatient(p1);
		return p1;
	}
	
	@PUT
	@Path("/patient")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient updatePatient(Patient p1) 
	{
		System.out.println(p1);	
		repo.update(p1);
		return p1;

	}
	@DELETE
	@Path("patient/{uid}")
	public Patient deletePatient(@PathParam("uid") int uid)
	{
		
		Patient p = repo.getPatient(uid);
		
		if(p.getUid()!=0)
 	repo.delete(uid);
		return p;
		
	}

}