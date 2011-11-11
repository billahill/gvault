/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.model;

/**
 *
 * @author Kraakbeen
 */

public class receiptDetailBeans {
 private Long id;
    private String descript;
    private double price;
    private int qty;
    private double total;
    private Long Rid;

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
     * @return the descript
     */
    public String getDescript() {
        return descript;
    }

    /**
     * @param descript the descript to set
     */
    public void setDescript(String descript) {
        this.descript = descript;
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
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the Rid
     */
    public Long getRid() {
        return Rid;
    }

    /**
     * @param Rid the Rid to set
     */
    public void setRid(Long Rid) {
        this.Rid = Rid;
    }
}
