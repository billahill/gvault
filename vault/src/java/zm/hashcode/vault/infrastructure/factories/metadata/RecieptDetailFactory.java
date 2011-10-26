/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.metadata;

import zm.hashcode.vault.model.metadata.RecieptDetail;



/**
 *
 * @author David
 */
public class RecieptDetailFactory {
    
    public static class Builder {
        private String descript;
        private double price;
        private int qty;
        private double total;
        private Long rid;
        
        public Builder(double price) {
            this.price = price;
                                
        }
        
        public Builder Price(double price) {
            this.price = price;
            return this;
        }
        public Builder Total(double total) {
            this.total = total;
            return this;
        }
        
        public Builder descript(String descript) {
            this.descript = descript;
            return this;
        }
        
        public Builder Qty(int qty) {
            this.qty = qty;
            return this;
        }
        
        public Builder Rid(Long rid) {
            this.rid = rid;
            return this;
        }
        public RecieptDetail build() {
            return getReciept(this);
        }

        private RecieptDetail getReciept(Builder builder) {
            RecieptDetail r = new RecieptDetail();
            r.setDescript(builder.descript);
            r.setPrice(builder.price);
            r.setQty(builder.qty);
            r.setRid(builder.rid);
            r.setTotal(builder.total);
            
            
            return r;
        }
    }
    
}
