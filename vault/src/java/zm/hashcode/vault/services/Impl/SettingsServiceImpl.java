/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.parameters.settings;
import zm.hashcode.vault.repository.jpa.parameters.SettingsDAO;
import zm.hashcode.vault.services.parameters.SettingsService;
/**
 *
 * @author Kraakbeen
 */
@Service("settingsService")
@Transactional
public class SettingsServiceImpl implements SettingsService{
   @Autowired
    private SettingsDAO settingsDAO;


    @Override
    public settings find(Long id) {
        if(id!= null){
        return settingsDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(settings entity) {
        settingsDAO.persist(entity);
    }

    @Override
    public void merge(settings entity) {
        settingsDAO.merge(entity);
    }

    @Override
    public void remove(settings entity) {

        settingsDAO.remove(entity);
    }

    @Override
    public List<settings> findAll() {
         return  settingsDAO.findAll();
    }

    @Override
    public List<settings> findInRange(int firstResult, int maxResults) {
         return settingsDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  settingsDAO.count();
    }

    @Override
    public settings getByPropertyName(String propertyName, String propertyValue) {
                return settingsDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<settings> getEntitiesByProperName(String propertyName, String propertyValue) {
        return settingsDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the accountDAO
     */
    public SettingsDAO getProductDAO() {
        return settingsDAO;
    }

    /**
     * @param accountDAO the accountDAO to set
     */
    public void setProductDAO(SettingsDAO settingsDAO) {
        this.settingsDAO = settingsDAO;
    }

  
}
