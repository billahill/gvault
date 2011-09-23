/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.addusers.views;

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
import java.math.BigDecimal;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.addusers.UsersAdminMenuView;
import zm.hashcode.vault.client.web.views.addusers.form.TransferMoneyToUsersForm;
import zm.hashcode.vault.client.web.views.addusers.model.AccountLedgerBean;
import zm.hashcode.vault.client.web.views.addusers.model.UsersBean;
import zm.hashcode.vault.client.web.views.addusers.table.UsersTable;
import zm.hashcode.vault.model.people.Address;
import zm.hashcode.vault.model.people.Contacts;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author boniface
 */
public class TransferMoneyToUsersViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final TransferMoneyToUsersForm transferMoneyToUsersForm;
    private Long selectedItemId;
    private UsersBean usersBean = new UsersBean();
    private Users user = new Users();
    private AccountLedgerBean bean = new AccountLedgerBean();
    private BeanItem<AccountLedgerBean> accountBeanItem = new BeanItem<AccountLedgerBean>(bean);
    private static final ClientDataService data = new ClientDataService();
    private final UsersTable table;

    public TransferMoneyToUsersViewPage(VaultMain app) {
        main = app;
        setSizeFull();
        transferMoneyToUsersForm = new TransferMoneyToUsersForm();
        form = transferMoneyToUsersForm.createResetUsersForm();

        // Add Listeners
        transferMoneyToUsersForm.getcreditUser().addListener((ClickListener) this);
        transferMoneyToUsersForm.getCancel().addListener((ClickListener) this);

        // final AccountLedgerBean bean = new AccountLedgerBean();
        // final BeanItem item = new BeanItem(bean);
        //form.setItemDataSource(item);
        form.setVisibleItemProperties(transferMoneyToUsersForm.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);
        table = new UsersTable(main);
        table.addListener((ValueChangeListener) this);
        addComponent(table);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == transferMoneyToUsersForm.getcreditUser()) {
            creditWindow();
        } else if (source == transferMoneyToUsersForm.getCancel()) {
            main.mainView.setSecondComponent(new UsersAdminMenuView(main, "CREDITUSER"));
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
                form.setVisibleItemProperties(transferMoneyToUsersForm.orderList());

                form.setReadOnly(false);
                //Buttons Behaviou
                transferMoneyToUsersForm.getcreditUser().setVisible(true);
                transferMoneyToUsersForm.getCancel().setVisible(true);
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

    public void creditWindow() {
        Window delete = new Window("Credit");
        delete.setModal(true);
        delete.setStyleName(Reindeer.LAYOUT_BLUE);
        delete.setWidth("260px");
        delete.setResizable(false);
        delete.setClosable(false);
        delete.setDraggable(false);
        delete.setCloseShortcut(KeyCode.ESCAPE, null);

        Label helpText = new Label(
                "Are you sure you want to credit the user?",
                Label.CONTENT_XHTML);
        delete.addComponent(helpText);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button yes = new Button("Credit", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                creditUser(form);
                main.mainView.setSecondComponent(new UsersAdminMenuView(main, "CREDITUSER"));
                main.getMainWindow().showNotification("USER CREDITED", "", Notification.DELAY_FOREVER);
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

    public void creditUser(Form form) {
        //final Long id = Long.parseLong(form.getField("id").getValue().toString());
        Long id = usersBean.getId();
        final String strCredit = form.getField("credit").getValue().toString();
        BigDecimal credit = new BigDecimal(strCredit);
        data.getAdminService().loadCredit(credit, id);
    }
}