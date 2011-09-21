/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.addusers.views;

import com.vaadin.data.Property;
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
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.UsersAdminMenuView;
import zm.hashcode.vault.client.web.views.addusers.form.ResetUsersAccountForm;
import zm.hashcode.vault.client.web.views.addusers.model.UsersBean;
import zm.hashcode.vault.client.web.views.addusers.table.UsersTable;
import zm.hashcode.vault.model.people.Address;
import zm.hashcode.vault.model.people.Contacts;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author carlos
 */
public class ResetUsersAccountViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {
      private final VaultMain main;
   private final Form form;
    private final ResetUsersAccountForm resetUsersAccountFrom;
    private Long selectedItemId;
    private UsersBean usersBean = new UsersBean();
    private Users user = new Users();
    private BeanItem<UsersBean> uBeanItem = new BeanItem<UsersBean>(usersBean);
    private static final ClientDataService data = new ClientDataService();
    private final UsersTable table;
    public ResetUsersAccountViewPage(VaultMain app) {
        main=app;
         setSizeFull();
        resetUsersAccountFrom = new ResetUsersAccountForm();
        form = resetUsersAccountFrom.createResetUsersForm();

        // Add Listeners
        resetUsersAccountFrom.getReset().addListener((ClickListener) this);
        resetUsersAccountFrom.getCancel().addListener((ClickListener) this);

        final UsersBean bean = new UsersBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(resetUsersAccountFrom.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);
        table = new UsersTable(main);
        table.addListener((ValueChangeListener) this);
        addComponent(table);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == resetUsersAccountFrom.getReset()) {
           resetUser(form);            
           main.getMainWindow().showNotification("USER RESETED", "", Notification.DELAY_FOREVER);
            main.mainView.setSecondComponent(new UsersAdminMenuView(main, "RESETUSER"));
        }else if(source == resetUsersAccountFrom.getCancel()){
            main.mainView.setSecondComponent(new UsersAdminMenuView(main, "RESETUSER"));
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();

        if (property == table) {
            setSelectedItemId(Long.parseLong(table.getValue().toString()));
            user = data.getUsersService().find(getSelectedItemId());
            usersBean.setId(user.getId());
            usersBean.setUsername(user.getUsername());
            usersBean.setPassword(user.getPassword());
            usersBean.setFirstname(user.getName().getFirstname());
            usersBean.setLastname(user.getName().getLastname());
            usersBean.setOtherName(user.getName().getOtherName());
            usersBean.setTitle(user.getName().getTitle());
            usersBean.setEnabled(user.getEnabled());
               
            if(user.getAddress() != null)
            {
                List<Address> addressList = user.getAddress();
                for (Address add : addressList) {
                    usersBean.setPhysicalAddress(add.getPhysicalAddress());
                    usersBean.setPostalAddress(add.getPostalcode());
                    usersBean.setPostalcode(add.getPostalcode());
                    usersBean.setAddressStatus(add.getAddressStatus());
                }
            }
             if(user.getContacts() != null)
            {
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
                form.setVisibleItemProperties(resetUsersAccountFrom.orderList());

                form.setReadOnly(true);
                //Buttons Behaviou
                resetUsersAccountFrom.getReset().setVisible(true);
                resetUsersAccountFrom.getCancel().setVisible(true);
            }
        }
    }

    /**
     * @return the selectedItemId
     */
    public Long getSelectedItemId() {
        return selectedItemId;
    }

    /**
     * @param selectedItemId the selectedItemId to set
     */
    public void setSelectedItemId(Long selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    public void resetUser(Form form) {
        final Long id = Long.parseLong(form.getField("id").getValue().toString());
        final Users u = data.getUsersService().find(id);
        data.getUsersService().resetPassword(user);
    }
    
}
