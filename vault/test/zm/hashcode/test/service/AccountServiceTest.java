/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.vault.infrastructure.factories.account.AccountFactory;
import zm.hashcode.vault.infrastructure.factories.account.AccountLedgerFactory;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.services.account.AccountService;

/**
 *
 * @author carlos
 */
public class AccountServiceTest {

    private static Long accountId;
    private AccountService accountService;
    private static ApplicationContext ctx;

    public AccountServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/vault/infrastructure/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void createAccount01() {
        accountService = (AccountService) ctx.getBean("accountService");
        Account account = new AccountFactory.Builder("69962365489", "115544").accountType("savings").balance(BigDecimal.valueOf(5000)).build();
        accountService.persist(account);
        accountId = account.getId();
        Assert.assertNotNull(account.getId());
    }

    @Test
    public void testLegerAmout02() {
        accountService = (AccountService) ctx.getBean("accountService");
        Account acc = accountService.find(accountId);
        System.out.println(" THE LEDGER VALUE " + acc.getEntries().size());
        AccountLedger entry1 = new AccountLedgerFactory.Builder(new Date(), "Credit The Account").credit(new BigDecimal(200.00)).
                debit(new BigDecimal(300.00)).build();

        AccountLedger entry2 = new AccountLedgerFactory.Builder(new Date(), "Credit The Account").credit(new BigDecimal(100.00)).
                debit(new BigDecimal(300.00)).build();

        acc.getEntries().add(entry1);
        acc.getEntries().add(entry2);

        accountService.merge(acc);
        Account newacc = accountService.find(accountId);

        System.out.println(" THE NEW BALANCE " + newacc.getBalance());

    }

    @Test
    public void testRead03() {
        accountService = (AccountService) ctx.getBean("accountService");
        Account acc = accountService.find(accountId);
        Assert.assertEquals("savings", acc.getAccountType());
    }

    @Test
    public void testUpdate04() {
        accountService = (AccountService) ctx.getBean("accountService");
        Account acc = accountService.find(accountId);
        acc.setAccountType("CHECK");
        accountService.merge(acc);
        Account account = accountService.find(accountId);
        Assert.assertEquals("115544", account.getPinNumber());
    }

    @Test
    public void testCount05() {
        accountService = (AccountService) ctx.getBean("accountService");
        Long count = accountService.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList06() {
        accountService = (AccountService) ctx.getBean("accountService");
        List<Account> acc = accountService.findAll();
        Assert.assertTrue(acc.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        accountService = (AccountService) ctx.getBean("accountService");
        Account role = accountService.getByPropertyName("pinNumber", "115544");
        Assert.assertEquals("115544", role.getPinNumber());

    }

    @Test
    public void testDelete08() {
        accountService = (AccountService) ctx.getBean("accountService");
        Account account = accountService.find(accountId);
        accountService.remove(account);
        Account acc = accountService.find(accountId);
        Assert.assertNull(acc);
    }
}
