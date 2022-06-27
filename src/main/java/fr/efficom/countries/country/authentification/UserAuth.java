package fr.efficom.countries.country.authentification;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;


@Path("auth")
public class UserAuth {

    @Inject
    private User User;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //login
    public Response getMembers(){
        return Response.ok(User.getUser()).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    //creation de compte
    public Response addMember(UserModel UserModel){
        if (UserModel.getEmail() == null || UserModel.getPassword() == null){
            return Response.status(403).build();
        }
        User.addUser(UserModel);
        return Response.ok(User.getUser().size()).build();
    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    //creation de compte
    public Response logout(UserModel UserModel, Request request){
    	
    	if(((Object) request).getParameter("logout") != null ){  
            session.invalidate();
         
            
    }
    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public Response deleteUser(@PathParam("name") String name){
        if (name == null || name.length() == 0){
            return Response.status(403).build();
        }
        User.deleteMember(name);
        return Response.ok(User.getUser().size()).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteMember(UserModel UserModel){
      /*   if (crewMember.getJob() == null || crewMember.getName() == null){
            return Response.status(403).build();
        }
        crewBean.editMember(crewMember);
        return Response.ok(crewBean.getCrewMembers().size()).build();*/
    }
}
