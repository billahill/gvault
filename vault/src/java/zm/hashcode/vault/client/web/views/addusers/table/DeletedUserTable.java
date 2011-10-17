/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.addusers.table;

import com.vaadin.ui.Table;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.model.people.Users;
import java.util.List;

/**
 *
 * @author Andre
 */


public class DeletedUserTable extends Table{
    
private static final ClientDataService data = new ClientDataService();
private final VaultMain main; 
    
public DeletedUserTable(VaultMain app) {
        this.main = app;
        // Make Table fill all space
        setSizeFull();
        // Define the names and data types of columns.
        addContainerProperty("User Name", String.class, null);
        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Surname", String.class, null);
//        addContainerProperty("Other Name", String.class, null);
//        addContainerProperty("Title", String.class, null);
        // Add Data Columns
        List<Users> users = data.getUsersService().findAll();
        for (Users u : users) {
            if(u.getEnabled() == false)
            {
            addItem(new Object[]{u.getUsername(),
                        u.getName().getFirstname(),
                        u.getName().getLastname()
                        }, u.getId());
            }
        }
        // Allow selecting items from the table.
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
