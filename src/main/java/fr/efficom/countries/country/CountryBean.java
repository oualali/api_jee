package fr.efficom.countries.country;
import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CountryBean {

	
    @Inject
    public CountryDao CountryDao;

    public List<CountryModel> getCountry() {
        return CountryDao.getCountryModel();
    }

    public boolean addCountry(CountryModel CountryModel) {
        return CountryDao.addCountryModel(CountryModel);
    }

    public void deleteMember(String name){
    	//todo terminer
    }
}
