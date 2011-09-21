/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.factories.metadata;

import zm.hashcode.vault.model.metadata.CurrencyList;

/**
 *
 * @author carlos
 */
public class CurrencyListFactory {

    public static class Builder {

        private String currecyName;
        private String currencySymbol;
        private String currencyCode;
        private String currencyShortCode;

        public Builder(String currencyName, String currencySymbol) {
            this.currecyName = currencyName;
            this.currencySymbol = currencySymbol;
        }

        public Builder currecyName(String currecyName) {
            this.currecyName = currecyName;
            return this;
        }

        public Builder currencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder currencyShortCode(String currencyShortCode) {
            this.currencyShortCode = currencyShortCode;
            return this;
        }

        public CurrencyList build() {
            return getCurrencyList(this);
        }

        private CurrencyList getCurrencyList(Builder builder) {
            CurrencyList currencyList = new CurrencyList();
            currencyList.setCurrencyName(builder.currecyName);
            currencyList.setCurrencyCode(builder.currencyCode);
            currencyList.setCurrencyShortCode(builder.currencyShortCode);
            currencyList.setCurrencySymbol(builder.currencySymbol);

            return currencyList;
        }
    }
}
