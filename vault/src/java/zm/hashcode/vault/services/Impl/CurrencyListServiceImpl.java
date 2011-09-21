/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.metadata.CurrencyList;
import zm.hashcode.vault.repository.jpa.metadata.CurrencyListDAO;
import zm.hashcode.vault.services.metadata.CurrencyListService;

/**
 *
 * @author carlos
 */
@Service("currencyListService")
@Transactional
public class CurrencyListServiceImpl implements CurrencyListService{
    @Autowired
    private CurrencyListDAO currencyListDAO;


    @Override
    public CurrencyList find(Long id) {
        if(id!= null){
        return currencyListDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(CurrencyList entity) {
        currencyListDAO.persist(entity);
    }

    @Override
    public void merge(CurrencyList entity) {
        currencyListDAO.merge(entity);
    }

    @Override
    public void remove(CurrencyList entity) {

        currencyListDAO.remove(entity);
    }

    @Override
    public List<CurrencyList> findAll() {
         return  currencyListDAO.findAll();
    }

    @Override
    public List<CurrencyList> findInRange(int firstResult, int maxResults) {
         return currencyListDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  currencyListDAO.count();
    }

    @Override
    public CurrencyList getByPropertyName(String propertyName, String propertyValue) {
                return currencyListDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<CurrencyList> getEntitiesByProperName(String propertyName, String propertyValue) {
        return currencyListDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the currencyListDAO
     */
    public CurrencyListDAO getStatusListDAO() {
        return currencyListDAO;
    }

    /**
     * @param currencyListDAO the currencyListDAO to set
     */
    public void setStatusListDAO(CurrencyListDAO currencyListDAO) {
        this.currencyListDAO = currencyListDAO;
    }
}
