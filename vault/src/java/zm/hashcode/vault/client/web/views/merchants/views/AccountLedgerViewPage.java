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
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Reindeer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.merchants.MerchantMenuView;
import zm.hashcode.vault.client.web.views.merchants.forms.AccountLedgerForm;
import zm.hashcode.vault.client.web.views.merchants.model.AccountLedgerBean;
import zm.hashcode.vault.client.web.views.merchants.model.ProductsBean;
import zm.hashcode.vault.client.web.views.merchants.model.receiptBeans;
import zm.hashcode.vault.client.web.views.merchants.model.receiptDetailBeans;
import zm.hashcode.vault.client.web.views.merchants.tables.ProductsTable;
import zm.hashcode.vault.infrastructure.factories.account.AccountLedgerFactory;
import zm.hashcode.vault.infrastructure.factories.metadata.RecieptDetailFactory;
import zm.hashcode.vault.infrastructure.factories.metadata.RecieptFactory;
import zm.hashcode.vault.infrastructure.util.ConvertDate;
import zm.hashcode.vault.infrastructure.util.authentication.GetUserCredentials;
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.model.metadata.Reciept;
import zm.hashcode.vault.model.metadata.RecieptDetail;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.model.product.product;

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
    private Table table2 = new Table();
    private boolean response = false;
    private MerchantMenuView merchantMenuView;
    private Button saveSaleBtn, cancelBtn;
    private int p;
    private double totalprice;
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
    private Long selectedItemId;
    private Label totalDisplay = new Label("Total:");
    private Label total = new Label("0.00");
    private product Product = new product();
    private ProductsBean productBean = new ProductsBean();
    private BeanItem<ProductsBean> pBeanItem = new BeanItem<ProductsBean>(productBean);
