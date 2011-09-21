/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.model.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author boniface
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String accountNumber;
    private String accountType;
    private String pinNumber;
    @OneToMany(orphanRemoval = true, cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "account_id")
    private List<AccountLedger> entries = new ArrayList<AccountLedger>();

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        BigDecimal debit = new BigDecimal(0.00);
        BigDecimal credit = new BigDecimal(0.00);
        BigDecimal balance = new BigDecimal(0.00);
        List<AccountLedger> ent = getEntries();
        for (AccountLedger entry : ent) {
            if (entry.getDebit() != null) {
                debit = debit.add(entry.getDebit());
            }
            if (entry.getCredit() != null) {
                credit = credit.add(entry.getCredit());
            }
        }
        balance = credit.subtract(debit);
        balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);

        return balance;

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.vault.model.account.Account[ id=" + id + " ]";
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the AccountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param AccountType the AccountType to set
     */
    public void setAccountType(String AccountType) {
        this.accountType = AccountType;
    }

    /**
     * @return the pinNumber
     */
    public String getPinNumber() {
        return pinNumber;
    }

    /**
     * @param pinNumber the pinNumber to set
     */
    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    /**
     * @return the entries
     */
    public List<AccountLedger> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(List<AccountLedger> entries) {
        this.entries = entries;
    }
}
