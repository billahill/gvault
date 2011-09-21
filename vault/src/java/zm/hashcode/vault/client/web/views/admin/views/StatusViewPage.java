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

import zm.hashcode.vault.client.web.views.admin.forms.StatusForm;
import zm.hashcode.vault.client.web.views.admin.model.StatusBean;
import zm.hashcode.vault.client.web.views.admin.tables.StatusTable;
import zm.hashcode.vault.infrastructure.factories.metadata.StatusListFactory;
import zm.hashcode.vault.model.metadata.StatusList;

/**
 *
 * @author boniface
 */
public class StatusViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final StatusForm pform;
    private static final ClientDataService data = new ClientDataService();
    private final StatusTable table;
   

    public StatusViewPage(VaultMain app) {
        main = app;
        setSizeFull();
        pform = new StatusForm();
        form = pform.createStatusFrom();

        // Add Listeners
        pform.getSave().addListener((ClickListener) this);
        pform.getEdit().addListener((ClickListener) this);
        pform.getCancel().addListener((ClickListener) this);
        pform.getDelete().addListener((ClickListener) this);
        pform.getUpdate().addListener((ClickListener) this);

        final StatusBean bean = new StatusBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(pform.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);
        table = new StatusTable(main);
        table.addListener((ValueChangeListener) this);
        addComponent(table);

    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();

        if (property == table) {
            final Item record = table.getItem(table.getValue());
            final StatusBean status = new StatusBean();
            status.setStatusName(record.getItemProperty("Status").toString());
            status.setStatusId(new Long(table.getValue().toString()));

            if (status != form.getItemDataSource()) {
                final BeanItem item = new BeanItem(status);
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
            saveNewStatus(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "STATUS"));
        } else if (source == pform.getEdit()) {
            form.setReadOnly(false);
            pform.getSave().setVisible(false);
            pform.getEdit().setVisible(false);
            pform.getCancel().setVisible(true);
            pform.getDelete().setVisible(false);
            pform.getUpdate().setVisible(true);
        } else if (source == pform.getCancel()) {
            main.mainView.setSecondComponent(new AdminMenuView(main, "STATUS"));
        } else if (source == pform.getUpdate()) {
            saveEditedStatus(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "STATUS"));
        } else if (source == pform.getDelete()) {
            deleteStatus(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "STATUS"));
        }
    }

    public void saveNewStatus(Form form) {
        final String statusName = form.getField("statusName").getValue().toString();
        final StatusList s = new StatusListFactory.Builder(statusName).build();
        data.getStatusListService().persist(s);
    }

    public void saveEditedStatus(Form form) {
        final String statusName = form.getField("statusName").getValue().toString();
        final Long statusId = Long.parseLong(form.getField("statusId").getValue().toString());
        final StatusList s = data.getStatusListService().find(statusId);
        s.setStatus(statusName);
        data.getStatusListService().merge(s);
    }

    public void deleteStatus(Form form) {
        final Long statusId = Long.parseLong(form.getField("statusId").getValue().toString());
       final StatusList s = data.getStatusListService().find(statusId);
        data.getStatusListService().remove(s);
    }
}
