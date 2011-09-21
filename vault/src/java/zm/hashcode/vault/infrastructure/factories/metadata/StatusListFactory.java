/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.metadata;

import zm.hashcode.vault.model.metadata.StatusList;

/**
 *
 * @author carlos
 */
public class StatusListFactory {
        public static class Builder {

        private String status;

        public Builder(String status) {
            this.status = status;
        }

        public Builder rolename(String status) {
            this.status = status;
            return this;
        }

        public StatusList build() {
            return getStatusList(this);
        }

        private StatusList getStatusList(Builder builder) {
            StatusList statusList = new StatusList();
            statusList.setStatus(builder.status);
            return statusList;
        }
    }
}
