/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.web.views.merchants.views;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.client.web.VaultMain;
import zm.hashcode.vault.client.web.views.merchants.MerchantMenuView;
import zm.hashcode.vault.client.web.views.merchants.forms.AccountWindowForm;
import zm.hashcode.vault.model.account.Account;

/**
 *
 * @author Carlos
 */
public class AccountDetailsWindow extends Window {

    private AccountWindowForm accform;
    private Form form;
    private VaultMain main;
    private TabSheet tab;
    private MerchantMenuView merchantView;
    private ClientDataService data = new ClientDataService();

    public AccountDetailsWindow() {
        setName("Account Authentication");
        loadUI();
    }

    private void loadUI() {
        try {
        accform = new AccountWindowForm();
        form = accform.createFrom();
        accform.getSave().addListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                String accNumber = form.getField("accountNumber").getValue().toString();
                String pinNumber = form.getField("pinNumber").getValue().toString();
                
                long tmp = Long.parseLong(accNumber);
                tmp = Long.parseLong(pinNumber);
                Account account = data.getAccountService().getByPropertyName("accountNumber", accNumber);
                if(accNumber.equals(account.getAccountNumber()) && pinNumber.equals(account.getPinNumber().toString()))
                {
                   // tab.addComponent(merchantView.getAccountLedger());
                   // merchantView.setTab(tab);
                }else{
                    main.getMainWindow().showNotification("Account Does not exist!", "Error", Notification.TYPE_ERROR_MESSAGE);
                }

            }
        });
        accform.getCancel().addListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                main.mainView.setSecondComponent(new MerchantMenuView(main, "ACCOUNTLEDGERVIEWPAGE"));
            }
        });
        }
         catch (NullPointerException NullPoint )
        {
            getWindow().showNotification("Data Missing", "You have left some of the feilds out please full them all in", Notification.TYPE_ERROR_MESSAGE);
           
        }
        
        catch (Exception e)
        {
            getWindow().showNotification("You have put letters in for your pin and/or your account Number", "Please correct ", Notification.TYPE_ERROR_MESSAGE);
            
        }
    }
}
