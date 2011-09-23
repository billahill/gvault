/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Reindeer;
import java.util.Date;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.admin.views.StatusViewPage;
import zm.hashcode.vault.client.web.views.merchants.views.AccountDetailsWindow;
import zm.hashcode.vault.client.web.views.merchants.views.AccountLedgerViewPage;
import zm.hashcode.vault.client.web.views.merchants.views.ChangePasswordViewPage;
import zm.hashcode.vault.client.web.views.merchants.views.PersonalDetailsViewPage;

/**
 *
 * @author boniface
 */
public class MerchantMenuView extends VerticalLayout {

    private VaultMain main;
    private TabSheet tab;
    private VerticalLayout accountLedger, personalDetailsTab, changePasswordTab;

    public MerchantMenuView(VaultMain app, String selectedTab) {
        main = app;

        accountLedger = new VerticalLayout();
        accountLedger.setMargin(true);
        accountLedger.addComponent(new AccountLedgerViewPage(main));

        personalDetailsTab = new VerticalLayout();
        personalDetailsTab.setMargin(true);
        personalDetailsTab.addComponent(new PersonalDetailsViewPage(main));
        
        changePasswordTab = new VerticalLayout();
        changePasswordTab.setMargin(true);
        changePasswordTab.addComponent(new ChangePasswordViewPage(main));
        
        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");


        tab.addTab(personalDetailsTab, "Personal Details", null);
        tab.addTab(changePasswordTab, "Change Password", null);
        tab.addTab(accountLedger, "Point Of Sale", null);
        //accDetailsWindow.setModal(true);
        if (selectedTab.equals("PERSONALDETAILS")) {
            tab.setSelectedTab(personalDetailsTab);
        } else if (selectedTab.equals("ACCOUNTLEDGERVIEWPAGE")) {
            tab.setSelectedTab(accountLedger);
        }else if (selectedTab.equals("CHANGEPASSWORD")) {
            tab.setSelectedTab(changePasswordTab);
        }
        addComponent(tab);
    }

    private void promptUser() {
        // Create the window...
        final Window subwindow = new Window("Reason for ending careplan");
        // ...and make it modal
        subwindow.setWidth("389px");
        subwindow.setHeight("48%");
        subwindow.setResizable(false);
        subwindow.setModal(true);
        subwindow.setStyleName(Reindeer.LAYOUT_BLUE);

        // Configure the windws layout; by default a VerticalLayout
        VerticalLayout layout = (VerticalLayout) subwindow.getContent();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);
        // Create and Add contents of the window 
        PopupDateField endDate = new PopupDateField("End Date:");
        endDate.setRequired(true);
        endDate.setData(new Date());
        TextArea txtArea = new TextArea("Enter Reason:");
        txtArea.setColumns(27);
        txtArea.setRows(5);
        txtArea.setRequired(true);
        endDate.setDateFormat("EEE, d MMM yyyy");
        Button save = new Button("Save");
        Button cancel = new Button("Cancel", new Button.ClickListener() {
            // inline click-listener

            @Override
            public void buttonClick(ClickEvent event) {
                // close the window by removing it from the parent window
                (subwindow.getParent()).removeWindow(subwindow);
            }
        });
        // The components added to the window are actually added to the window's
        // layout; you can use either. Alignments are set using the layout
        layout.addComponent(endDate);
        layout.addComponent(txtArea);
        horizontalLayout.addComponent(save);
        horizontalLayout.addComponent(cancel);
        layout.addComponent(horizontalLayout);
        layout.setComponentAlignment(horizontalLayout, Alignment.TOP_RIGHT);

        if (subwindow.getParent() != null) {
            // window is already showing
            getWindow().showNotification(
                    "Window is already open");
        } else {
            // Open the subwindow by adding it to the parent
            // window
            main.getMainWindow().getWindow().addWindow(subwindow);
        }
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
