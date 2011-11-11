/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.merchants.views.ProductsViewPage;
//import zm.hashcode.vault.client.web.views.merchants.views.ProductsViewPage;

/**
 *
 * @author Kraakbeen
 */
public class MerchantProductView extends VerticalLayout{
     private VaultMain main;
    private TabSheet tab;
    private VerticalLayout ProductsTab;

    public MerchantProductView(VaultMain app, String selectedTab) {
        main = app;

        ProductsTab = new VerticalLayout();
        ProductsTab.setMargin(true);
        ProductsTab.addComponent(new ProductsViewPage(main));

        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");
        
        tab.addTab(ProductsTab, "Products", null);
        
        if (selectedTab.equals("PRODUCTS")) {
            tab.setSelectedTab(ProductsTab);
        }

        addComponent(tab);
    }
    

    /**
     * @return the tab
     */
    public TabSheet getTab() {
        return tab;
    }

    /**
     * @param tab the tab to set
     */
    public void setTab(TabSheet tab) {
        this.tab = tab;
    }   
}
