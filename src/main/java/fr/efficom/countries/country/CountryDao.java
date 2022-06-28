package fr.efficom.countries.country;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CountryDao {
	 @PersistenceContext
	    private EntityManager entityManager;

	    @Resource
	    UserTransaction userTransaction;

	    public List<CountryModel> getCountryModel(){
	        return entityManager.createQuery("select cm from CountryModel cm", CountryModel.class).getResultList();
	    }

	    public boolean addCountryModel(CountryModel CountryModel){
	        try{
	            userTransaction.begin();
	            entityManager.persist(CountryModel);
	            userTransaction.commit();
	            return true;
	        }catch (Exception e){
	            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
	            return false;
	        }
	    }
}
