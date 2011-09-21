/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.addusers.form;

import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author carlos
 */
public class ResetUsersAccountForm {
    // Define Buttons
    private Button reset = new Button("Reset Password");
    private Button cancel = new Button("Cancel");
    private HorizontalLayout footer;

    public ResetUsersAccountForm() {
    }

    public Form createResetUsersForm() {
        final Form form = new Form();
        form.setCaption(" Reset Users ");
        form.setImmediate(false);
        form.setFormFieldFactory(new UsersFieldFactory());

        // Add Listeners

        setFooter(new HorizontalLayout());
        footer.setSpacing(true);
        footer.addComponent(getReset());
        footer.addComponent(getCancel());
        footer.setVisible(true);
        footer.setMargin(true);
        // Determines which properties are shown, and in which order:
        form.setWriteThrough(false);
        form.setFooter(getFooter());
        reset.setVisible(false);
        cancel.setVisible(false);
        return form;
    }

    public List orderList() {
        final List order = new ArrayList();
//        order.add("emailAddress");
//        order.add("username");
//        order.add("password"); 
        order.add("id");
        return order;
    }

   

  
    public HorizontalLayout getFooter() {
        return footer;
    }

    /**
     * @param footer the footer to set
     */
    public void setFooter(HorizontalLayout footer) {
        this.footer = footer;
    }

    /**
     * @return the reset
     */
    public Button getReset() {
        return reset;
    }

    /**
     * @param reset the reset to set
     */
    public void setReset(Button reset) {
        this.reset = reset;
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

    static class UsersFieldFactory extends DefaultFieldFactory {

        @Override
        public Field createField(Item item, Object propertyId,
                Component uiContext) {
            Field field = super.createField(item, propertyId, uiContext);
            if ("username".equals(propertyId)) {
                field = new TextField("User Name:");
                ((TextField) field).setColumns(25);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("id".equals(propertyId)) {
                field = new TextField("User ID:");
                ((TextField) field).setVisible(false);
            } else if ("password".equals(propertyId)) {
                field = new TextField("Password:");
                ((TextField) field).setColumns(25);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("emailAddress".equals(propertyId)) {
                field = new TextField("Email:");
                ((TextField) field).setColumns(25);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            }
            return field;
        }
    }
}
