/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.forms;

import zm.hashcode.vault.client.web.views.students.forms.*;
import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.model.metadata.RolesList;
import zm.hashcode.vault.model.metadata.StatusList;

/**
 *
 * @author boniface
 */
public class PersonalDetailsForm {

    // Define Buttons
    private Button edit = new Button("Edit");
    private Button cancel = new Button("Cancel");
    private Button update = new Button("Update");
    private HorizontalLayout footer;
    private GridLayout layout;
    private static ClientDataService data = new ClientDataService();
    private static final String COMMON_FIELD_WIDTH = "20em";
    public PersonalDetailsForm() {
    }

    public Form createUsersForm() {
        final Form form = new Form();
        layout = new GridLayout(3,10);
        layout.setMargin(false, true, false, true);
        layout.setSpacing(true);
        form.setCaption(" Personal Details ");
        form.setImmediate(false);
        form.setFormFieldFactory(new UsersFieldFactory());
        form.setLayout(layout);
        // Add Listeners

        setFooter(new HorizontalLayout());
        footer.setSpacing(true);
        footer.addComponent(getCancel());
        footer.addComponent(getEdit());
        footer.addComponent(getUpdate());
        footer.setVisible(true);
        footer.setMargin(true);
        // Determines which properties are shown, and in which order:
        edit.setVisible(true);
        update.setVisible(false);
        form.setWriteThrough(false);
        form.setFooter(getFooter());

        return form;
    }

    public List orderList() {
        final List order = new ArrayList();
        order.add("firstname");
        order.add("lastname");
        order.add("title");
        order.add("otherName");
        order.add("phoneNumber");
        order.add("cellNumber");
        order.add("emailAddress");
        order.add("faxNumber");
        order.add("addressStatus");
        order.add("postalAddress");
        order.add("physicalAddress");
        order.add("postalcode");
        order.add("contactStatus");
        order.add("id");
        order.add("rolename");
        return order;
    }


    /**
     * @return the edit
     */
    public Button getEdit() {
        return edit;
    }

    /**
     * @param edit the edit to set
     */
    public void setEdit(Button edit) {
        this.edit = edit;
    }

    /**
     * @return the cancel
     */
    public Button getCancel() {
        return cancel;
    }

    /**
     * @param cancel the cancel to set
     */
    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    /**
     * @return the update
     */
    public Button getUpdate() {
        return update;
    }

    /**
     * @param update the update to set
     */
    public void setUpdate(Button update) {
        this.update = update;
    }
    /**
     * @return the footer
     */
    public HorizontalLayout getFooter() {
        return footer;
    }

    /**
     * @param footer the footer to set
     */
    public void setFooter(HorizontalLayout footer) {
        this.footer = footer;
    }

    static class UsersFieldFactory extends DefaultFieldFactory {

        @Override
        public Field createField(Item item, Object propertyId,
                Component uiContext) {
            Field field = super.createField(item, propertyId, uiContext);
            if ("id".equals(propertyId)) {
                field = new TextField("User ID:");
                ((TextField) field).setVisible(false);
            }else if ("firstname".equals(propertyId)) {
                field = new TextField("First Name:");                
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("lastname".equals(propertyId)) {
                field = new TextField("Last Name:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("rolename".equals(propertyId)) {
                field = new Select("User Role:");
                 List<RolesList> rolesList =  data.getRolesListService().findAll();
                for (RolesList roles : rolesList) {
                    ((Select) field).addItem(roles.getRolename());
                }
                ((Select) field).setRequired(true);
                ((Select) field).setVisible(false);
                ((Select) field).setRequiredError("Please Enter Value");
            }else if ("title".equals(propertyId)) {
                field = new TextField("Title:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("otheName".equals(propertyId)) {
                field = new TextField("Other Name:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(false);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("phoneNumber".equals(propertyId)) {
                field = new TextField("Phone Number:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(false);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("cellNumber".equals(propertyId)) {
                field = new TextField("Cellphone Number:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("emailAddress".equals(propertyId)) {
                field = new TextField("Email:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("faxNumber".equals(propertyId)) {
                field = new TextField("Fax Number:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("addressStatus".equals(propertyId)) {
                field = new Select("Address Status:");
                List<StatusList> statusList =  data.getStatusListService().findAll();
                for (StatusList status : statusList) {
                    ((Select) field).addItem(status.getStatus());
                }
                ((Select) field).setRequired(true);
                ((Select) field).setRequiredError("Please Enter Value");
            }else if ("postalAddress".equals(propertyId)) {
                field = new TextField("Postal Address:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("physicalAddress".equals(propertyId)) {
                field = new TextField("Physical Address:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("postalcode".equals(propertyId)) {
                field = new TextField("Postal Code:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }else if ("contactStatus".equals(propertyId)) {
                field = new Select("Contact Status:");
                 List<StatusList> statusList =  data.getStatusListService().findAll();
                for (StatusList status : statusList) {
                    ((Select) field).addItem(status.getStatus());
                }
                ((Select) field).setRequired(true);
                ((Select) field).setRequiredError("Please Enter Value");
            }
            return field;
        }
    }
}
