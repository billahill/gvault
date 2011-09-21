/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.vault.infrastructure.factories.account.AccountFactory;
import zm.hashcode.vault.infrastructure.factories.account.AccountLedgerFactory;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.repository.jpa.account.AccountDAO;

/**
 *
 * @author carlos
 */
public class AccountTest {

    private static Long accountId;
    private AccountDAO accountDAO;
    private static ApplicationContext ctx;

    public AccountTest() {
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
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account account = new AccountFactory.Builder("99962365489", "115544").accountType("savings").balance(BigDecimal.valueOf(5000)).build();
        accountDAO.persist(account);
        accountId = account.getId();
        Assert.assertNotNull(account.getId());
    }

    @Ignore
    public void testLegerAmout02() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account acc = accountDAO.find(accountId);
        System.out.println(" THE LEDGER VALUE " + acc.getEntries().size());
        AccountLedger entry1 = new AccountLedgerFactory.Builder(new Date(), "Credit The Account").credit(new BigDecimal(200.00)).
                debit(new BigDecimal(300.00)).build();

        AccountLedger entry2 = new AccountLedgerFactory.Builder(new Date(), "Credit The Account").credit(new BigDecimal(100.00)).
                debit(new BigDecimal(300.00)).build();

        acc.getEntries().add(entry1);
        acc.getEntries().add(entry2);

        accountDAO.merge(acc);
        Account newacc = accountDAO.find(accountId);

        System.out.println(" THE NEW BALANCE " + newacc.getBalance());

    }
    @Test
    public void testBalance(){
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account acc = accountDAO.find(accountId);
        String am = acc.getBalance().toString();
        System.out.println("This is the balance: " + am.toString());
    }

    @Test
    public void testRead03() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account acc = accountDAO.find(accountId);
        Assert.assertEquals("savings", acc.getAccountType());
    }

    @Test
    public void testUpdate04() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account acc = accountDAO.find(accountId);
        acc.setAccountType("CHECK");
        accountDAO.merge(acc);
        Account account = accountDAO.find(accountId);
        Assert.assertEquals("115544", account.getPinNumber());
    }

    @Test
    public void testCount05() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Long count = accountDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList06() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        List<Account> acc = accountDAO.findAll();
        Assert.assertTrue(acc.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account role = accountDAO.getByPropertyName("pinNumber", "115544");
        Assert.assertEquals("115544", role.getPinNumber());

    }

    @Test
    public void testDelete08() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account account = accountDAO.find(accountId);
        accountDAO.remove(account);
        Account acc = accountDAO.find(accountId);
        Assert.assertNull(acc);

    }
}
