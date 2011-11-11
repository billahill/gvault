/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.people;

import zm.hashcode.vault.infrastructure.util.authentication.PasswordFactory;
import zm.hashcode.vault.model.people.Address;
import zm.hashcode.vault.model.people.Contacts;
import zm.hashcode.vault.model.people.Roles;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author boniface
 */
public class UsersFactory {

    public static class Builder {
        //Login Details 

        private String username;
        private String password;
        private boolean enabled;
        //Role name 
        private String rolename;
        //Names
        private String firstname;
        private String lastname;
        private String title;
        private String otherName;
        //Contacts 
        private String phoneNumber;
        private String cellNumber;
        private String emailAddress;
        private String faxNumber;
        private String addressStatus;
        //Address
        private String postalAddress;
        private String physicalAddress;
        private String postalcode;
        private String contactStatus;
        private String accountNumber;

        public Builder(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public Builder postalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder physicalAddress(String physicalAddress) {
            this.physicalAddress = physicalAddress;
            return this;
        }

        public Builder postalcode(String postalcode) {
            this.postalcode = postalcode;
            return this;
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

        public Builder addressStatus(String addressStatus) {
            this.addressStatus = addressStatus;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder rolename(String rolename) {
            this.rolename = rolename;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder otherName(String otherName) {
            this.otherName = otherName;
            return this;
        }

        public Users build() {
            return getUser(this);
        }

        private Users getUser(Builder builder) {
            Users user = new Users();
            user.getName().setFirstname(builder.firstname);
            user.getName().setLastname(builder.lastname);
            user.getName().setTitle(builder.title);
            user.getName().setOtherName(builder.otherName);

            user.setPassword(PasswordFactory.EncryptPassword(builder.password));
            user.setUsername(builder.username);
            user.setEnabled(builder.enabled);

            Address addr = new Address();
            addr.setAddressStatus(builder.addressStatus);
            addr.setPhysicalAddress(builder.physicalAddress);
            addr.setPostalcode(builder.postalcode);
            addr.setPostalAddress(builder.postalAddress);
            user.getAddress().add(addr);

            Contacts cont = new Contacts();
            cont.setCellNumber(builder.cellNumber);
            cont.setContactStatus(builder.contactStatus);
            cont.setEmailAddress(builder.emailAddress);
            cont.setPhoneNumber(builder.phoneNumber);
            cont.setFaxNumber(builder.faxNumber);
            user.getContacts().add(cont);

            Roles role = new Roles();
            role.setRolename(builder.rolename);
            role.setUsername(builder.username);

            user.getRoles().add(role);

            return user;
        }
    }
}
