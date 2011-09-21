/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.metadata.StatusList;
import zm.hashcode.vault.repository.jpa.metadata.StatusListDAO;
import zm.hashcode.vault.services.metadata.StatusListService;

/**
 *
 * @author carlos
 */
@Service("statusListService")
@Transactional
public class StatusListServiceImpl implements StatusListService{
    @Autowired
    private StatusListDAO statusListDAO;


    @Override
    public StatusList find(Long id) {
        if(id!= null){
        return getStatusListDAO().find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(StatusList entity) {
        getStatusListDAO().persist(entity);
    }

    @Override
    public void merge(StatusList entity) {
        getStatusListDAO().merge(entity);
    }

    @Override
    public void remove(StatusList entity) {

        getStatusListDAO().remove(entity);
    }

    @Override
    public List<StatusList> findAll() {
         return  getStatusListDAO().findAll();
    }

    @Override
    public List<StatusList> findInRange(int firstResult, int maxResults) {
         return getStatusListDAO().findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  getStatusListDAO().count();
    }

    @Override
    public StatusList getByPropertyName(String propertyName, String propertyValue) {
                return getStatusListDAO().getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<StatusList> getEntitiesByProperName(String propertyName, String propertyValue) {
        return getStatusListDAO().getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the statusListDAO
     */
    public StatusListDAO getStatusListDAO() {
        return statusListDAO;
    }

    /**
     * @param statusListDAO the statusListDAO to set
     */
    public void setStatusListDAO(StatusListDAO statusListDAO) {
        this.statusListDAO = statusListDAO;
    }
}

