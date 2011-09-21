/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.metadata;

import zm.hashcode.vault.model.metadata.RolesList;

/**
 *
 * @author carlos
 */
public class RolesListFactory {

    public static class Builder {

        private String rolename;

        public Builder(String rolename) {
            this.rolename = rolename;
        }

        public Builder rolename(String rolename) {
            this.rolename = rolename;
            return this;
        }

        public RolesList build() {
            return getRolesList(this);
        }

        private RolesList getRolesList(Builder builder) {
            RolesList rolesList = new RolesList();
            rolesList.setRolename(builder.rolename);
            return rolesList;
        }
    }
}
