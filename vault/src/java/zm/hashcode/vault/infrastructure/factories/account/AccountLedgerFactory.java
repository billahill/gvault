/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.account;

import java.math.BigDecimal;
import java.util.Date;
import zm.hashcode.vault.model.account.AccountLedger;

/**
 *
 * @author carlos
 */
public class AccountLedgerFactory {

    public static class Builder {

        private BigDecimal debit;
        private Date dateEntry;
        private BigDecimal credit;
        private String description;
        private BigDecimal balance;

        public Builder(Date dateEntry, String description) {
            this.dateEntry = dateEntry;
            this.description = description;
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

        public AccountLedger build() {
            return getAccountLedger(this);
        }

        private AccountLedger getAccountLedger(Builder builder) {
            AccountLedger accountLedger = new AccountLedger();
            accountLedger.setBalance(builder.balance);
            accountLedger.setCredit(builder.credit);
            accountLedger.setDateEntry(builder.dateEntry);
            accountLedger.setDebit(builder.debit);
            accountLedger.setDescription(builder.description);
            
            return accountLedger;
        }
    }
}
