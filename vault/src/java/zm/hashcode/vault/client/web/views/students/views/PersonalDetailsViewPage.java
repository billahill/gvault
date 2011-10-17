/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.students.views;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Reindeer;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.UsersAdminMenuView;
import zm.hashcode.vault.client.web.views.addusers.model.UsersBean;
import zm.hashcode.vault.client.web.views.students.StudentsMenuView;
import zm.hashcode.vault.client.web.views.students.forms.PersonalDetailsForm;
import zm.hashcode.vault.infrastructure.util.authentication.GetUserCredentials;
import zm.hashcode.vault.model.people.Address;
import zm.hashcode.vault.model.people.Contacts;
import zm.hashcode.vault.model.people.Name;
import zm.hashcode.vault.model.people.Roles;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author boniface
 */
public class PersonalDetailsViewPage extends VerticalLayout implements
        ClickListener {

    private final VaultMain main;
    private final Form form;
    private final PersonalDetailsForm personalDetailsForm;
    private Long selectedItemId;
    private UsersBean usersBean = new UsersBean();
    private Users user = new Users();
    private BeanItem<UsersBean> uBeanItem = new BeanItem<UsersBean>(usersBean);
    private static final ClientDataService data = new ClientDataService();
    private HorizontalLayout horizontalLayout;
    private final String username = new GetUserCredentials().username();

    public PersonalDetailsViewPage(VaultMain app) {
        main = app;
        horizontalLayout = new HorizontalLayout();
        setSizeFull();
        personalDetailsForm = new PersonalDetailsForm();
        form = personalDetailsForm.createUsersForm();

        // Add Listeners
        personalDetailsForm.getEdit().addListener((ClickListener) this);
        personalDetailsForm.getCancel().addListener((ClickListener) this);
        personalDetailsForm.getUpdate().addListener((ClickListener) this);

        final UsersBean bean = (UsersBean) setBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(personalDetailsForm.orderList());
        form.setReadOnly(true);
        horizontalLayout.addComponent(form);
        horizontalLayout.setComponentAlignment(form, Alignment.TOP_CENTER);
        addComponent(horizontalLayout);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == personalDetailsForm.getEdit()) {
            form.setReadOnly(false);
            personalDetailsForm.getEdit().setVisible(false);
            personalDetailsForm.getCancel().setVisible(true);
            personalDetailsForm.getUpdate().setVisible(true);
        } else if (source == personalDetailsForm.getCancel()) {
            main.mainView.setSecondComponent(new StudentsMenuView(main, "PERSONALDETAILS"));
        } else if (source == personalDetailsForm.getUpdate()) {
            saveEdited(form);
            main.mainView.setSecondComponent(new StudentsMenuView(main, "PERSONALDETAILS"));
        }
    }

    public final UsersBean setBean() {
        user = (Users) data.getPurchaseService().getStudentInfo(username);
        usersBean.setId(user.getId());
        usersBean.setUsername(user.getUsername());
        usersBean.setPassword(user.getPassword());
        usersBean.setFirstname(user.getName().getFirstname());
        usersBean.setLastname(user.getName().getLastname());
        usersBean.setOtherName(user.getName().getOtherName());
        usersBean.setTitle(user.getName().getTitle());
        usersBean.setEnabled(user.getEnabled());

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
            form.setVisibleItemProperties(personalDetailsForm.orderList());

            form.setReadOnly(true);
            //Buttons Behaviou
            personalDetailsForm.getEdit().setVisible(true);
            personalDetailsForm.getCancel().setVisible(false);
            personalDetailsForm.getUpdate().setVisible(false);
        }
        return usersBean;
    }

    public void saveEdited(Form form) {
        boolean tmp = true;
        try{
        final Long id = Long.parseLong(form.getField("id").getValue().toString());
        final Users u = data.getUsersService().find(id);
        final String firstName = form.getField("firstname").getValue().toString();
        final String lastName = form.getField("lastname").getValue().toString();
        final String Title = form.getField("title").getValue().toString();
        final String roleName = form.getField("rolename").getValue().toString();
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

        
        //converting thing that dont need to be strings
      
            int intPost = Integer.parseInt(postalCode);
            long longCell = Long.parseLong(cellnumber);
            long longPhone = Long.parseLong(phoneNumber);
            long longFax = Long.parseLong(faxnumber);
            
            if (tmp = true)
            {
            Edit(u ,firstName, lastName, roleName, otherName, phoneNumber ,cellnumber ,emailaddress,faxnumber, addressstatus,postaladdress,physicaladdress,postalCode,contactstatus,Title); 
            }
        }
        catch (NullPointerException NullPoint )
        {
            getWindow().showNotification("Data Missing", "You have left some of the feilds out please full them all in", Notification.TYPE_ERROR_MESSAGE);
            tmp = false;
        }
        
        catch (Exception e)
        {
            getWindow().showNotification("You have put letters in for your numbers, ping and/or you postal code", "Please correct ", Notification.TYPE_ERROR_MESSAGE);
            tmp = false;
        }
    }
    private void Edit(Users u ,String firstName, String lastName,String roleName,String otherName,String phoneNumber,String cellnumber, String emailaddress,String faxnumber,String addressstatus,String postaladdress,String physicaladdress,String postalCode,String contactstatus,String Title)
    {
        Address address = new Address();
        address.setAddressStatus(addressstatus);
        address.setPhysicalAddress(physicaladdress);
        address.setPostalAddress(postaladdress);
        address.setPostalcode(postalCode);

        Contacts cont = new Contacts();
        cont.setCellNumber(cellnumber);
        cont.setContactStatus(contactstatus);
        cont.setEmailAddress(emailaddress);
        cont.setFaxNumber(faxnumber);
        cont.setPhoneNumber(phoneNumber);
        Roles roles = new Roles();
        roles.setRolename(roleName);
        roles.setUsername(usersBean.getUsername());
        Name name = new Name();
        name.setFirstname(firstName);
        name.setLastname(lastName);
        name.setOtherName(otherName);
        name.setTitle(Title);
        u.getName().setFirstname(firstName);
            u.getName().setLastname(lastName);
             u.getName().setOtherName(otherName);
             u.getName().setTitle(Title);
             u.getRoles().add(roles);
             u.getAddress().add(address);
             u.getContacts().add(cont);

            data.getUsersService().merge(u);
        
    }
    public void deleteUser(Form form) {
        final Long id = Long.parseLong(form.getField("id").getValue().toString());
        final Users u = data.getUsersService().find(id);
        data.getUsersService().remove(u);
    }

    public void confirmUpdateWindow() {
        Window delete = new Window("Save Changes");
        delete.setModal(true);
        delete.setStyleName(Reindeer.LAYOUT_BLUE);
        delete.setWidth("260px");
        delete.setResizable(false);
        delete.setClosable(false);
        delete.setDraggable(false);
        delete.setCloseShortcut(KeyCode.ESCAPE, null);

        Label helpText = new Label(
                "Are you sure you want to save changes?",
                Label.CONTENT_XHTML);
        delete.addComponent(helpText);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button yes = new Button("Save", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                deleteUser(form);
                main.mainView.setSecondComponent(new UsersAdminMenuView(main, "MANAGEACCOUNT"));
                main.getMainWindow().showNotification("Changes Saved", Window.Notification.DELAY_FOREVER);
                main.getMainWindow().removeWindow(event.getButton().getWindow());
            }
        });
        yes.setStyleName(Reindeer.BUTTON_DEFAULT);
        yes.focus();
        buttons.addComponent(yes);
        Button no = new Button("Cancel", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                main.getMainWindow().removeWindow(event.getButton().getWindow());
            }
        });
        buttons.addComponent(no);

        delete.addComponent(buttons);
        ((VerticalLayout) delete.getContent()).setComponentAlignment(buttons,
                "center");
        ((VerticalLayout) delete.getContent()).setSpacing(true);

        main.getMainWindow().addWindow(delete);
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
}