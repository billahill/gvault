/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.account;

import java.math.BigDecimal;
import java.util.Date;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.model.account.AccountLedger;

/**
 *
 * @author carlos
 */
public class AccountFactory {

    public static class Builder {

        private String accountNumber;
        private String accountType;
        private String pinNumber;
        //AccountLedger
        private BigDecimal debit;
        private Date dateEntry;
        private BigDecimal credit;
        private String description;
        private BigDecimal balance;

        public Builder(String accountNumber, String pinNumber) {
            this.accountNumber = accountNumber;
            this.pinNumber = pinNumber;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder pinNumber(String pinNumber) {
            this.pinNumber = pinNumber;
            return this;
        }

        public Builder debit(BigDecimal debit) {
            this.debit = debit;
            return this;
        }

        public Builder dateEntry(Date dateEntry) {
            this.dateEntry = dateEntry;
            return this;
        }

        public Builder credit(BigDecimal credit) {
            this.credit = credit;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Account build(){
        return getAccount(this);
        }

        private Account getAccount(Builder builder) {
            Account account = new Account();
            account.setAccountNumber(builder.accountNumber);
            account.setAccountType(builder.accountType);
            account.setPinNumber(builder.pinNumber);
            
            AccountLedger accountLedger = new AccountLedger();
            accountLedger.setBalance(builder.balance);
            accountLedger.setCredit(builder.credit);
            accountLedger.setDateEntry(builder.dateEntry);
            accountLedger.setDebit(builder.debit);
            accountLedger.setDescription(builder.description);
            account.getEntries().add(accountLedger);
            return account;
        }
    }
}
