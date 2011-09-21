/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.metadata;

import zm.hashcode.vault.model.metadata.AccountTypeList;

/**
 *
 * @author carlos
 */
public class AccountTypeListFactory {
    public static class Builder{
        private String accountType;
        
        public Builder(String accountType){
            this.accountType = accountType;
        }
        public Builder accountType(String accountType){
            this.accountType = accountType;
            return this;
        }
        public AccountTypeList build(){
            return getAccountTypeList(this);
        }

        private AccountTypeList getAccountTypeList(Builder builder) {
            AccountTypeList acc = new AccountTypeList();
            acc.setAccountType(builder.accountType);
            return acc;
        }
    }
}
