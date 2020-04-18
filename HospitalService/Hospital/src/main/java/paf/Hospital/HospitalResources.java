package paf.Hospital;




import java.util.Arrays;
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


@Path("/hospitals")
public class HospitalResources
{
	
	HospitalRepository repo = new HospitalRepository(); 
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> getHospitals()
	{
		System.out.println("getHospital called..");	
		return repo.getHospitals();	
	}

	
	@GET
	@Path("hospital/{hid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospital getHospital(@PathParam("hid") int hid)
	{
		return repo.getHospital(hid);
	}
	
	
	@POST
	@Path("/hospital")
	@Consumes(MediaType.APPLICATION_JSON)
	public Hospital createHospital(Hospital h1)
	{
		System.out.println(h1);
		repo.create(h1);
		
		return h1;
	}
	
	
	@PUT
	@Path("/hospital")
	@Consumes(MediaType.APPLICATION_JSON)
	public Hospital updateHospital(Hospital h1)
	{
		System.out.println(h1);		
		if(repo.getHospital(h1.getHid()).getHid()==0)
		{
			repo.create(h1);
		}
		else
		{
			repo.update(h1);
		}
		return h1;
	}
	
	
	@DELETE
	@Path("hospital/{hid}")
	public Hospital deleteHospital(@PathParam("hid") int hid)
	{
		
		Hospital h = repo.getHospital(hid);
		
		if(h.getHid()!=0)
 	repo.delete(hid);
		return h;
		
	}
}
