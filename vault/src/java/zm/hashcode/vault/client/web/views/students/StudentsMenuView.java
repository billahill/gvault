/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.students;



import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.students.views.ChangePasswordViewPage;
import zm.hashcode.vault.client.web.views.students.views.PersonalDetailsViewPage;

/**
 *
 * @author boniface
 */
public class StudentsMenuView extends VerticalLayout {

    private VaultMain main;
    private TabSheet tab;

    public StudentsMenuView(VaultMain app, String selectedTab) {
        main = app;

        VerticalLayout personalDetailsTab = new VerticalLayout();
        personalDetailsTab.setMargin(true);
        personalDetailsTab.addComponent(new PersonalDetailsViewPage(main));
        
         VerticalLayout changePasswordTab = new VerticalLayout();
        changePasswordTab.setMargin(true);
        changePasswordTab.addComponent(new ChangePasswordViewPage(main));
       

        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        
        tab.addTab(personalDetailsTab, "Personal Details", null);
        tab.addTab(changePasswordTab, "Change Passwod", null);
      
        
        
        if (selectedTab.equals("PERSONALDETAILS")) {
            tab.setSelectedTab(personalDetailsTab);
        }else  if (selectedTab.equals("CHANGEPASSWORD")) {
            tab.setSelectedTab(changePasswordTab);
        }
        addComponent(tab);
    }
}
