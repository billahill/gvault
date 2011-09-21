/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.purchase;

import java.math.BigDecimal;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author carlos
 */
public interface AdminService {
    public void loadCredit(BigDecimal amount, String accountNumber);
    public void createUser(Users user);
    public void disableUser(Users user);
    public void enableUser(Users user);
    
}
