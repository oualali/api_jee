package fr.efficom.countries.country.authentification;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
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
    @Path("/me")
    public Response getMembers(){
        return Response.ok(User.getUser()).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    //creation de compte
    @Path("/register")
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
    @Path("/logout")
    public Response logout(UserModel UserModel, Request request){
    	/*HttpSession session =  request.getSession(false);
    	if(session!=null)
    	session.invalidate();*/
    	return Response.ok("trest").build();
    }
    

  
}
