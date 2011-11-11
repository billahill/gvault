/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.template;


import com.vaadin.ui.Accordion;
import com.vaadin.ui.VerticalLayout;
import org.springframework.security.core.context.SecurityContextHolder;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.menu.AdminTreeMenu;
import zm.hashcode.vault.client.web.menu.MerchantTreeMenu;
import zm.hashcode.vault.client.web.menu.StudentTreeMenu;
import zm.hashcode.vault.infrastructure.util.authentication.GetUserCredentials;

/**
 *
 * @author boniface
 */
public class TabAccordian extends Accordion {

    private final VaultMain main;
    public static final String STUDENT_ACCOUNT = "Student ACCOUNT ";
    public static final String ADMIN = "system ADMINISTRATION";
    public static final String MERCHANT = "Merchant ACCOUNT";
  
    private final GetUserCredentials user;

    public TabAccordian(VaultMain app) {
        SecurityContextHolder.getContext().setAuthentication(app.getAuth());
        main = app;
        user = new GetUserCredentials();
        setSizeFull();

        //Configure Manage People Menu
        VerticalLayout studentLayout = new VerticalLayout();
        StudentTreeMenu studentTree = new StudentTreeMenu(app);
        studentLayout.addComponent(studentTree);

        

        // Manage Courses
        VerticalLayout merchantLayout = new VerticalLayout();
        MerchantTreeMenu mechantTree = new MerchantTreeMenu (app);
        merchantLayout.addComponent(mechantTree);
        

        // Niamrt Details 
        VerticalLayout adminLayout = new VerticalLayout();
        AdminTreeMenu adminTree = new AdminTreeMenu(app);
        adminLayout.addComponent(adminTree);
        
        //if (new GetUserCredentials().isUserWithRole("ADMIN")) {
            addTab(adminLayout, ADMIN, null);
        //}
        // if (new GetUserCredentials().isUserWithRole("MERCHANT")) {
            addTab(merchantLayout, MERCHANT, null);
       // }

          if (new GetUserCredentials().isUserWithRole("MERCHANT")) {
            addTab(merchantLayout, MERCHANT, null);
        }

          if (new GetUserCredentials().isUserWithRole("STUDENT")) {
            addTab(studentLayout, STUDENT_ACCOUNT, null);
        }


   
    }
}
