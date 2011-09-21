/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.util.authentication;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author boniface
 */
public class GetUserCredentials {

    public String username() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    public boolean isUserWithRole(String role) {
        
        
        GrantedAuthority authority = new GrantedAuthorityImpl(role);
   
        if (SecurityContextHolder.getContext().getAuthentication()!=null) {
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            if (authorities.contains(authority)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
