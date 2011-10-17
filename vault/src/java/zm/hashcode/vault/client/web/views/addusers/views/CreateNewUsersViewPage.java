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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.UsersAdminMenuView;
import zm.hashcode.vault.client.web.views.addusers.form.CreateUsersForm;
import zm.hashcode.vault.client.web.views.addusers.model.UsersBean;
import zm.hashcode.vault.infrastructure.factories.account.AccountFactory;
import zm.hashcode.vault.infrastructure.factories.people.UsersFactory;
import zm.hashcode.vault.infrastructure.util.EmailValidator;
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
            saveNewUser(form);

        } else if (source == userForm.getCancel()) {
            main.mainView.setSecondComponent(new UsersAdminMenuView(main, "CREATEUSER"));
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
    }

    public void saveNewUser(Form form) {
        EmailValidator validate = new EmailValidator();
        UsersBean usersBean = new UsersBean();
        try {
            final String userName = form.getField("username").getValue().toString();
            final String Password = form.getField("password").getValue().toString();
            if (Password.length() < 6) {
                getWindow().showNotification("Password too short", "Please insert a password with more than 6 leters", Notification.TYPE_ERROR_MESSAGE);
            }
            final String firstName = form.getField("firstname").getValue().toString();
            final String lastName = form.getField("lastname").getValue().toString();
            final String roleName = form.getField("rolename").getValue().toString();
            final String userTitle = form.getField("title").getValue().toString();
            final String cellnumber = form.getField("cellNumber").getValue().toString();
            final String emailaddress = form.getField("emailAddress").getValue().toString();
            final String addressstatus = form.getField("addressStatus").getValue().toString();
            final String postaladdress = form.getField("postalAddress").getValue().toString();
            final String physicaladdress = form.getField("physicalAddress").getValue().toString();
            final String postalCode = form.getField("postalcode").getValue().toString();
            final String contactstatus = form.getField("contactStatus").getValue().toString();
            final String account = form.getField("accountNumber").getValue().toString();
            final String pin = form.getField("pinNumber").getValue().toString();
            final String type = form.getField("accountType").getValue().toString();
            final String otherName;
            final String phoneNumber;
            final String faxnumber;

            if (form.getField("otherName").isModified()) {
                otherName = form.getField("otherName").getValue().toString();
            } else {
                otherName = "";
            }

            if (form.getField("phoneNumber").isModified()) {
                phoneNumber = form.getField("phoneNumber").getValue().toString();
            } else {
                phoneNumber = "";
            }

            if (form.getField("phoneNumber").isModified()) {
                faxnumber = form.getField("faxNumber").getValue().toString();
            } else {
                faxnumber = "";
            }

            usersBean.setFirstname(firstName);
            usersBean.setLastname(lastName);
            usersBean.setRolename(roleName);
            usersBean.setTitle(userTitle);
            usersBean.setOtherName(otherName);
            usersBean.setPhoneNumber(phoneNumber);
            usersBean.setCellNumber(cellnumber);
            if (!validate.isValid(emailaddress)) {
                getWindow().showNotification("Error", "Email address is not valid", Notification.TYPE_ERROR_MESSAGE);
            } else {
                usersBean.setEmailAddress(emailaddress);
            }
            usersBean.setFaxNumber(faxnumber);
            usersBean.setAddressStatus(addressstatus);
            usersBean.setPostalAddress(postaladdress);
            usersBean.setPhysicalAddress(physicaladdress);
            usersBean.setPostalcode(postalCode);
            usersBean.setContactStatus(contactstatus);
            usersBean.setAccountNumber(account);
            usersBean.setPinNumber(pin);
            usersBean.setAccountType(type);
            usersBean.setUsername(userName);

        } catch (NullPointerException NullPoint) {
            getWindow().showNotification("Data Missing", "You have left some of the feilds out please full them all in", Notification.TYPE_ERROR_MESSAGE);

        } catch (Exception e) {
            getWindow().showNotification("You have put letters in for your numbers, ping and/or you postal code", "Please correct ", Notification.TYPE_ERROR_MESSAGE);

        }

    }

    private void SaveUser(UsersBean usersBean) {
        final Users user = new UsersFactory.Builder(usersBean.getFirstname(), usersBean.getLastname()).password(usersBean.getPassword()).
                enabled(usersBean.isEnabled()).username(usersBean.getUsername()).title(usersBean.getTitle()).rolename(usersBean.getRolename()).otherName(usersBean.getRolename()).
                phoneNumber(usersBean.getPhoneNumber()).cellNumber(usersBean.getCellNumber()).emailAddress(usersBean.getEmailAddress()).
                faxNumber(usersBean.getFaxNumber()).addressStatus(usersBean.getAddressStatus()).postalAddress(usersBean.getPostalAddress()).
                physicalAddress(usersBean.getPhysicalAddress()).postalcode(usersBean.getPostalcode()).contactStatus(usersBean.getContactStatus()).build();
        final Account userAccount = new AccountFactory.Builder(usersBean.getAccountNumber(), usersBean.getPinNumber()).accountType(usersBean.getAccountType()).build();
        user.setAccount(userAccount);
        data.getUsersService().persist(user);
        main.getMainWindow().showNotification("USER CREATED", "", Notification.DELAY_FOREVER);
        main.mainView.setSecondComponent(new UsersAdminMenuView(main, "CREATEUSER"));
    }

    private boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            getWindow().showNotification("Your Email Adress is not valid", "Please put in a proper email address", Notification.TYPE_ERROR_MESSAGE);
            result = false;
        }
        return result;
    }
}
