/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.purchase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author carlos
 */
public interface PurchaseService{
    public void payMethod(List<AccountLedger>accountLedger, String username);
    public Users getStudentInfo(String email);
    public boolean verifyPin(String username, String pin);
    public String checkBalance(BigDecimal amount, String username);
    public BigDecimal getBalance(String accountNumber);
    public void receivePayment(List<AccountLedger>accountLedger, String username);
}
