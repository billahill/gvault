/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin.model;

/**
 *
 * @author boniface
 */
public class CurrencyListBean {
    private Long id;
    private String currencyName;
    private String currencySymbol;
    private String currencyCode;
    private String currencyShortCode;

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
     * @return the currecyName
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * @param currecyName the currecyName to set
     */
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    /**
     * @return the currencySymbol
     */
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * @param currencySymbol the currencySymbol to set
     */
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    /**
     * @return the currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * @return the currencyShortCode
     */
    public String getCurrencyShortCode() {
        return currencyShortCode;
    }

    /**
     * @param currencyShortCode the currencyShortCode to set
     */
    public void setCurrencyShortCode(String currencyShortCode) {
        this.currencyShortCode = currencyShortCode;
    }
    
}
