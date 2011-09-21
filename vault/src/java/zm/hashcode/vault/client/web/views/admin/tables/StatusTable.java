/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.model.metadata.StatusList;

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
        addContainerProperty("Status", String.class, null);
       
        // Add Data Columns
        List<StatusList> statuses = data.getStatusListService().findAll();
        for (StatusList status : statuses) {
            addItem(new Object[]{status.getStatus()}, status.getId());
        }
        // Allow selecting items from the table.
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
