/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.metadata;

import zm.hashcode.vault.model.metadata.Reciept;

/**
 *
 * @author David
 */
public class RecieptFactory {
    public static class Builder {

        private String rolename;

        public Builder(String rolename) {
            this.rolename = rolename;
        }

        public Builder rolename(String rolename) {
            this.rolename = rolename;
            return this;
        }

        public Reciept build() {
            return getReciept(this);
        }

        private Reciept getReciept(Builder builder) {
            Reciept Reciept = new Reciept();
            Reciept.setRolename(builder.rolename);
            return Reciept;
        }
    }
}
