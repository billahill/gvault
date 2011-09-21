/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.menu;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.UsersAdminMenuView;
import zm.hashcode.vault.client.web.views.admin.AdminMenuView;

/**
 *
 * @author boniface
 */
public class AdminTreeMenu extends Tree implements ItemClickListener {

    private VaultMain main;
    public static final Object MANAGE_USERS = "Manage USERS";
    public static final Object SETUP_SYSTEM = "Setup SYSTEM";

    public AdminTreeMenu(VaultMain app) {
        this.main = app;

        //add Items to Menu
        addItem(MANAGE_USERS);
        addItem(SETUP_SYSTEM);

        //Add Listeners
        addListener((ItemClickListener) this);

    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (MANAGE_USERS.equals(itemId)) {
                managePeopleView();
            } else if (SETUP_SYSTEM.equals(itemId)) {
                setupSystemtView();
            }
        }

    }

    private void managePeopleView() {
        main.mainView.setSecondComponent(new UsersAdminMenuView(main, "USERS"));
    }

    private void setupSystemtView() {
        main.mainView.setSecondComponent(new AdminMenuView(main, "SETUP"));
    }
}
