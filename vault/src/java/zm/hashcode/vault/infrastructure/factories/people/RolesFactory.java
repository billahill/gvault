/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.people;

import zm.hashcode.vault.model.people.Roles;

/**
 *
 * @author carlos
 */
public class RolesFactory {

    public static class Builder {

        private String username;
        private String rolename;

        public Builder(String username, String rolename) {
            this.username = username;
            this.rolename = rolename;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder rolename(String rolename) {
            this.rolename = rolename;
            return this;
        }

        public Roles build() {
            return getRoles(this);
        }

        private Roles getRoles(Builder builder) {
            Roles roles = new Roles();
            roles.setRolename(builder.rolename);
            roles.setUsername(builder.username);
            return roles;
        }
    }
}
