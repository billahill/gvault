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
import zm.hashcode.vault.client.web.views.admin.forms.CurrencyListForm;
import zm.hashcode.vault.client.web.views.admin.model.CurrencyListBean;
import zm.hashcode.vault.client.web.views.admin.tables.CurrencyListTable;
import zm.hashcode.vault.infrastructure.factories.metadata.CurrencyListFactory;
import zm.hashcode.vault.model.metadata.CurrencyList;

/**
 *
 * @author boniface
 */
public class CurrenciesViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final CurrencyListForm pform;
    private static final ClientDataService data = new ClientDataService();
    private final CurrencyListTable table;

    public CurrenciesViewPage(VaultMain app) {
        main = app;
        setSizeFull();
        pform = new CurrencyListForm();
        form = pform.createCurrencyListFrom();

        // Add Listeners
        pform.getSave().addListener((ClickListener) this);
        pform.getEdit().addListener((ClickListener) this);
        pform.getCancel().addListener((ClickListener) this);
        pform.getDelete().addListener((ClickListener) this);
        pform.getUpdate().addListener((ClickListener) this);

        final CurrencyListBean bean = new CurrencyListBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(pform.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);
        table = new CurrencyListTable(main);
        table.addListener((ValueChangeListener) this);
        addComponent(table);

    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();

        if (property == table) {
            final Item record = table.getItem(table.getValue());
            final CurrencyListBean currencyListBean = new CurrencyListBean();
            currencyListBean.setCurrencyName(record.getItemProperty("Currency Name").toString());
            currencyListBean.setCurrencySymbol(record.getItemProperty("Currency Symbol").toString());
            currencyListBean.setCurrencyCode(record.getItemProperty("Currency Code").toString());
            currencyListBean.setCurrencyShortCode(record.getItemProperty("Currency Short Code").toString());

            currencyListBean.setId(new Long(table.getValue().toString()));

            if (currencyListBean != form.getItemDataSource()) {
                final BeanItem item = new BeanItem(currencyListBean);
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
            saveNewCurrencyList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "CURRENCIES"));
        } else if (source == pform.getEdit()) {
            form.setReadOnly(false);
            pform.getSave().setVisible(false);
            pform.getEdit().setVisible(false);
            pform.getCancel().setVisible(true);
            pform.getDelete().setVisible(false);
            pform.getUpdate().setVisible(true);
        } else if (source == pform.getCancel()) {
            main.mainView.setSecondComponent(new AdminMenuView(main, "CURRENCIES"));
        } else if (source == pform.getUpdate()) {
            saveEditedCurrencyList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "CURRENCIES"));
        } else if (source == pform.getDelete()) {
            deleteCurrencyList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "CURRENCIES"));
        }
    }

    public void saveNewCurrencyList(Form form) {
        final String currecyName = form.getField("currecyName").getValue().toString();
        final String currencySymbol = form.getField("currencySymbol").getValue().toString();
        final String currencyCode = form.getField("currencyCode").getValue().toString();
        final String currencyShortCode = form.getField("currencyShortCode").getValue().toString();
        final CurrencyList s = new CurrencyListFactory.Builder(currecyName, currencySymbol).currencyCode(currencyCode).currencyShortCode(currencyShortCode).build();
        data.getCurrencyListService().persist(s);
    }

    public void saveEditedCurrencyList(Form form) {

        final Long id = Long.parseLong(form.getField("id").getValue().toString());
        final CurrencyList s = data.getCurrencyListService().find(id);
        final String currecyName = form.getField("currecyName").getValue().toString();
        final String currencySymbol = form.getField("currencySymbol").getValue().toString();
        final String currencyCode = form.getField("currencyCode").getValue().toString();
        final String currencyShortCode = form.getField("currencyShortCode").getValue().toString();

        s.setCurrencyName(currecyName);
        s.setCurrencyCode(currencyCode);
        s.setCurrencyShortCode(currencyShortCode);
        s.setCurrencySymbol(currencySymbol);


        data.getCurrencyListService().merge(s);
    }

    public void deleteCurrencyList(Form form) {
        final Long id = Long.parseLong(form.getField("id").getValue().toString());
        final CurrencyList s = data.getCurrencyListService().find(id);
        data.getCurrencyListService().remove(s);
    }
}
