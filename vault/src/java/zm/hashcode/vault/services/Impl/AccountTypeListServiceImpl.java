/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.metadata.AccountTypeList;
import zm.hashcode.vault.repository.jpa.metadata.AccountTypeListDAO;
import zm.hashcode.vault.services.metadata.AccountTypeListService;

/**
 *
 * @author carlos
 */
@Service("accountTypeListService")
@Transactional
public class AccountTypeListServiceImpl implements AccountTypeListService{
    @Autowired
    private AccountTypeListDAO accountTypeDAO;


    @Override
    public AccountTypeList find(Long id) {
        if(id!= null){
        return accountTypeDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(AccountTypeList entity) {
        accountTypeDAO.persist(entity);
    }

    @Override
    public void merge(AccountTypeList entity) {
        accountTypeDAO.merge(entity);
    }

    @Override
    public void remove(AccountTypeList entity) {

        accountTypeDAO.remove(entity);
    }

    @Override
    public List<AccountTypeList> findAll() {
         return  accountTypeDAO.findAll();
    }

    @Override
    public List<AccountTypeList> findInRange(int firstResult, int maxResults) {
         return accountTypeDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  accountTypeDAO.count();
    }

    @Override
    public AccountTypeList getByPropertyName(String propertyName, String propertyValue) {
                return accountTypeDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<AccountTypeList> getEntitiesByProperName(String propertyName, String propertyValue) {
        return accountTypeDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the accountTypeDAO
     */
    public AccountTypeListDAO getStatusListDAO() {
        return accountTypeDAO;
    }

    /**
     * @param accountTypeDAO the accountTypeDAO to set
     */
    public void setStatusListDAO(AccountTypeListDAO accountTypeDAO) {
        this.accountTypeDAO = accountTypeDAO;
    }
}

