/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.model;

import java.util.List;

/**
 *
 * @author Carlos
 */
public class AccountBean {

    private Long id;
    private String accountNumber;
    private String AccountType;
    private String pinNumber;
    private List entries;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
        return AccountType;
    }

    /**
     * @param AccountType the AccountType to set
     */
    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
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
    public List getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(List entries) {
        this.entries = entries;
    }
}
