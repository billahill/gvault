/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.product;

import zm.hashcode.vault.model.product.product;
/**
 *
 * @author Kraakbeen
 */
public class productFactory {
   public static class Builder {

    private String description;
    private double price;
    private boolean vat;
    private double priceIncl;
    private String barcode;
    private int qty;
        
        public Builder(String description, String barcode) {
            this.description = description;
            this.barcode = barcode;
        }

        public Builder barcode(String barcode)
        {
            this.barcode = barcode;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder priceIncl(double priceIncl) {
            this.priceIncl = priceIncl;
            return this;
        }

        public Builder vat(boolean vat) {
            this.vat = vat;
            return this;
        }

        public Builder qty(int qty)
        {
            this.qty = qty;
            return this;
        }
                
        public product build() {
            return getProduct(this);
        }

        private product getProduct(Builder builder) {
            
            product Product = new product();
            Product.setDescription(builder.description);
            Product.setPrice(builder.price);
            Product.setPriceIncl(builder.priceIncl);
            Product.setVat(builder.vat);
            Product.setBarcode(builder.barcode);
            Product.setQty(builder.qty);
            
            return Product;
        }
    }  
}
