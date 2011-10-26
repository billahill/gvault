/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.metadata.RecieptDetail;
import zm.hashcode.vault.repository.jpa.metadata.RecieptDetailDAO;
import zm.hashcode.vault.services.metadata.RecieptDetailService;

/**
 *
 * @author David
 */
@Service("recieptDetailService")
@Transactional
public class RecieptDetailServiceImpl  implements RecieptDetailService{
    
    @Autowired
    private RecieptDetailDAO recieptDetailDAO;


    @Override
    public RecieptDetail find(Long id) {
        if(id!= null){
        return recieptDetailDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(RecieptDetail entity) {
        recieptDetailDAO.persist(entity);
    }

    @Override
    public void merge(RecieptDetail entity) {
        recieptDetailDAO.merge(entity);
    }

    @Override
    public void remove(RecieptDetail entity) {

        recieptDetailDAO.remove(entity);
    }

    @Override
    public List<RecieptDetail> findAll() {
         return  recieptDetailDAO.findAll();
    }

    @Override
    public List<RecieptDetail> findInRange(int firstResult, int maxResults) {
         return recieptDetailDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  recieptDetailDAO.count();
    }

    @Override
    public RecieptDetail getByPropertyName(String propertyName, String propertyValue) {
                return recieptDetailDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<RecieptDetail> getEntitiesByProperName(String propertyName, String propertyValue) {
        return recieptDetailDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the recieptDetailDAO
     */
     /**
     * @return the recieptDAO
     */
    public RecieptDetailDAO getStatusListDAO() {
        return recieptDetailDAO;
    }

    /**
     * @param recieptDAO the recieptDAO to set
     */
    public void setStatusListDAO(RecieptDetailDAO recieptDAO) {
        this.recieptDetailDAO = recieptDAO;
    }
}
