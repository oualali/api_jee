package fr.efficom.countries.country.authentification;



import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class User {

    @Inject
    private UserDao UserDao;

    public List<UserModel> getUser() {
        return UserDao.getUser();
    }

    public boolean addUser(UserModel UserModel) {
        
    	return UserDao.addUser(UserModel);
        
    }

 
}