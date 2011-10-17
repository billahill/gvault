/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.util;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 *
 * @author Carlos
 */
public class EmailValidator {

    public boolean isValid(String email) {
        
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);
        
        boolean matchFound = m.matches();
        StringTokenizer st = new StringTokenizer(email, ".");
        String lastToken = null;
        
        while (st.hasMoreTokens()) {
            lastToken = st.nextToken();
        }

        if (matchFound && lastToken.length() >= 2 && email.length() - 1 != lastToken.length()) {
            return true;
        } else {
            return false;
        }
    }
}
