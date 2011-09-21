/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.model.metadata;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author boniface
 */
@Entity
public class CurrencyList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currencyName;
    private String currencySymbol;
    private String currencyCode;
    private String currencyShortCode;

    public Long getId() {
        return id;
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
        if (!(object instanceof CurrencyList)) {
            return false;
        }
        CurrencyList other = (CurrencyList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.vault.model.metadata.CurrencyList[ id=" + id + " ]";
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
    public void setCurrencyName(String currecyName) {
        this.currencyName = currecyName;
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
