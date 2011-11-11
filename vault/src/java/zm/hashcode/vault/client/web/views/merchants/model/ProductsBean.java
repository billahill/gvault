/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.model;

/**
 *
 * @author Kraakbeen
 */
public class ProductsBean {
    private Long id;
    private double PriceInl;
    private double Price;
    private boolean vat;
    private String description;
    private String barcode;
    private int qty;

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
     * @return the PriceInl
     */
    public double getPriceInl() {
        return PriceInl;
    }

    /**
     * @param PriceInl the PriceInl to set
     */
    public void setPriceInl(double PriceInl) {
        this.PriceInl = PriceInl;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }

    /**
     * @return the vat
     */
    public boolean isVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(boolean vat) {
        this.vat = vat;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
}
