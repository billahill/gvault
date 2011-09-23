/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.addusers.views;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.UsersAdminMenuView;
import zm.hashcode.vault.client.web.views.addusers.form.CreateUsersForm;
import zm.hashcode.vault.client.web.views.addusers.model.UsersBean;
import zm.hashcode.vault.infrastructure.factories.account.AccountFactory;
import zm.hashcode.vault.infrastructure.factories.people.UsersFactory;
import zm.hashcode.vault.infrastructure.util.GenerateAccountNumbers;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author boniface
 */
public class CreateNewUsersViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final CreateUsersForm userForm;
    private static final ClientDataService data = new ClientDataService();
    // private final UsersTable table;

    public CreateNewUsersViewPage(VaultMain app) {
        main = app;
        setSizeFull();

        userForm = new CreateUsersForm();
        form = userForm.createUsersForm();

        // Add Listeners
        userForm.getSave().addListener((ClickListener) this);
        userForm.getCancel().addListener((ClickListener) this);

        GenerateAccountNumbers accNumbers = new GenerateAccountNumbers();
        String accountNumber = accNumbers.getAccountNumber().toString();
        final UsersBean bean = new UsersBean();
        bean.setAccountNumber(accountNumber);
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(userForm.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);
        //       table = new UsersTable(main);
        //table.addListener((ValueChangeListener) this);
//        addComponent(table);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == userForm.getSave()) {
//            if (!isValid()) {
//                getWindow().showNotification(
//                        "Please enter all the required fields", Notification.TYPE_TRAY_NOTIFICATION);
//                return;
//
//            }
            saveNewUser(form);
            main.getMainWindow().showNotification("USER CREATED", "", Notification.DELAY_FOREVER);
            main.mainView.setSecondComponent(new UsersAdminMenuView(main, "CREATEUSER"));
        } else if (source == userForm.getCancel()) {
            main.mainView.setSecondComponent(new UsersAdminMenuView(main, "CREATEUSER"));
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
    }

    public void saveNewUser(Form form) {
        final String userName = form.getField("username").getValue().toString();
        final String Password = form.getField("password").getValue().toString();
        final String firstName = form.getField("firstname").getValue().toString();
        final String lastName = form.getField("lastname").getValue().toString();
        final String roleName = form.getField("rolename").getValue().toString();
        final String userTitle = form.getField("title").getValue().toString();
        final String otherName = form.getField("otherName").getValue().toString();
        final String phoneNumber = form.getField("phoneNumber").getValue().toString();
        final String cellnumber = form.getField("cellNumber").getValue().toString();
        final String emailaddress = form.getField("emailAddress").getValue().toString();
        final String faxnumber = form.getField("faxNumber").getValue().toString();
        final String addressstatus = form.getField("addressStatus").getValue().toString();
        final String postaladdress = form.getField("postalAddress").getValue().toString();
        final String physicaladdress = form.getField("physicalAddress").getValue().toString();
        final String postalCode = form.getField("postalcode").getValue().toString();
        final String contactstatus = form.getField("contactStatus").getValue().toString();
        final String account = form.getField("accountNumber").getValue().toString();
        final String pin = form.getField("pinNumber").getValue().toString();
        final String type = form.getField("accountType").getValue().toString();
        final Users user = new UsersFactory.Builder(firstName, lastName).password(Password).
                enabled(true).username(userName).title(userTitle).rolename(roleName).otherName(otherName).
                phoneNumber(phoneNumber).cellNumber(cellnumber).emailAddress(emailaddress).
                faxNumber(faxnumber).addressStatus(addressstatus).postalAddress(postaladdress).
                physicalAddress(physicaladdress).postalcode(postalCode).contactStatus(contactstatus).build();
        final Account userAccount = new AccountFactory.Builder(account, pin).accountType(type).build();
        user.setAccount(userAccount);
        data.getUsersService().persist(user);
    }
}
