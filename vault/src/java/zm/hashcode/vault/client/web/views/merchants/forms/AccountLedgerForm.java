/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.forms;

import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class AccountLedgerForm {
      // Define Buttons
    private Button add = new Button("Add");
    private Button cancel = new Button("Cancel");
    private static final String COMMON_FIELD_WIDTH ="20em";    
    private GridLayout layout;
    //Define Footer
    private HorizontalLayout footer;

    public AccountLedgerForm() {
    }

    public Form createStatusFrom() {
        final Form form = new Form();
        layout = new GridLayout(3, 10);
        layout.setMargin(false, true, false, true);
        layout.setSpacing(true);
        form.setCaption("Sales");
        form.setImmediate(false);
        form.setFormFieldFactory(new StatusFieldFactory());
        form.setLayout(layout);
        // Add Listeners

        footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(add);
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
        order.add("dateEntry");
        order.add("description");
        order.add("debit");
        order.add("accountId");
        return order;
    }

   
    /**
     * @return the save
     */
    public Button getSave() {
        return add;
    }

    /**
     * @param save the save to set
     */
    public void setSave(Button save) {
        this.add = save;
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

    static class StatusFieldFactory extends DefaultFieldFactory {

        @Override
        public Field createField(Item item, Object propertyId,
                Component uiContext) {
            Field field = super.createField(item, propertyId, uiContext);
            if ("description".equals(propertyId)) {
                field = new TextField("Description:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("dateEntry".equals(propertyId)) {
                field = new DateField("Date:");
                ((DateField) field).setValidationVisible(true);
                ((DateField) field).setRequired(true);
                ((DateField) field).setDateFormat("yyyy-MM-dd");
                ((DateField) field).setRequiredError("Please Enter Value");
            } else if ("debit".equals(propertyId)) {
                field = new TextField("Price:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("accountLedgerId".equals(propertyId)) {
                field = new TextField("account ID:");
                ((TextField) field).setVisible(false);
            }
            return field;
        }
    }
}
