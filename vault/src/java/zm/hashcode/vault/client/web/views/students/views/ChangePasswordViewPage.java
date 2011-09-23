/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.students.views;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.model.UsersBean;
import zm.hashcode.vault.client.web.views.students.StudentsMenuView;
import zm.hashcode.vault.client.web.views.students.forms.ChangePasswordForm;
import zm.hashcode.vault.client.web.views.students.model.ChangePasswordBean;
import zm.hashcode.vault.infrastructure.util.authentication.GetUserCredentials;
import zm.hashcode.vault.infrastructure.util.authentication.PasswordFactory;
import zm.hashcode.vault.model.people.Address;
import zm.hashcode.vault.model.people.Contacts;
import zm.hashcode.vault.model.people.Roles;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author Carlos
 */
public class ChangePasswordViewPage extends VerticalLayout implements
        ClickListener {

    private final VaultMain main;
    private final Form form;
    private final ChangePasswordForm changePasswordForm;
    private static final ClientDataService data = new ClientDataService();
    private UsersBean usersBean = new UsersBean();
    private Users user = new Users();
    private BeanItem<UsersBean> uBeanItem = new BeanItem<UsersBean>(usersBean);
    private final String username = new GetUserCredentials().username();

    public ChangePasswordViewPage(VaultMain app) {
        main = app;
        setSizeFull();
        changePasswordForm = new ChangePasswordForm();
        form = changePasswordForm.createFrom();
        
        user = (Users) data.getPurchaseService().getStudentInfo(username);
        // Add Listeners
        changePasswordForm.getSave().addListener((ClickListener) this);
        changePasswordForm.getCancel().addListener((ClickListener) this);

        final ChangePasswordBean bean = new ChangePasswordBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(changePasswordForm.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);

    }

    public final UsersBean setBean() {
        usersBean.setId(user.getId());
        usersBean.setUsername(user.getUsername());
        usersBean.setPassword(user.getPassword());
        usersBean.setFirstname(user.getName().getFirstname());
        usersBean.setLastname(user.getName().getLastname());
        usersBean.setOtherName(user.getName().getOtherName());
        usersBean.setTitle(user.getName().getTitle());
        usersBean.setEnabled(user.getEnabled());
        usersBean.setPassword(user.getPassword());
        if (user.getRoles() != null) {
            List<Roles> rolesList = user.getRoles();
            for (Roles roles : rolesList) {
                usersBean.setRolename(roles.getRolename());
            }
        }
        if (user.getAddress() != null) {
            List<Address> addressList = user.getAddress();
            for (Address add : addressList) {
                usersBean.setPhysicalAddress(add.getPhysicalAddress());
                usersBean.setPostalAddress(add.getPostalcode());
                usersBean.setPostalcode(add.getPostalcode());
                usersBean.setAddressStatus(add.getAddressStatus());
            }
        }
        if (user.getContacts() != null) {
            List<Contacts> contacts = user.getContacts();
            for (Contacts cont : contacts) {
                usersBean.setCellNumber(cont.getCellNumber());
                usersBean.setPhoneNumber(cont.getPhoneNumber());
                usersBean.setEmailAddress(cont.getEmailAddress());
                usersBean.setContactStatus(cont.getContactStatus());
                usersBean.setFaxNumber(cont.getFaxNumber());
            }
        }
        if (usersBean != form.getItemDataSource()) {
            form.setItemDataSource(uBeanItem);
            form.setVisibleItemProperties(changePasswordForm.orderList());

            //Buttons Behaviou
            changePasswordForm.getSave().setVisible(true);
            changePasswordForm.getCancel().setVisible(true);
        }
        return usersBean;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == changePasswordForm.getSave()) {
            saveNewPassword(form);
            main.mainView.setSecondComponent(new StudentsMenuView(main, "CHANGEPASSWORD"));
        } else if (source == changePasswordForm.getCancel()) {
            main.mainView.setSecondComponent(new StudentsMenuView(main, "CHANGEPASSWORD"));
        }
    }

    public void saveNewPassword(Form form) {
        final String oldPassword = form.getField("oldPassword").getValue().toString();
        final String newPassword = form.getField("newPassword").getValue().toString();
        final String newPassword2 = form.getField("newPassword2").getValue().toString();
        String encryptedOldPassword = PasswordFactory.EncryptPassword(oldPassword);
        String userEncryptedPasssword = user.getPassword().toString();
        if(userEncryptedPasssword.equals(encryptedOldPassword) && newPassword.equals(newPassword2)){
            String password = PasswordFactory.EncryptPassword(newPassword);
            user.setPassword(password);
            data.getUsersService().updatePassword(user);
        }else{
            main.getMainWindow().showNotification("Password Updated", "", Notification.DELAY_FOREVER);
        }
        
    }
}
