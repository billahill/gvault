/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.model;

import java.util.Date;

/**
 *
 * @author Kraakbeen
 */
public class receiptBeans {
  private Long id;
  private double price;
  private Date dateEntry;

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
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the dateEntry
     */
    public Date getDateEntry() {
        return dateEntry;
    }

    /**
     * @param dateEntry the dateEntry to set
     */
    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }
    
 
}
