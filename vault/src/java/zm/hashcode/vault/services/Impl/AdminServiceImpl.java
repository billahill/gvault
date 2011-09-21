/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.infrastructure.factories.account.AccountLedgerFactory;
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.services.account.AccountService;
import zm.hashcode.vault.services.people.UsersService;
import zm.hashcode.vault.services.purchase.AdminService;

/**
 *
 * @author carlos
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UsersService usersService;
    @Autowired
    private AccountService accountService;

    @Override
    public void loadCredit(BigDecimal amount, String username) {
        Users user = usersService.getByPropertyName("username", username);
        AccountLedger accLedger = new AccountLedgerFactory.Builder(new Date(), "CREDIT").credit(amount).build();
        user.getAccount().getEntries().add(accLedger);
        usersService.merge(user);
    }

    @Override
    public void createUser(Users user) {
        usersService.persist(user);
    }

    @Override
    public void disableUser(Users user) {
        Users users = new Users();
        users.setEnabled(user.getEnabled());
        usersService.merge(users);
    }

    @Override
    public void enableUser(Users user) {
        Users users = new Users();
        users.setEnabled(user.getEnabled());
        usersService.merge(users);
    }

    /**
     * @return the usersDAO
     */
    public UsersService getUsersDAO() {
        return usersService;
    }

    /**
     * @param usersDAO the usersDAO to set
     */
    public void setUsersDAO(UsersService usersDAO) {
        this.usersService = usersDAO;
    }

    /**
     * @return the accountService
     */
    public AccountService getAccountService() {
        return accountService;
    }

    /**
     * @param accountService the accountService to set
     */
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
