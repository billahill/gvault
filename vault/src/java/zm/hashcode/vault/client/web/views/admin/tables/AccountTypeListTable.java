/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.model.metadata.AccountTypeList;

/**
 *
 * @author boniface
 */
public class AccountTypeListTable extends Table {

    private static final ClientDataService data = new ClientDataService();
    private final VaultMain main;

    public AccountTypeListTable(VaultMain app) {
        this.main = app;
        // Make Table fill all space
        setSizeFull();
        // Define the names and data types of columns.
        addContainerProperty("Account Type", String.class, null);
       
        // Add Data Columns
        List<AccountTypeList> accountTypes = data.getAccountTypeListService().findAll();
        for (AccountTypeList accountType: accountTypes) {
            addItem(new Object[]{accountType.getAccountType()}, accountType.getId());
        }
        // Allow selecting items from the table.
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
