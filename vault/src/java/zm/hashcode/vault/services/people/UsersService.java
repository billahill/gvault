/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.people;

import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.services.Services;
/**
 *
 * @author carlos
 */
public interface UsersService extends Services<Users, Long>{
    public void updatePinNumber(String old, String newpin, String newpin2);
    public void resetPassword(Users user);
    public void updatePassword(String old, String newPassword, String newPassword2);
}