//NOT MY SPELLING ERROR ON receipt
    private Reciept receipt = new Reciept();
    private RecieptDetail receiptdetail = new RecieptDetail();
    private receiptBeans receiptbean = new receiptBeans();
    private List<receiptDetailBeans> detail = new ArrayList<receiptDetailBeans>();
    private receiptDetailBeans detailBeans = new receiptDetailBeans();
    private double CountingTotal;
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

        table.addContainerProperty("Date", String.class, null);
        table.addContainerProperty("Description", String.class, null);
        table.addContainerProperty("Price", String.class, null);
        table2 = new ProductsTable(main);
        table2.addListener((ValueChangeListener) this);
        horiLayout.addComponent(table2);
        table.setSelectable(true);
        table.setImmediate(true);
        table.setSizeFull();
        //footer.addComponent(totalDisplay);
        //footer.addComponent(total);
        final AccountLedgerBean bean = new AccountLedgerBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(accFrom.orderList());
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horiLayout.addComponent(form);
        horiLayout.setComponentAlignment(form, Alignment.TOP_CENTER);
        horiLayout.addComponent(table);
        table.addListener((ValueChangeListener) this);
        horiLayout.addComponent(totalDisplay);
        horiLayout.addComponent(total);
        horiLayout.setComponentAlignment(table, Alignment.TOP_RIGHT);
        horiLayout.setComponentAlignment(totalDisplay, Alignment.BOTTOM_LEFT);
        horiLayout.setComponentAlignment(total, Alignment.BOTTOM_RIGHT);
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

        } else if (property == table2) {
            setSelectedItemId(Long.parseLong(table2.getValue().toString()));
            Product = data.getProductService().find(getSelectedItemId());
            productBean.setId(Product.getId());
            productBean.setDescription(Product.getDescription());
            productBean.setBarcode(Product.getBarcode());
            productBean.setPrice(Product.getPrice());
            productBean.setPriceInl(Product.getPriceIncl());
            productBean.setVat(Product.isVat());
            productBean.setQty(Product.getQty());
        }
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == accFrom.getSave()) {
            //addToTheTable();
            addingToTableAndReceipt();
            //accFrom.createStatusFrom().g
            // main.mainView.setSecondComponent(new MerchantMenuView(main, "ACCOUNTLEDGERVIEWPAGE"));
        } else if (source == accFrom.getCancel()) {
            main.mainView.setSecondComponent(new MerchantMenuView(main, "ACCOUNTLEDGERVIEWPAGE"));
        } else if (source == saveSaleBtn) {
            System.out.println("Total: " + debit.toString());
            promptUser();
            
            main.mainView.setSecondComponent(new MerchantMenuView(main, "ACCOUNTLEDGERVIEWPAGE"));
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
                saveToReceipt();
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

    /*private void addToTheTable() {
    accountId++;
    String accountIdstr = Integer.toString(accountId);
    accLedgerBean = new AccountLedgerBean();
    final Date paymentDate = (Date) form.getField("dateEntry").getValue();
    final String description = form.getField("description").getValue().toString();
    final String priceStr = form.getField("debit").getValue().toString();
    try
    {
    int t = (Integer.parseInt(priceStr) * 100);
    p = (p * 100) + t;
    totalprice = (p / 100);
    }
    catch(Exception e)
    {
    main.getMainWindow().getWindow().showNotification("" + e, Window.Notification.TYPE_ERROR_MESSAGE); 
    }
    total.setValue(totalprice);
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
    
    }*/
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

    public void addingToTableAndReceipt() {
        accountId++;
        String accountIdstr = Integer.toString(accountId);
        accLedgerBean.setId(Long.parseLong(accountIdstr));
        Date now = new Date();
        accLedgerBean.setDescription(productBean.getDescription());
        AccountLedgerBean acc = new AccountLedgerBean();

        accLedgerBean.setDebit(BigDecimal.valueOf(productBean.getPriceInl()));
        accLedgerBean.setDateEntry(now);
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
        promptUserQuantity();


    }

    private void promptUserQuantity() {
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
        final TextField qtyField = new TextField("Quantity:");
        qtyField.setRequired(true);
        qtyField.setWidth(COMMON_FIELD_WIDTH);

        Button save = new Button("Save", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                int qty = Integer.parseInt(qtyField.getValue().toString());
                detailBeans.setQty(qty);
                (subwindow.getParent()).removeWindow(subwindow);
                saveToReceiptdetail();
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
        layout.addComponent(qtyField);
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

//private Reciept receipt = new Reciept();
//private RecieptDetail receiptdetail = new RecieptDetail();
//private receiptBeans receiptbean = new receiptBeans();
//private receiptDetailBeans detailBeans = new receiptDetailBeans();
    public void saveToReceiptdetail() {
        try {
            detailBeans.setDescript(productBean.getDescription());
            detailBeans.setPrice(productBean.getPriceInl());
            double totalAmount = 0;
            if (detailBeans.getQty() > 1) {
                totalAmount = detailBeans.getQty() * productBean.getPriceInl();
                detailBeans.setTotal(totalAmount);
                totalprice = totalAmount;
                
                
            } else {
                detailBeans.setTotal(productBean.getPriceInl());
                totalprice = productBean.getPriceInl();
            }
            CountingTotal += totalprice;
            total.setValue(CountingTotal);
            RecieptDetail pro = new RecieptDetailFactory.Builder(detailBeans.getPrice()).descript(detailBeans.getDescript()).Price(detailBeans.getPrice()).Qty(detailBeans.getQty()).Total(detailBeans.getTotal()).build();
            data.getRecieptdetailService().persist(pro);
            pro.getId();
            Assert.assertNotNull(pro.getId());
        } catch (Exception e) {
            getWindow().showNotification("Data Missing", "Here", Notification.TYPE_ERROR_MESSAGE);

        }
    }

    public void saveToReceipt() {
        receiptbean.setDateEntry(date);
        receiptbean.setPrice(CountingTotal);
        //
        Reciept re = new RecieptFactory.Builder(receiptbean.getPrice()).Price(receiptbean.getPrice()).Date(receiptbean.getDateEntry()).build();
        data.getRecieptService().persist(re);
        re.getId();
        Assert.assertNotNull(re.getId());
    }
}
