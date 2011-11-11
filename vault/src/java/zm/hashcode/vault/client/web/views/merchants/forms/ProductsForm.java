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
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.vault.model.product.product;
/**
 *
 * @author Kraakbeen
 */
public class ProductsForm {
 // Define Buttons
    private Button btnAdd = new Button("Add");
    private Button btnEdit = new Button("Edit");
    private Button btnDelete = new Button("Delete");
    private Button btncancel = new Button("Cancel");
    //Define Footer
    private HorizontalLayout footer; 
    private GridLayout layout;
    private static final String COMMON_FIELD_WIDTH = "20em";
    
        public Form createFrom() {
        final Form form = new Form();
        layout = new GridLayout(3, 10);
        layout.setMargin(true, true, true, true);
        layout.setSpacing(true);
        
        form.setCaption("Product");
        form.setImmediate(false);

        form.setFormFieldFactory(new ProductsFieldFactory());
        form.setLayout(layout);
        
        setFooter(new HorizontalLayout());
        getFooter().setSpacing(true);
        getFooter().addComponent(getBtnAdd());
        getFooter().addComponent(getBtnEdit());
        getFooter().addComponent(getBtnDelete());
        getFooter().addComponent(getBtncancel());
        getFooter().setVisible(true);
        getFooter().setMargin(true);
        
        getBtnAdd().setVisible(true);
        getBtnEdit().setVisible(false);
        getBtnDelete().setVisible(false);
        
        
        form.setWriteThrough(false);
        form.setFooter(getFooter());

        return form;
    }
        
    public List orderList() {
        final List order = new ArrayList();
        order.add("description");
        order.add("price");
        order.add("vat");
        order.add("priceInl");
        order.add("barcode");
        order.add("qty");
        return order;
    }

    /**
     * @return the btnAdd
     */
    public Button getBtnAdd() {
        return btnAdd;
    }

    /**
     * @param btnAdd the btnAdd to set
     */
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /**
     * @return the btnEdit
     */
    public Button getBtnEdit() {
        return btnEdit;
    }

    /**
     * @param btnEdit the btnEdit to set
     */
    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    /**
     * @return the btnDelete
     */
    public Button getBtnDelete() {
        return btnDelete;
    }

    /**
     * @param btnDelete the btnDelete to set
     */
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    /**
     * @return the btncancel
     */
    public Button getBtncancel() {
        return btncancel;
    }

    /**
     * @param btncancel the btncancel to set
     */
    public void setBtncancel(Button btncancel) {
        this.btncancel = btncancel;
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



        
        static class ProductsFieldFactory extends DefaultFieldFactory {

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
            } else if ("price".equals(propertyId)) {
                field = new TextField("Price Excl:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setRequiredError("Please Enter Value");
                
            } else if ("priceInl".equals(propertyId)) {
                field = new TextField("Price Incl:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(true);
                ((TextField) field).setReadOnly(true);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("barcode".equals(propertyId)) {
                field = new TextField("Barcode:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(false);
                ((TextField) field).setRequiredError("Please Enter Value");
            } else if ("vat".equals(propertyId)) {
                field = new Select("Vat:");
                ((Select) field).addItem("True");
                ((Select) field).addItem("False");
                ((Select) field).setRequired(true);
                ((Select) field).setRequiredError("Please Select Value");
            }
            else if ("qty".equals(propertyId)){
              field = new TextField("Quantity:");
                ((TextField) field).setWidth(COMMON_FIELD_WIDTH);
                ((TextField) field).setNullRepresentation("");
                ((TextField) field).setRequired(false);
                ((TextField) field).setRequiredError("Please Enter Value");   
            }
            
            return field;
        }
    }

 }
