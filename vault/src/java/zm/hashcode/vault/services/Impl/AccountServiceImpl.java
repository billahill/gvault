/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.repository.jpa.account.AccountDAO;
import zm.hashcode.vault.services.account.AccountService;

/**
 *
 * @author carlos
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDAO accountDAO;


    @Override
    public Account find(Long id) {
        if(id!= null){
        return accountDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(Account entity) {
        accountDAO.persist(entity);
    }

    @Override
    public void merge(Account entity) {
        accountDAO.merge(entity);
    }

    @Override
    public void remove(Account entity) {

        accountDAO.remove(entity);
    }

    @Override
    public List<Account> findAll() {
         return  accountDAO.findAll();
    }

    @Override
    public List<Account> findInRange(int firstResult, int maxResults) {
         return accountDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  accountDAO.count();
    }

    @Override
    public Account getByPropertyName(String propertyName, String propertyValue) {
                return accountDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<Account> getEntitiesByProperName(String propertyName, String propertyValue) {
        return accountDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the accountDAO
     */
    public AccountDAO getStatusListDAO() {
        return accountDAO;
    }

    /**
     * @param accountDAO the accountDAO to set
     */
    public void setStatusListDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}

