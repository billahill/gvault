/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.admin.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.model.metadata.CurrencyList;

/**
 *
 * @author boniface
 */
public class CurrencyListTable extends Table {

    private static final ClientDataService data = new ClientDataService();
    private final VaultMain main;

    public CurrencyListTable(VaultMain app) {
        this.main = app;
        // Make Table fill all space
        setSizeFull();


        // Define the names and data types of columns.
        addContainerProperty("Currency Name", String.class, null);
        addContainerProperty("Currency Symbol", String.class, null);
        addContainerProperty("Currency Code", String.class, null);
        addContainerProperty("Currency Short Code", String.class, null);

        // Add Data Columns
        List<CurrencyList> currencyLists = data.getCurrencyListService().findAll();
        for (CurrencyList currencyList : currencyLists) {
            addItem(new Object[]{
                currencyList.getCurrencyName(),
                currencyList.getCurrencySymbol(),
                currencyList.getCurrencyCode(),
                currencyList.getCurrencyShortCode()
            }, currencyList.getId());
        }
        // Allow selecting items from the table.
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
