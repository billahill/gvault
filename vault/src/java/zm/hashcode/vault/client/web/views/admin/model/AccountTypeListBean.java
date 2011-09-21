/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin.model;

/**
 *
 * @author boniface
 */
public class AccountTypeListBean {
    private Long id;
    private String accountTypeName;

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
     * @return the accountTypeName
     */
    public String getAccountTypeName() {
        return accountTypeName;
    }

    /**
     * @param accountTypeName the accountTypeName to set
     */
    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
    
}
