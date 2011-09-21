/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.views;

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
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.merchants.MerchantMenuView;
import zm.hashcode.vault.client.web.views.merchants.forms.AccountLedgerForm;
import zm.hashcode.vault.client.web.views.merchants.model.AccountLedgerBean;
import zm.hashcode.vault.infrastructure.factories.account.AccountLedgerFactory;
import zm.hashcode.vault.infrastructure.util.ConvertDate;
import zm.hashcode.vault.infrastructure.util.authentication.GetUserCredentials;
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author Carlos
 */
public class AccountLedgerViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final AccountLedgerForm accFrom;
    private static final ClientDataService data = new ClientDataService();
    private Table table = new Table();
    private boolean response = false;
    private MerchantMenuView merchantMenuView;
    private Button saveSaleBtn, cancelBtn;
    private static final String COMMON_FIELD_WIDTH = "15em";
    private List<AccountLedgerBean> accLedger = new ArrayList<AccountLedgerBean>();
    private AccountLedgerBean accLedgerBean = new AccountLedgerBean();
    private Button remove;
    private final String username = new GetUserCredentials().username();
    private Date date = new Date();
    private ConvertDate cDate = new ConvertDate();
    private BigDecimal debit = new BigDecimal(BigInteger.ZERO);
    private HorizontalLayout horiLayout;
    int accountId;
    // private final StatusFactory factory = data.getStatusFactory();

    public AccountLedgerViewPage(VaultMain app) {
        main = app;
        horiLayout = new HorizontalLayout();
        horiLayout.setSpacing(true);
        setSizeFull();
        accFrom = new AccountLedgerForm();
        form = accFrom.createStatusFrom();

        // Add Listeners
        accFrom.getSave().addListener((ClickListener) this);
        accFrom.getCancel().addListener((ClickListener) this);
        //Buttons
        remove = new Button("Remove");
        remove.addListener((ClickListener) this);
        saveSaleBtn = new Button("Make Payment");
        saveSaleBtn.addListener((ClickListener) this);
        cancelBtn = new Button("Cancel Sale");
        cancelBtn.addListener((ClickListener) this);
        //Add table.
        table.setSizeFull();
        // Define the names and data types of columns.
        table.addContainerProperty("Date", String.class, null);
        table.addContainerProperty("Description", String.class, null);
        table.addContainerProperty("Price", String.class, null);
        // Add Data Columns

        // Allow selecting items from the table.
        table.setSelectable(true);
        // Send changes in selection immediately to server.
        table.setImmediate(true);

        final AccountLedgerBean bean = new AccountLedgerBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(accFrom.orderList());
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horiLayout.addComponent(form);
        horiLayout.setComponentAlignment(form, Alignment.TOP_CENTER);
        table.addListener((ValueChangeListener) this);
        horiLayout.addComponent(table);
        horiLayout.setComponentAlignment(table, Alignment.TOP_RIGHT);

        horizontalLayout.addComponent(saveSaleBtn);
        horizontalLayout.addComponent(cancelBtn);
        horizontalLayout.addComponent(remove);
        addComponent(horiLayout);
        addComponent(horizontalLayout);
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();

        if (property == table) {
//            String str_date;           
//            final Item record = table.getItem(table.getValue());
//            str_date = record.getItemProperty("date").toString();
//            date = cDate.String2Date2(str_date);
//            String amount = record.getItemProperty("amount").toString();
//            //final AccountLedgerBean accLedgerBean = new AccountLedgerBean();
//            accLedgerBean.setDescription(record.getItemProperty("description").toString());
//            BigDecimal debit = new BigDecimal(amount.toString());
//            accLedgerBean.setDateEntry(date);
//            accLedgerBean.setDebit(debit);
//            accLedgerBean.setId(new Long(table.getValue().toString()));
//
            if (accLedgerBean != form.getItemDataSource()) {
                final BeanItem item = new BeanItem(accLedgerBean);
                form.setItemDataSource(item);
                form.setVisibleItemProperties(accFrom.orderList());

                form.setReadOnly(true);
                //Buttons Behaviou
                accFrom.getSave().setVisible(false);
                accFrom.getCancel().setVisible(true);
            }

        }
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == accFrom.getSave()) {
            addToTheTable();
            //accFrom.createStatusFrom().g
            // main.mainView.setSecondComponent(new MerchantMenuView(main, "ACCOUNTLEDGERVIEWPAGE"));
        } else if (source == accFrom.getCancel()) {
            main.mainView.setSecondComponent(new MerchantMenuView(main, "ACCOUNTLEDGERVIEWPAGE"));
        } else if (source == saveSaleBtn) {
            System.out.println("Total: " + debit.toString());
            promptUser();
        } else if (source == cancelBtn) {
            main.mainView.setSecondComponent(new MerchantMenuView(main, "ACCOUNTLEDGERVIEWPAGE"));
        } else if (source == remove) {
            deleteItemWindow();

        }
    }

    private void promptUser() {
        // Create the window...
        final Window subwindow = new Window("Make Payment");
        // ...and make it modal
        subwindow.setWidth("248px");
        subwindow.setHeight("36%");
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
        final TextField usernameField = new TextField("Username:");
        usernameField.setRequired(true);
        usernameField.setWidth(COMMON_FIELD_WIDTH);
        final PasswordField pinNumber = new PasswordField("Pin Number:");
        pinNumber.setRequired(true);
        pinNumber.setWidth(COMMON_FIELD_WIDTH);

        Button save = new Button("Save", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                String uname = usernameField.getValue().toString();
                String pin = pinNumber.getValue().toString();
                makeSale(uname, pin);

                (subwindow.getParent()).removeWindow(subwindow);

            }
        });
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
        layout.addComponent(usernameField);
        layout.addComponent(pinNumber);
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

    private void addToTheTable() {
        accountId++;
        String accountIdstr = Integer.toString(accountId);
        accLedgerBean = new AccountLedgerBean();
        final Date paymentDate = (Date) form.getField("dateEntry").getValue();
        final String description = form.getField("description").getValue().toString();
        final String priceStr = form.getField("debit").getValue().toString();

        accLedgerBean.setId(Long.parseLong(accountIdstr));
        accLedgerBean.setDateEntry(paymentDate);
        final BigDecimal price;
        try {
            price = new BigDecimal(priceStr);
            accLedgerBean.setDebit(price);
        } catch (Exception e) {
            main.getMainWindow().getWindow().showNotification("Price must be numbers not letter", Window.Notification.TYPE_ERROR_MESSAGE);
        }

        accLedgerBean.setDescription(description);
        AccountLedgerBean acc = new AccountLedgerBean();
        acc.setId(accLedgerBean.getId());
        acc.setDateEntry(accLedgerBean.getDateEntry());
        acc.setDebit(accLedgerBean.getDebit());
        acc.setDescription(accLedgerBean.getDescription());
        debit = debit.add(accLedgerBean.getDebit());
        accLedger.add(acc);
        table.addItem(new Object[]{
                    accLedgerBean.getDateEntry(),
                    accLedgerBean.getDescription(),
                    accLedgerBean.getDebit(),}, accLedgerBean.getId());

    }

    private void makeSale(String uname, String pin) {
        accLedgerBean = new AccountLedgerBean();
        String balance;
        Users user = new Users();
        String aNumber, pinNumber;
        user = (Users) data.getUsersService().getByPropertyName("username", uname);
        pinNumber = user.getAccount().getPinNumber();
        balance = (String) data.getPurchaseService().checkBalance(debit, uname);
        List<AccountLedger> acLedger = new ArrayList<AccountLedger>();
        for (AccountLedgerBean bean : accLedger) {
            accLedgerBean.setDebit(bean.getDebit());
            accLedgerBean.setDateEntry(bean.getDateEntry());
            accLedgerBean.setDescription(bean.getDescription());
            AccountLedger acc = new AccountLedgerFactory.Builder(accLedgerBean.getDateEntry(), accLedgerBean.getDescription()).debit(accLedgerBean.getDebit()).build();
            acLedger.add(acc);
        }
        if (pinNumber.equals(pin)) {
            if (balance.equals("You have enough funds")) {
                data.getPurchaseService().payMethod(acLedger, uname);
                data.getPurchaseService().receivePayment(acLedger, username);
                main.getMainWindow().showNotification("Done! :)", Window.Notification.DELAY_FOREVER);
            } else {
                main.getMainWindow().showNotification("Insuffient funds!", Window.Notification.TYPE_ERROR_MESSAGE);
            }
        }

    }

    public void deleteItemWindow() {
        Window delete = new Window("Delete");
        delete.setModal(true);
        delete.setStyleName(Reindeer.LAYOUT_BLUE);
        delete.setWidth("260px");
        delete.setResizable(false);
        delete.setClosable(false);
        delete.setDraggable(false);
        delete.setCloseShortcut(KeyCode.ESCAPE, null);

        Label helpText = new Label(
                "Are you sure you want to this item?",
                Label.CONTENT_XHTML);
        delete.addComponent(helpText);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button yes = new Button("Delete", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                //deleteUser(form);
                deleteItem();
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
                Alignment.MIDDLE_CENTER);
        ((VerticalLayout) delete.getContent()).setSpacing(true);

        main.getMainWindow().addWindow(delete);
    }

    public void deleteItem() {
        //System.out.println("Table Id:" + table.getValue().toString());
        for (AccountLedgerBean bean : accLedger) {
            String id = bean.getId().toString();
            if (table.getValue().toString().equals(id)) {
                accLedger.remove(bean);
                main.getMainWindow().showNotification("Item deleted");
                table.removeItem(table.getValue());
                break;
            }

        }
    }
}
