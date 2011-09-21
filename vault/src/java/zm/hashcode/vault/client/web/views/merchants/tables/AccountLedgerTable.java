/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.tables;

import com.vaadin.ui.Table;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.merchants.model.AccountLedgerBean;

/**
 *
 * @author Carlos
 */
public class AccountLedgerTable extends Table{
    private final VaultMain main;

    public AccountLedgerTable(VaultMain app, AccountLedgerBean accBean) {
        this.main = app;
        // Make Table fill all space
        setSizeFull();
        // Define the names and data types of columns.
        addContainerProperty("Date", String.class, null);
        addContainerProperty("Description", String.class, null);
        addContainerProperty("Amount", String.class, null);
        // Add Data Columns
       
        // Allow selecting items from the table.
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
        addItem(new Object[]{
                        accBean.getDateEntry(),
                        accBean.getDescription(),
                        accBean.getDebit(),
                        });
        
    }
}