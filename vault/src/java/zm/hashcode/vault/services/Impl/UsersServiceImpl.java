/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.infrastructure.util.authentication.PasswordFactory;
import zm.hashcode.vault.infrastructure.util.authentication.PasswordGenerator;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.repository.jpa.people.UsersDAO;
import zm.hashcode.vault.services.account.AccountService;
import zm.hashcode.vault.services.people.UsersService;

/**
 *
 * @author carlos
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersDAO usersDAO;
    private AccountService accountService;

    @Override
    public Users find(Long id) {
        if(id!= null){
        return usersDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(Users entity) {
        usersDAO.persist(entity);
    }

    @Override
    public void merge(Users entity) {
        usersDAO.merge(entity);
    }

    @Override
    public void remove(Users entity) {

        usersDAO.remove(entity);
    }

    @Override
    public List<Users> findAll() {
         return  usersDAO.findAll();
    }

    @Override
    public List<Users> findInRange(int firstResult, int maxResults) {
         return usersDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  usersDAO.count();
    }

    @Override
    public Users getByPropertyName(String propertyName, String propertyValue) {
                return usersDAO.getByPropertyName(propertyName, propertyValue);
    }

    /**
     * @return the UsersDAO
     */
    public UsersDAO getUsersDAO() {
        return usersDAO;
    }

    /**
     * @param UsersDAO the UsersDAO to set
     */
    public void setUsersDAO(UsersDAO UsersDAO) {
        this.usersDAO = UsersDAO;
    }

    @Override
    public List<Users> getEntitiesByProperName(String propertyName, String propertyValue) {
        return usersDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    @Override
    public void updatePinNumber(String old, String newpin, String newpin2) {
        Account account = new Account();
        account.setPinNumber(newpin2);
        accountService.merge(account);
        
    }

    @Override
    public void updatePassword(String old, String newPassword, String newPassword2) {
        Users user = new Users();
        user.setPassword(newPassword2);
        usersDAO.merge(user);
    }

    /**
     * @return the acountDAO
     */
    public AccountService getAcountDAO() {
        return accountService;
    }

    /**
     * @param accountService the acountDAO to set
     */
    public void setAcountDAO(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void resetPassword(Users user) {
        PasswordGenerator pswGenerator = new PasswordGenerator();
        String password = pswGenerator.getStaticPassword();
        user.setPassword(PasswordFactory.EncryptPassword(password));
        usersDAO.merge(user);
        
    }
}
