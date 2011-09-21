/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.forms;

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
 * @author Carlos
 */
public class AccountWindowForm {

    private Button ok_button = new Button("Ok");
    private Button cancel = new Button("Cancel");
    private static final String COMMON_FIELD_WIDTH = "15em";
    //Define Footer
    private HorizontalLayout footer;

    public AccountWindowForm() {
    }

    public Form createFrom() {
        final Form form = new Form();
        form.setImmediate(false);
        form.setFormFieldFactory(new accountFieldFactory());

        // Add Listeners

        footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(ok_button);
        footer.addComponent(cancel);
        footer.setVisible(true);
        footer.setMargin(true);
        // Determines which properties are shown, and in which order:
        form.setWriteThrough(false);
        form.setFooter(footer);

        return form;
    }

    public List orderList() {
        final List order = new ArrayList();
        order.add("accountNumber");
        order.add("pinNumber");
        order.add("accountId");
        return order;
    }

    /**
     * @return the save
     */
    public Button getSave() {
        return ok_button;
    }

    /**
     * @param save the save to set
     */
    public void setSave(Button save) {
        this.ok_button = save;
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
     * @param footer the footer to set
     */
    public void setFooter(HorizontalLayout footer) {
        this.footer = footer;
    }

    static class accountFieldFactory extends DefaultFieldFactory {

        @Override
        public Field createField(Item item, Object propertyId,
                Component uiContext) {
            Field field = super.createField(item, propertyId, uiContext);
            if ("accountNumber".equals(propertyId)) {
                field = new TextField("Account Number:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("pinNumber".equals(propertyId)) {
                field = new TextField("Pin:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("accountId".equals(propertyId)) {
                field = new TextField("account ID:");
                ((TextField) field).setVisible(false);
            }
            return field;
        }
    }
}
