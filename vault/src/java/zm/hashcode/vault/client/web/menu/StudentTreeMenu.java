/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.menu;


import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.students.StudentsMenuView;

/**
 *
 * @author boniface
 */
public class StudentTreeMenu extends Tree implements ItemClickListener {

    private VaultMain main;
    public static final Object SEARCH_FOR_PERSON = "People";
    public static final Object ACCOUNT_MANAGEMENT = "Account Management";
    public static final Object LIST_ALL_PEOPLE = "List All People";

    public StudentTreeMenu(VaultMain app) {
        this.main = app;

        //add Items to Menu
        addItem(ACCOUNT_MANAGEMENT);
//        addItem(SEARCH_FOR_PERSON);
//        addItem(LIST_ALL_PEOPLE);

        //Add Listeners
        addListener((ItemClickListener) this);

    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (ACCOUNT_MANAGEMENT.equals(itemId)) {
                managePeopleView();
            } else if (SEARCH_FOR_PERSON.equals(itemId)) {
               // managePositionsView();
            } else if (LIST_ALL_PEOPLE.equals(itemId)) {
               // organisationListView();
            }
        }

    }



    private void managePeopleView() {
        main.mainView.setSecondComponent( new StudentsMenuView(main, "SEARCH"));
    }

   
}
