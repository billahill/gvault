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
import zm.hashcode.vault.client.web.views.admin.forms.RolesListForm;
import zm.hashcode.vault.client.web.views.admin.model.RolesListBean;
import zm.hashcode.vault.client.web.views.admin.tables.RolesListTable;
import zm.hashcode.vault.infrastructure.factories.metadata.RolesListFactory;
import zm.hashcode.vault.model.metadata.RolesList;

/**
 *
 * @author boniface
 */
public class RolesListViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final RolesListForm pform;
    private static final ClientDataService data = new ClientDataService();
    private final RolesListTable table;
   

    public RolesListViewPage(VaultMain app) {
        main = app;
        setSizeFull();
        pform = new RolesListForm();
        form = pform.createRolesListFrom();

        // Add Listeners
        pform.getSave().addListener((ClickListener) this);
        pform.getEdit().addListener((ClickListener) this);
        pform.getCancel().addListener((ClickListener) this);
        pform.getDelete().addListener((ClickListener) this);
        pform.getUpdate().addListener((ClickListener) this);

        final RolesListBean bean = new RolesListBean();
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(pform.orderList());

        addComponent(form);
        setComponentAlignment(form, Alignment.TOP_CENTER);
        table = new RolesListTable(main);
        table.addListener((ValueChangeListener) this);
        addComponent(table);

    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();

        if (property == table) {
            final Item record = table.getItem(table.getValue());
            final RolesListBean RolesList = new RolesListBean();
            RolesList.setRoleName(record.getItemProperty("Roles List").toString());
            RolesList.setId(new Long(table.getValue().toString()));

            if (RolesList != form.getItemDataSource()) {
                final BeanItem item = new BeanItem(RolesList);
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
            saveNewRolesList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "ROLE"));
        } else if (source == pform.getEdit()) {
            form.setReadOnly(false);
            pform.getSave().setVisible(false);
            pform.getEdit().setVisible(false);
            pform.getCancel().setVisible(true);
            pform.getDelete().setVisible(false);
            pform.getUpdate().setVisible(true);
        } else if (source == pform.getCancel()) {
            main.mainView.setSecondComponent(new AdminMenuView(main, "ROLE"));
        } else if (source == pform.getUpdate()) {
            saveEditedRolesList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "ROLE"));
        } else if (source == pform.getDelete()) {
            deleteRolesList(form);
            main.mainView.setSecondComponent(new AdminMenuView(main, "ROLE"));
        }
    }

    public void saveNewRolesList(Form form) {
        final String rolesListName = form.getField("roleName").getValue().toString();
        final RolesList s = new RolesListFactory.Builder(rolesListName).build();
        data.getRolesListService().persist(s);
    }

    public void saveEditedRolesList(Form form) {
        final String rolesListName = form.getField("roleName").getValue().toString();
        final Long id = Long.parseLong(form.getField("id").getValue().toString());
        final RolesList s = data.getRolesListService().find(id);
        s.setRolename(rolesListName);
        data.getRolesListService().merge(s);
    }

    public void deleteRolesList(Form form) {
        final Long id = Long.parseLong(form.getField("id").getValue().toString());
         final RolesList s = data.getRolesListService().find(id);
        data.getRolesListService().remove(s);
    }
}
