package com.isuru.restAPI;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Doc")
public class DoctorResource 
{
	DoctorRepository repo = new DoctorRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getDocors()
	{
		System.out.println("Get Doctor Called....");
		
		return repo.getDoctors();
	}	
	

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor getDoctor(@PathParam("id") int id)
	{
		return repo.getDoctor(id);
	}
	
	
	
	@POST
	@Path("doctor")
	public Doctor createDoctor(Doctor a1)
	{
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	@PUT
	@Path("update")
	public Doctor updateDoctor(Doctor a1)
	{
		System.out.println(a1);
		repo.update(a1);
		
		return a1;
	}
	@DELETE
	@Path("{id}")
	public Doctor killDoctor(@PathParam("id") int id)
	{
		Doctor a = repo.getDoctor(id);
		if(a.getId()!=0)
			repo.delete(id);
		
		return a;
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("appoin/{id}")
	public List<Appoinment> viewAppoinments(@PathParam("id")int id)
	{
		return repo.viewAppoinment(id);
	}
	
}













