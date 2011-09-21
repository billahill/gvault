/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.menu;


import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.merchants.MerchantMenuView;

/**
 *
 * @author boniface
 */
public class MerchantTreeMenu extends Tree implements ItemClickListener {

    private VaultMain main;
    public static final Object SEARCH_FOR_PERSON = "People";
    public static final Object ADD_NEW_PERSON = "Merchant";
    public static final Object LIST_ALL_PEOPLE = "List All People";

    public MerchantTreeMenu(VaultMain app) {
        this.main = app;

        //add Items to Menu
        addItem(ADD_NEW_PERSON);
//        addItem(SEARCH_FOR_PERSON);
//        addItem(LIST_ALL_PEOPLE);

        //Add Listeners
        addListener((ItemClickListener) this);

    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (ADD_NEW_PERSON.equals(itemId)) {
                managePeopleView();
            } else if (SEARCH_FOR_PERSON.equals(itemId)) {
               // managePositionsView();
            } else if (LIST_ALL_PEOPLE.equals(itemId)) {
               // organisationListView();
            }
        }

    }



    private void managePeopleView() {
        main.mainView.setSecondComponent( new MerchantMenuView(main, "SEARCH"));
    }

   
}
