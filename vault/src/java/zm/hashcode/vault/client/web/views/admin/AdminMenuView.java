/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.admin.views.AccountTypeViewPage;
import zm.hashcode.vault.client.web.views.admin.views.CurrenciesViewPage;
import zm.hashcode.vault.client.web.views.admin.views.RolesListViewPage;
import zm.hashcode.vault.client.web.views.admin.views.StatusViewPage;

/**
 *
 * @author boniface
 */
public class AdminMenuView extends VerticalLayout {

    private VaultMain main;
    private TabSheet tab;

    public AdminMenuView(VaultMain app, String selectedTab) {
        main = app;

        VerticalLayout statusListTab = new VerticalLayout();
        statusListTab.setMargin(true);
        statusListTab.addComponent(new StatusViewPage(main));

        VerticalLayout rolesListTab = new VerticalLayout();
        rolesListTab.setMargin(true);
        rolesListTab.addComponent(new RolesListViewPage(main));

        VerticalLayout currenciesTab = new VerticalLayout();
        currenciesTab.setMargin(true);
        currenciesTab.addComponent(new CurrenciesViewPage(main));

        VerticalLayout accountTypesTab = new VerticalLayout();
        accountTypesTab.setMargin(true);
        accountTypesTab.addComponent(new AccountTypeViewPage(main));



        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");


        tab.addTab(rolesListTab, "Add Roles Values", null);
        tab.addTab(currenciesTab, "Add Currencies", null);
        tab.addTab(statusListTab, "Add Status", null);
        tab.addTab(accountTypesTab, "Add Account Types", null);

        if (selectedTab.equals("ACCOUNT")) {
            tab.setSelectedTab(accountTypesTab);
        } else if (selectedTab.equals("STATUS")) {
            tab.setSelectedTab(statusListTab);
        } else if (selectedTab.equals("CURRENCIES")) {
            tab.setSelectedTab(currenciesTab);
        } else if (selectedTab.equals("ROLE")) {
            tab.setSelectedTab(rolesListTab);
        }
        addComponent(tab);
    }
}
