/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.metadata;

import java.util.Date;
import zm.hashcode.vault.model.metadata.Reciept;

/**
 *
 * @author David
 */
public class RecieptFactory {
    public static class Builder {

        private double price;
        private Date date;

        public Builder(double price) {
            this.price = price;
        }

        public Builder Price(double price) {
            this.price = price;
            return this;
        }
        public Builder Date(Date date) {
            this.date = date;
            return this;
        }

        public Reciept build() {
            return getReciept(this);
        }

        private Reciept getReciept(Builder builder) {
            Reciept R = new Reciept();
            R.setPrice(builder.price);
            R.setDateEntry(builder.date);
            return R;
        }
    }
}
