/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author boniface
 */
public class StatusTable extends Table {

    private static final ClientDataService data = new ClientDataService();
    private final VaultMain main;

    public StatusTable(VaultMain app) {
        this.main = app;
        // Make Table fill all space
        setSizeFull();
        // Define the names and data types of columns.
        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Other Name", String.class, null);
        addContainerProperty("Last Name", String.class, null);
        // Add Data Columns
        List<Users> users = data.getUsersService().findAll();
        for (Users user : users) {
            addItem(new Object[]{user.getName().getFirstname()}, user.getId());
            addItem(new Object[]{user.getName().getOtherName()}, user.getId());
            addItem(new Object[]{user.getName().getLastname()}, user.getId());
        }
        // Allow selecting items from the table.
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
