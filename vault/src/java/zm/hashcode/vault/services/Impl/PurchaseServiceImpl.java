/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.infrastructure.factories.account.AccountLedgerFactory;
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.services.account.AccountService;
import zm.hashcode.vault.services.people.UsersService;
import zm.hashcode.vault.services.purchase.PurchaseService;

/**
 *
 * @author carlos
 */
@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UsersService usersService;
    @Autowired
    private AccountService accountService;

    @Override
    public void payMethod(List<AccountLedger> accountLedger, String username) {
        Users user = new Users();
        user = (Users) usersService.getByPropertyName("username", username);
        for (AccountLedger accLegder : accountLedger) {
            user.getAccount().getEntries().add(accLegder);
        }
        usersService.merge(user);
    }

    @Override
    public void receivePayment(List<AccountLedger> accountLedger, String username) {
        Users user = new Users();
        user = (Users) usersService.getByPropertyName("username", username);
        for (AccountLedger accLegder : accountLedger) {
            AccountLedger acc = new AccountLedgerFactory.Builder(new Date(), accLegder.getDescription()).credit(accLegder.getDebit()).build();
            user.getAccount().getEntries().add(acc);
        }
        usersService.merge(user);
    }

    @Override
    public Users getStudentInfo(String email) {
        Users user = new Users();
        user = (Users) usersService.getByPropertyName("username", email);
        return user;
    }

    @Override
    public boolean verifyPin(String username, String pin) {
        Users user = new Users();
        String pinNumber;
        user = (Users) usersService.getByPropertyName("username", username);
        pinNumber = user.getAccount().getPinNumber();
        if (pinNumber.equals(pin)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String checkBalance(BigDecimal amount, String username) {
        Users user = new Users();
        user = (Users) usersService.getByPropertyName("username", username);
        if (user.getAccount().getBalance() == null) {
            return "Insufficient funds";
        } else if (user.getAccount().getBalance().compareTo(amount) == -1) {
            return "Insufficient funds";
        } else {
            return "You have enough funds";
        }
    }

    @Override
    public BigDecimal getBalance(String username) {
        BigDecimal balance = new BigDecimal(0.00);
        Users user = new Users();
        user = (Users) usersService.getByPropertyName("username", username);
        balance = user.getAccount().getBalance();
        balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);
        return balance;
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

    /**
     * @return the usersService
     */
    public UsersService getUsersService() {
        return usersService;
    }

    /**
     * @param usersService the usersService to set
     */
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
