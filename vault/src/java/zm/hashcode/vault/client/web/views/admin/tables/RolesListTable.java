/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.model.metadata.RolesList;

/**
 *
 * @author boniface
 */
public class RolesListTable extends Table {

    private static final ClientDataService data = new ClientDataService();
    private final VaultMain main;

    public RolesListTable(VaultMain app) {
        this.main = app;
        // Make Table fill all space
        setSizeFull();
        // Define the names and data types of columns.
        addContainerProperty("Roles List", String.class, null);
       
        // Add Data Columns
        List<RolesList> rolesLists = data.getRolesListService().findAll();
        for (RolesList roleList : rolesLists) {
            addItem(new Object[]{roleList.getRolename()}, roleList.getId());
        }
        // Allow selecting items from the table.
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
