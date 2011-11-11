/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.views;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.merchants.forms.ProductsForm;
import zm.hashcode.vault.client.web.views.merchants.tables.ProductsTable;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Reindeer;
import junit.framework.Assert;
import zm.hashcode.vault.app.data.ClientDataService;
//import zm.hashcode.vault.client.web.views.merchants.model.ProductBean;
import zm.hashcode.vault.client.web.views.merchants.MerchantProductView;
import zm.hashcode.vault.client.web.views.merchants.model.ProductsBean;
import zm.hashcode.vault.client.web.views.merchants.model.settingsBean;
import zm.hashcode.vault.infrastructure.factories.product.productFactory;
import zm.hashcode.vault.model.parameters.settings;
import zm.hashcode.vault.model.product.product;


/**
 *
 * @author Kraakbeen
 */
public class ProductsViewPage extends VerticalLayout implements
        ClickListener, ValueChangeListener {

    private final VaultMain main;
    private final Form form;
    private final ProductsForm productsForm;
    private HorizontalLayout horizontalLayout;
    private ProductsBean productBean = new ProductsBean();
    private BeanItem<ProductsBean> pBeanItem = new BeanItem<ProductsBean>(productBean);
    private Long selectedItemId;
    private final ProductsTable table;
    private product Product = new product();
    private static final ClientDataService data = new ClientDataService();
    private settingsBean SettingsBean = new settingsBean();
    private settings Settings;
    
    

    public ProductsViewPage(VaultMain app) {
        main = app;
        setSizeFull();
        horizontalLayout = new HorizontalLayout();
        productsForm = new ProductsForm();
        form = productsForm.createFrom();

        productsForm.getBtnAdd().addListener((ClickListener) this);
        productsForm.getBtnEdit().addListener((ClickListener) this);
        productsForm.getBtnDelete().addListener((ClickListener) this);
        productsForm.getBtncancel().addListener((ClickListener) this);
        
        final ProductsBean bean = new ProductsBean();
        
        final BeanItem item = new BeanItem(bean);
        form.setItemDataSource(item);
        form.setVisibleItemProperties(productsForm.orderList());
        table = new ProductsTable(main);
        table.addListener((ValueChangeListener) this);
        horizontalLayout.addComponent(form);
        horizontalLayout.addComponent(table);

        addComponent(horizontalLayout);
        //setComponentAlignment(form, Alignment.TOP_CENTER);

    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == productsForm.getBtnAdd()) {
            saveNewProduct(form);
        } else if (source == productsForm.getBtncancel()) {
            main.mainView.setSecondComponent(new MerchantProductView(main, "PRODUCTS"));
        }else if (source == productsForm.getBtnEdit()) {
            form.setReadOnly(false);
            saveEdited(form);
            productsForm.getBtnEdit().setVisible(false);
            productsForm.getBtnDelete().setVisible(false);
            productsForm.getBtnAdd().setVisible(true); 
        }else if (source == productsForm.getBtnDelete()){
            form.setReadOnly(false);
            DeleteProduct();
            productsForm.getBtnEdit().setVisible(false);
            productsForm.getBtnDelete().setVisible(false);
            productsForm.getBtnAdd().setVisible(true); 
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            setSelectedItemId(Long.parseLong(table.getValue().toString()));
            Product = data.getProductService().find(getSelectedItemId());
            productBean.setId(Product.getId());
            productBean.setDescription(Product.getDescription());
            productBean.setBarcode(Product.getBarcode());
            productBean.setPrice(Product.getPrice());
            productBean.setPriceInl(Product.getPriceIncl());
            productBean.setVat(Product.isVat());
            productBean.setQty(Product.getQty());

            // form.setReadOnly(false);
            if (productBean != form.getItemDataSource()) {
                form.setItemDataSource(pBeanItem);
                form.setVisibleItemProperties(productsForm.orderList());

                productsForm.getBtnEdit().setVisible(true);
                productsForm.getBtnDelete().setVisible(true);
                productsForm.getBtnAdd().setVisible(false);
            }
        }
    }

    public void saveNewProduct(Form form) {
        try {
            ProductsBean productsBean = new ProductsBean();
            final String Description = form.getField("description").getValue().toString();
            
            final boolean Vat = Boolean.parseBoolean(form.getField("vat").getValue().toString());
            final double Price = Double.parseDouble(form.getField("price").getValue().toString());
            final int qty = Integer.parseInt(form.getField("qty").getValue().toString());
            final double PriceIncl;
            
        final String Barcode;
        if(form.getField("barcode").isModified())
        {
            Barcode = form.getField("barcode").getValue().toString();
        }
        else
        {
         Barcode = "";   
        }
            if(Vat == false)
            {
            PriceIncl = Double.parseDouble(form.getField("price").getValue().toString());
            }
            else
            {
            PriceIncl = calcPrice();
           // PriceIncl = Price * vat;
            }
            productsBean.setBarcode(Barcode);
            productsBean.setDescription(Description);
            productsBean.setPrice(Price);
            productsBean.setVat(Vat);
            productsBean.setPriceInl(PriceIncl);
            productsBean.setQty(qty);
            
            product pro = new productFactory.Builder(productsBean.getDescription(), productsBean.getBarcode()).description(productsBean.getDescription()).barcode(productsBean.getBarcode()).vat(Vat).priceIncl(productsBean.getPriceInl()).price(productsBean.getPrice()).qty(productsBean.getQty()).build();
            data.getProductService().persist(pro);
            pro.getId();
            Assert.assertNotNull(pro.getId());
            main.getMainWindow().showNotification("PRODUCT CREATED", "", Notification.DELAY_FOREVER);
            main.mainView.setSecondComponent(new MerchantProductView(main, "PRODUCTS"));

        } catch (NullPointerException NullPoint) {
            getWindow().showNotification("Data Missing", "You have left some of the feilds out please full them all in", Notification.TYPE_ERROR_MESSAGE);

        } catch (Exception e) {
            getWindow().showNotification("You have put letters in for your numbers, ping and/or you postal code", "Please correct ", Notification.TYPE_ERROR_MESSAGE);

        }
    }

    /**
     * @return the selectedItemId
     */
    public Long getSelectedItemId() {
        return selectedItemId;
    }

    /**
     * @param selectedItemId the selectedItemId to set
     */
    public void setSelectedItemId(Long selectedItemId) {
        this.selectedItemId = selectedItemId;
    }
    
    private void Edit(product p ,double priceIncl, double price,String Description,String Barcode, boolean Vat, int qty)
    {
        p.setDescription(Description);
        p.setBarcode(Barcode);
        p.setVat(Vat);
        p.setPrice(price);
        p.setPriceIncl(priceIncl);
        p.setQty(qty);
        data.getProductService().merge(p);
    }
    
    public void saveEdited(Form form) {
        boolean tmp = true;
        try
        {
       // final Long id = Long.parseLong(form.getField("id").getValue().toString());
       // final product p = data.getProductService().find(id);
        final product p = data.getProductService().find(selectedItemId);
        final String Description = form.getField("description").getValue().toString();
        final String Barcode;
        if(form.getField("barcode").isModified())
        {
            Barcode = form.getField("barcode").getValue().toString();
        }
        else
        {
         Barcode = "";   
        }
        //Barcode = form.getField("barcode").getValue().toString();
        final double PriceIncl;
        final double Price = Double.parseDouble(form.getField("price").getValue().toString());
        final boolean Vat = Boolean.parseBoolean(form.getField("vat").getValue().toString());
        final int qty = Integer.parseInt(form.getField("qty").getValue().toString());
        if(Vat == false)
        {
          PriceIncl = Double.parseDouble(form.getField("price").getValue().toString());  
        }
        else
        {
            PriceIncl = calcPrice();
           //PriceIncl = Double.parseDouble(form.getField("priceInl").getValue().toString());
        }
            if (tmp = true)
            {
            Edit(p, PriceIncl, Price ,Description, Barcode, Vat, qty); 
            }
        }
        catch (NullPointerException NullPoint )
        {
            getWindow().showNotification("Data Missing", "You have left some of the feilds out please full them all in", Notification.TYPE_ERROR_MESSAGE);
            tmp = false;
        }
        
        catch (Exception e)
        {
            getWindow().showNotification("You have put letters where numbers are required", "Please correct", Notification.TYPE_ERROR_MESSAGE);
            tmp = false;
        }
    }
    
    public void DeleteProduct()
    {
        try
        {
        if(productBean.getQty() == 0)
        {
        deleteWindow();
        }else
        {
         getWindow().showNotification("Deletion not completed", "The product is still in inventory", Notification.TYPE_ERROR_MESSAGE);   
        }
            
        }catch(Exception e)
        {
          getWindow().showNotification("Deletion not completed", "Ask Administator for help", Notification.TYPE_ERROR_MESSAGE);  
        }
    }
    public void deleteProduct(Form form) {
        final Long id = selectedItemId;
        final product p = data.getProductService().find(id);
        data.getProductService().remove(p);
    }
    
     public void deleteWindow() {
        Window delete = new Window("Delete");
        delete.setModal(true);
        delete.setStyleName(Reindeer.LAYOUT_BLUE);
        delete.setWidth("260px");
        delete.setResizable(false);
        delete.setClosable(false);
        delete.setDraggable(false);
        delete.setCloseShortcut(KeyCode.ESCAPE, null);

        Label helpText = new Label(
                "Are you sure you want to delete user?",
                Label.CONTENT_XHTML);
        delete.addComponent(helpText);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button yes = new Button("Delete", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                deleteProduct(form);
                main.mainView.setSecondComponent(new MerchantProductView(main, "PRODUCTS"));
                main.getMainWindow().showNotification("Product Deleted", Window.Notification.DELAY_FOREVER);
                main.getMainWindow().removeWindow(event.getButton().getWindow());
            }
        });
        yes.setStyleName(Reindeer.BUTTON_DEFAULT);
        yes.focus();
        buttons.addComponent(yes);
        Button no = new Button("Cancel", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                main.getMainWindow().removeWindow(event.getButton().getWindow());
            }
        });
        buttons.addComponent(no);

        delete.addComponent(buttons);
        ((VerticalLayout) delete.getContent()).setComponentAlignment(buttons,
                "center");
        ((VerticalLayout) delete.getContent()).setSpacing(true);

        main.getMainWindow().addWindow(delete);
    }
     
     public double calcPrice()
     {
         final double PriceIncl;
         try
         {
       
       
       final double Price = Double.parseDouble(form.getField("price").getValue().toString());
       
       int vat = SettingsBean.getVal();
       int vatt = 14;
       PriceIncl = ((Price * vatt) / 100)+ Price;
       
       return PriceIncl;
         }catch(Exception e)
         {
           getWindow().showNotification("Here", "Ask Administator for help", Notification.TYPE_ERROR_MESSAGE); 
           return 0;  
         }
         
     }
     
    
    
}
