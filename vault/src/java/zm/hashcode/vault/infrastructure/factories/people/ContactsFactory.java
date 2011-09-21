/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.people;

import zm.hashcode.vault.model.people.Contacts;

/**
 *
 * @author carlos
 */
public class ContactsFactory {

    public static class Builder {

        private String phoneNumber;
        private String cellNumber;
        private String emailAddress;
        private String faxNumber;
        private String contactStatus;

        public Builder(String emailAddress, String contactStatus) {
            this.emailAddress = emailAddress;
            this.contactStatus = contactStatus;
        }

        public Builder contactStatus(String contactStatus) {
            this.contactStatus = contactStatus;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder cellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder faxNumber(String faxNumber) {
            this.faxNumber = faxNumber;
            return this;
        }

        public Contacts build() {
            return getContacts(this);
        }

        private Contacts getContacts(Builder builder) {
            
            Contacts cont = new Contacts();
            cont.setCellNumber(builder.cellNumber);
            cont.setContactStatus(builder.contactStatus);
            cont.setEmailAddress(builder.emailAddress);
            cont.setPhoneNumber(builder.phoneNumber);
            cont.setFaxNumber(builder.faxNumber);
            
            return cont;
        }
    }
}
