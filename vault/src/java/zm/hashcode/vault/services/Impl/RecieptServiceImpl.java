/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.metadata.Reciept;
import zm.hashcode.vault.repository.jpa.metadata.RecieptDAO;
import zm.hashcode.vault.services.metadata.RecieptService;

/**
 *
 * @author David
 */
@Service("recieptService")
@Transactional
public class RecieptServiceImpl  implements RecieptService{
    
    @Autowired
    private RecieptDAO recieptDAO;


    @Override
    public Reciept find(Long id) {
        if(id!= null){
        return recieptDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(Reciept entity) {
        recieptDAO.persist(entity);
    }

    @Override
    public void merge(Reciept entity) {
        recieptDAO.merge(entity);
    }

    @Override
    public void remove(Reciept entity) {

        recieptDAO.remove(entity);
    }

    @Override
    public List<Reciept> findAll() {
         return  recieptDAO.findAll();
    }

    @Override
    public List<Reciept> findInRange(int firstResult, int maxResults) {
         return recieptDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  recieptDAO.count();
    }

    @Override
    public Reciept getByPropertyName(String propertyName, String propertyValue) {
                return recieptDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<Reciept> getEntitiesByProperName(String propertyName, String propertyValue) {
        return recieptDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the recieptDAO
     */
    public RecieptDAO getStatusListDAO() {
        return recieptDAO;
    }

    /**
     * @param recieptDAO the recieptDAO to set
     */
    public void setStatusListDAO(RecieptDAO recieptDAO) {
        this.recieptDAO = recieptDAO;
    }
}
