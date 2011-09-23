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
 * @author Carlos
 */
public class TransferMoneyToUsersForm {
    // Define Buttons
    private Button creditUser = new Button("Credit User");
    private Button cancel = new Button("Cancel");
    private static final String COMMON_FIELD_WIDTH = "20em";
    private HorizontalLayout footer;

    public TransferMoneyToUsersForm() {
    }

    public Form createResetUsersForm() {
        final Form form = new Form();
        form.setCaption(" Credit Users ");
        form.setImmediate(false);
        form.setFormFieldFactory(new UsersFieldFactory());

        // Add Listeners

        setFooter(new HorizontalLayout());
        footer.setSpacing(true);
        footer.addComponent(creditUser);
        footer.addComponent(getCancel());
        footer.setVisible(true);
        footer.setMargin(true);
        // Determines which properties are shown, and in which order:
        form.setWriteThrough(false);
        form.setFooter(getFooter());
        creditUser.setVisible(false);
        cancel.setVisible(false);
        return form;
    }

    public List orderList() {
        final List order = new ArrayList();
        order.add("credit");
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
    public Button getcreditUser() {
        return creditUser;
    }

    /**
     * @param reset the reset to set
     */
    public void setCreditUser(Button reset) {
        this.creditUser = reset;
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
            if ("id".equals(propertyId)) {
                field = new TextField("User ID:");
                ((TextField) field).setVisible(false);
            } else if ("credit".equals(propertyId)) {
                field = new TextField("Credit:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } 
            return field;
        }
    }
}
