/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.util.authentication;

/**
 *
 * @author Boniface Kabaso
 */
public class PasswordFactory {

    public static String EncryptPassword(String password) {
        return PasswordEncrypt.encrypt(password);
    }
    public static String getNewStaticPassword() {
        String passwd = new PasswordGenerator().getStaticPassword();
        return EncryptPassword(passwd);
    }

    public static String getNewRandomPassword() {
        String passwd = new PasswordGenerator().getPassword();
        return EncryptPassword(passwd);
    }
}
