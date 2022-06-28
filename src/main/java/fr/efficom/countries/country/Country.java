package fr.efficom.countries.country;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("country")
public class Country {
	@Inject
    private CountryBean CountryBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/country")
    public Response getCountries(){
        return Response.ok(CountryBean.getCountry()).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add/country")
    public Response addMember(CountryModel CountryModel){
        if (CountryModel.getName() == null || CountryModel.getPresident() == null){
            return Response.status(403).build();
        }
        CountryBean.addCountry(CountryModel);
        return Response.ok(CountryBean.getCountry().size()).build();
    	//return Response.ok("test").build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public Response deleteMember(@PathParam("name") String name){
        if (name == null || name.length() == 0){
            return Response.status(403).build();
        }
        CountryBean.deleteMember(name);
        return Response.ok(CountryBean.getCountry().size()).build();
     
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteMember(){
   
    }
}
