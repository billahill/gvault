/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.metadata.RolesList;
import zm.hashcode.vault.repository.jpa.metadata.RolesListDAO;
import zm.hashcode.vault.services.metadata.RolesListService;

/**
 *
 * @author carlos
 */
@Service("rolesListService")
@Transactional
public class RolesListServiceImpl implements RolesListService{
    @Autowired
    private RolesListDAO rolesListDAO;


    @Override
    public RolesList find(Long id) {
        if(id!= null){
        return rolesListDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(RolesList entity) {
        rolesListDAO.persist(entity);
    }

    @Override
    public void merge(RolesList entity) {
        rolesListDAO.merge(entity);
    }

    @Override
    public void remove(RolesList entity) {

        rolesListDAO.remove(entity);
    }

    @Override
    public List<RolesList> findAll() {
         return  rolesListDAO.findAll();
    }

    @Override
    public List<RolesList> findInRange(int firstResult, int maxResults) {
         return rolesListDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  rolesListDAO.count();
    }

    @Override
    public RolesList getByPropertyName(String propertyName, String propertyValue) {
                return rolesListDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<RolesList> getEntitiesByProperName(String propertyName, String propertyValue) {
        return rolesListDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the rolesListDAO
     */
    public RolesListDAO getStatusListDAO() {
        return rolesListDAO;
    }

    /**
     * @param rolesListDAO the rolesListDAO to set
     */
    public void setStatusListDAO(RolesListDAO rolesListDAO) {
        this.rolesListDAO = rolesListDAO;
    }
}

