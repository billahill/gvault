/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.addusers;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.views.CreateNewUsersViewPage;
import zm.hashcode.vault.client.web.views.addusers.views.EnableUsersViewPage;
import zm.hashcode.vault.client.web.views.addusers.views.TransferMoneyToUsersViewPage;
import zm.hashcode.vault.client.web.views.addusers.views.ManageAccountUserViewPage;
import zm.hashcode.vault.client.web.views.addusers.views.ResetUsersAccountViewPage;

/**
 *
 * @author boniface
 */
public class UsersAdminMenuView extends VerticalLayout {

    private VaultMain main;
    private TabSheet tab;

    public UsersAdminMenuView(VaultMain app, String selectedTab) {
        main = app;

        VerticalLayout createNewUserTab = new VerticalLayout();
        createNewUserTab.setMargin(true);
        createNewUserTab.addComponent(new CreateNewUsersViewPage(main));

        VerticalLayout resetUserAccountTab = new VerticalLayout();
        resetUserAccountTab.setMargin(true);
        resetUserAccountTab.addComponent(new ResetUsersAccountViewPage(main));

        VerticalLayout manageUserTab = new VerticalLayout();
        manageUserTab.setMargin(true);
        manageUserTab.addComponent(new ManageAccountUserViewPage(main));

        VerticalLayout transferMoneyTab = new VerticalLayout();
        transferMoneyTab.setMargin(true);
        transferMoneyTab.addComponent(new TransferMoneyToUsersViewPage(main));

        VerticalLayout EnableUserstab = new VerticalLayout();
        EnableUserstab.setMargin(true);
        EnableUserstab.addComponent(new EnableUsersViewPage(main));

        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");


        tab.addTab(createNewUserTab, "Create New Users", null);
        tab.addTab(manageUserTab, "Manage User Account", null);
        tab.addTab(resetUserAccountTab, "Reset User Account", null);
        tab.addTab(transferMoneyTab, "Credit User", null);
        tab.addTab(EnableUserstab, "Enable User/Account", null);
        if (selectedTab.equals("CREDITUSER")) {
            tab.setSelectedTab(transferMoneyTab);
        } else if (selectedTab.equals("CREATEUSER")) {
            tab.setSelectedTab(createNewUserTab);
        } else if (selectedTab.equals("MANAGEACCOUNT")) {
            tab.setSelectedTab(manageUserTab);
        } else if (selectedTab.equals("RESETUSER")) {
            tab.setSelectedTab(resetUserAccountTab);
        } else if (selectedTab.equals("Enable User/Account")) {
            tab.setSelectedTab(EnableUserstab);
        }
        addComponent(tab);
    }
}
