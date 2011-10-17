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
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import zm.hashcode.vault.app.data.ClientDataService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class EnableUserForm {

    private Button activate = new Button("Activate");
    private Button cancel = new Button("Cancel");
    private HorizontalLayout footer;
    private GridLayout layout;
    private static ClientDataService data = new ClientDataService();
    private static final String COMMON_FIELD_WIDTH = "20em";

    public EnableUserForm() {
    }

    public Form EnableUserForm() {
        final Form form = new Form();
        layout = new GridLayout(3, 10);
        layout.setMargin(false, true, false, true);
        layout.setSpacing(true);
        form.setCaption(" Enable User ");
        form.setImmediate(false);
        form.setLayout(layout);

        setFooter(new HorizontalLayout());
        getFooter().setSpacing(true);
        footer.setSpacing(true);
        footer.addComponent(getActivate());
        footer.addComponent(getCancel());
        footer.setVisible(true);
        footer.setMargin(true);

        form.setWriteThrough(false);
        form.setFooter(getFooter());
        activate.setVisible(false);
        cancel.setVisible(false);
        return form;
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

    /**
     * @return the activate
     */
    public Button getActivate() {
        return activate;
    }

    /**
     * @param activate the activate to set
     */
    public void setActivate(Button activate) {
        this.activate = activate;
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

    public List orderList() {
        final List order = new ArrayList();
        order.add("Enabled");
        order.add("id");
        return order;
    }

    static class UsersFieldFactory extends DefaultFieldFactory {

        @Override
        public Field createField(Item item, Object propertyId,
                Component uiContext) {
            Field field = super.createField(item, propertyId, uiContext);
            if ("id".equals(propertyId)) {
                field = new TextField("User ID:");
                ((TextField) field).setVisible(false);
            }
            return field;
        }
    }
}
