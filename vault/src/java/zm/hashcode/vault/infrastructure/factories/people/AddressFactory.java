/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.people;

import zm.hashcode.vault.model.people.Address;

/**
 *
 * @author carlos
 */
public class AddressFactory {

    public static class Builder {

        private String postalAddress;
        private String physicalAddress;
        private String postalcode;
        private String addressStatus;
        
        public Builder(String addressStatus, String postalcode) {
            this.addressStatus = addressStatus;
            this.postalcode = postalcode;
        }

        public Builder physicalAddress(String physicalAddress) {
            this.physicalAddress = physicalAddress;
            return this;
        }

        public Builder postalcode(String postalcode) {
            this.postalcode = postalcode;
            return this;
        }

        public Builder postalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        public Builder addressStatus(String addressStatus) {
            this.addressStatus = addressStatus;
            return this;
        }

        public Address build() {
            return getAddress(this);
        }

        private Address getAddress(Builder builder) {
            Address addr = new Address();
            addr.setAddressStatus(builder.addressStatus);
            addr.setPhysicalAddress(builder.physicalAddress);
            addr.setPostalcode(builder.postalcode);
            addr.setPostalAddress(builder.postalAddress);
            return addr;
        }
    }
}
