package fr.efficom.countries.country.authentification;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<UserModel> getUser(){
        return entityManager.createQuery("select cm from UserModel cm", UserModel.class).getResultList();
    }

    public boolean addUser(UserModel UserModel){
        try{
            userTransaction.begin();
            entityManager.persist(UserModel);
            userTransaction.commit();
            return true;
        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }
    
    public boolean loginUser(UserModel UserModel){
        try{
            userTransaction.begin();
            entityManager.createQuery("select * from UserModel where  email="+ UserModel.getEmail(), UserModel.class).getResultList();
            userTransaction.commit();
            return true;
        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }
    
    
}