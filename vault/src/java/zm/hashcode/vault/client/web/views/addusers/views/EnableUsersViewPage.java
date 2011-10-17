package zm.hashcode.vault.client.web.views.addusers.views;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.UsersAdminMenuView;
import zm.hashcode.vault.client.web.views.addusers.form.EnableUserForm;
import zm.hashcode.vault.client.web.views.addusers.model.AccountLedgerBean;
import zm.hashcode.vault.client.web.views.addusers.model.UsersBean;
import zm.hashcode.vault.client.web.views.addusers.table.DeletedUserTable;
import zm.hashcode.vault.model.people.Address;
import zm.hashcode.vault.model.people.Contacts;
import zm.hashcode.vault.model.people.Users;



/**
 *
 * @author Andre
 */
public class EnableUsersViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {
    
    private final VaultMain main;
    private final Form form;
    private final EnableUserForm enableUserForm;
    private HorizontalLayout horizontalLayout;
    private Long selectedItemId;
    private UsersBean usersBean = new UsersBean();
    private static final ClientDataService data = new ClientDataService();
    private final DeletedUserTable table;
    private Users user = new Users();
    private BeanItem<UsersBean> uBeanItem = new BeanItem<UsersBean>(usersBean);
    private AccountLedgerBean bean = new AccountLedgerBean();
    private BeanItem<AccountLedgerBean> accountBeanItem = new BeanItem<AccountLedgerBean>(bean);
    
    public EnableUsersViewPage(VaultMain app){
        main = app;
        horizontalLayout = new HorizontalLayout();
        setSizeFull();
        enableUserForm = new EnableUserForm();
        form = enableUserForm.EnableUserForm();
        
        enableUserForm.getActivate().addListener((ClickListener) this);
        enableUserForm.getCancel().addListener((ClickListener) this);
         
        final UsersBean bean = new UsersBean();
        final BeanItem item = new BeanItem(bean);
        table = new DeletedUserTable(main);
        table.addListener((ValueChangeListener) this);
        horizontalLayout.addComponent(form);
        horizontalLayout.addComponent(table);
        addComponent(horizontalLayout);
        
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
       if (source == enableUserForm.getActivate()) {
            EnableWindow();
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
            enableUserForm.getActivate().setVisible(true);

            
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
                form.setItemDataSource(accountBeanItem);
                form.setVisibleItemProperties(enableUserForm.orderList());

                form.setReadOnly(false);
               
                enableUserForm.getActivate().setVisible(true);
                enableUserForm.getCancel().setVisible(true);

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
    
   public void EnableUser(Form form) {
        final Long id = Long.parseLong(usersBean.getId().toString());
        final Users u = data.getUsersService().find(id);
        
        data.getUsersService().EnableUser(u);
    }
    
    public void EnableWindow() {
        Window enable= new Window("Enable");
        enable.setModal(true);
        enable.setStyleName(Reindeer.LAYOUT_BLUE);
        enable.setWidth("260px");
        enable.setResizable(false);
        enable.setClosable(false);
        enable.setDraggable(false);
        enable.setCloseShortcut(KeyCode.ESCAPE, null);

        Label helpText = new Label(
                "Do you want to enable the user?",
                Label.CONTENT_XHTML);
        enable.addComponent(helpText);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button yes = new Button("Enable", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                EnableUser(form);
                main.mainView.setSecondComponent(new UsersAdminMenuView(main, "ENABLEUSER"));
                main.getMainWindow().showNotification("User Enabled", Window.Notification.DELAY_FOREVER);
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

        enable.addComponent(buttons);
        ((VerticalLayout) enable.getContent()).setComponentAlignment(buttons,
                "center");
        ((VerticalLayout) enable.getContent()).setSpacing(true);

        main.getMainWindow().addWindow(enable);
    }
    
    
    
}
