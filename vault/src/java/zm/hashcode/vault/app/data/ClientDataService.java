/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.app.data;

import org.springframework.context.ApplicationContext;
import zm.hashcode.vault.infrastructure.conf.GetContext;
import zm.hashcode.vault.services.account.AccountService;
import zm.hashcode.vault.services.metadata.AccountTypeListService;
import zm.hashcode.vault.services.metadata.CurrencyListService;
import zm.hashcode.vault.services.metadata.RolesListService;
import zm.hashcode.vault.services.metadata.StatusListService;
import zm.hashcode.vault.services.people.UsersService;
import zm.hashcode.vault.services.purchase.AdminService;
import zm.hashcode.vault.services.purchase.PurchaseService;

/**
 *
 * @author boniface
 */
public class ClientDataService {

    private UsersService usersService;
    private StatusListService statusListService;
    private AccountTypeListService accountTypeListService;
    private RolesListService rolesListService;
    private CurrencyListService currencyListService;
    private AccountService accountService;
    private PurchaseService purchaseService;
    private AdminService adminService;
    private ApplicationContext ctx;
    

    public AccountTypeListService getAccountTypeListService() {
        ctx = GetContext.getApplicationContext();
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        return accountTypeListService;
    }

    public AccountService getAccountService() {
        ctx = GetContext.getApplicationContext();
        accountService = (AccountService) ctx.getBean("accountService");
        return accountService;
    }

    public RolesListService getRolesListService() {
        ctx = GetContext.getApplicationContext();
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        return rolesListService;
    }

    public UsersService getUsersService() {
        ctx = GetContext.getApplicationContext();
        usersService = (UsersService) ctx.getBean("usersService");
        return usersService;
    }

    public CurrencyListService getCurrencyListService() {
        ctx = GetContext.getApplicationContext();
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        return currencyListService;
    }

    public StatusListService getStatusListService() {
        ctx = GetContext.getApplicationContext();
        statusListService = (StatusListService) ctx.getBean("statusListService");
        return statusListService;
    }
    public PurchaseService getPurchaseService(){
        ctx = GetContext.getApplicationContext();
        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
        return purchaseService;
    }
      public AdminService getAdminService(){
        ctx = GetContext.getApplicationContext();
        adminService = (AdminService) ctx.getBean("adminService");
        return adminService;
    }
}
