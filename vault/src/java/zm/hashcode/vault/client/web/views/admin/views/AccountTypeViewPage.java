/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin.views;

import com.vaadin.data.Item;
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
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.admin.AdminMenuView;
import zm.hashcode.vault.client.web.views.admin.forms.AccountTypeListForm;
import zm.hashcode.vault.client.web.views.admin.model.AccountTypeListBean;
import zm.hashcode.vault.client.web.views.admin.tables.AccountTypeListTable;
import zm.hashcode.vault.infrastructure.factories.metadata.AccountTypeListFactory;
import zm.hashcode.vault.model.metadata.AccountTypeList;

/**
 *
 * @author boniface
 */
public class AccountTypeViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final AccountTypeListForm pform;
    private static final ClientDataService data = new ClientDataService();
    private final AccountTypeListTable table;
   // private final AccountTypeListFactory factory = data.getAccountTypeListFactory();

    public AccountTypeViewPage(VaultMain app) {
        main = app;
        setSizeFull();
        pform = new AccountTypeListForm();
        form = pform.createAccountTypeListFrom();

        // Add Listeners
        pform.getSave().addListener((ClickListener) this);
        pform.getEdit().addListener((ClickListener) this);
        pform.getCancel().addListener((ClickListener) this);
        pform.getDelete().addListener((ClickListener) this);
        pform.getUpdate().addListener((ClickListener) this);

        final AccountTypeListBean bean = new AccountTypeListBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(pform.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);
        table = new AccountTypeListTable(main);
        table.addListener((ValueChangeListener) this);
        addComponent(table);

    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();

        if (property == table) {
            final Item record = table.getItem(table.getValue());
            final AccountTypeListBean accountTypeListBean = new AccountTypeListBean();
            accountTypeListBean.setAccountTypeName(record.getItemProperty("Account Type").toString());
            accountTypeListBean.setId(new Long(table.getValue().toString()));

            if (accountTypeListBean != form.getItemDataSource()) {
                final BeanItem item = new BeanItem(accountTypeListBean);
                form.setItemDataSource(item);
                form.setVisibleItemProperties(pform.orderList());

                form.setReadOnly(true);
                //Buttons Behaviou
                pform.getSave().setVisible(false);
                pform.getEdit().setVisible(true);
                pform.getCancel().setVisible(true);
                pform.getDelete().setVisible(true);
                pform.getUpdate().setVisible(false);
            }
        }
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == pform.getSave()) {
            saveNewAccountTypeList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "ACCOUNT"));
        } else if (source == pform.getEdit()) {
            form.setReadOnly(false);
            pform.getSave().setVisible(false);
            pform.getEdit().setVisible(false);
            pform.getCancel().setVisible(true);
            pform.getDelete().setVisible(false);
            pform.getUpdate().setVisible(true);
        } else if (source == pform.getCancel()) {
            main.mainView.setSecondComponent(new AdminMenuView(main, "ACCOUNT"));
        } else if (source == pform.getUpdate()) {
            saveEditedAccountTypeList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "ACCOUNT"));
        } else if (source == pform.getDelete()) {
            deleteAccountTypeList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "ACCOUNT"));
        }
    }

    public void saveNewAccountTypeList(Form form) {
        final String AccountTypeListName = form.getField("accountTypeName").getValue().toString();
        final AccountTypeList s = new AccountTypeListFactory.Builder(AccountTypeListName).build();
        data.getAccountTypeListService().persist(s);
    }

    public void saveEditedAccountTypeList(Form form) {
        final String accountTypeName = form.getField("accountTypeName").getValue().toString();
        final Long id = Long.parseLong(form.getField("id").getValue().toString());
        final AccountTypeList s = data.getAccountTypeListService().find(id);
        s.setAccountType(accountTypeName);
        data.getAccountTypeListService().merge(s);
    }

    public void deleteAccountTypeList(Form form) {
        final Long id= Long.parseLong(form.getField("id").getValue().toString());
       final AccountTypeList s = data.getAccountTypeListService().find(id);
        data.getAccountTypeListService().remove(s);
    }
}
