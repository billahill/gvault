/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.model.product.product;
/**
 *
 * @author Kraakbeen
 */
public class ProductsTable extends Table{
    
      private final VaultMain main;
      private static final ClientDataService data = new ClientDataService();
      
    public ProductsTable(VaultMain app)
    {
        main = app;
        setSizeFull();
        
        addContainerProperty("Description", String.class, null);
        addContainerProperty("Barcode", String.class, null);
        
        List<product> Product = data.getProductService().findAll(); 
         for (product Products : Product ) {
            addItem(new Object[]{Products.getDescription(),Products.getBarcode()  }, Products.getId());
         }
            
        setSelectable(true);
        
        setImmediate(true);
    }  
}
