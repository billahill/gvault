/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import zm.hashcode.vault.infrastructure.factories.metadata.AccountTypeListFactory;
import zm.hashcode.vault.model.metadata.AccountTypeList;
import zm.hashcode.vault.repository.jpa.metadata.AccountTypeListDAO;

/**
 *
 * @author carlos
 */
public class AccountTypeListTest {

    private static Long accountTypeListId;
    private AccountTypeListDAO accountTypeListDAO;
    private static ApplicationContext ctx;

    public AccountTypeListTest() {
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
    public void createAccountType() {
        accountTypeListDAO = (AccountTypeListDAO) ctx.getBean("accountTypeListDAO");
        AccountTypeList accTypeList = new AccountTypeListFactory.Builder("CHECK").build();
        accountTypeListDAO.persist(accTypeList);
        accountTypeListId = accTypeList.getId();
        Assert.assertNotNull(accTypeList.getId());
    }

    @Test
    public void testRead() {
        accountTypeListDAO = (AccountTypeListDAO) ctx.getBean("accountTypeListDAO");
        AccountTypeList accTypeList = accountTypeListDAO.find(accountTypeListId);
        Assert.assertEquals("CHECK", accTypeList.getAccountType());
    }

    @Test
    public void testUpdate() {
        accountTypeListDAO = (AccountTypeListDAO) ctx.getBean("accountTypeListDAO");
        AccountTypeList accTypeList = accountTypeListDAO.find(accountTypeListId);
        accTypeList.setAccountType("SAVINGS");
        accountTypeListDAO.merge(accTypeList);
        AccountTypeList accType = accountTypeListDAO.find(accountTypeListId);
        Assert.assertEquals("SAVINGS", accType.getAccountType());
    }

    @Test
    public void testCount() {
        accountTypeListDAO = (AccountTypeListDAO) ctx.getBean("accountTypeListDAO");
        Long count = accountTypeListDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        accountTypeListDAO = (AccountTypeListDAO) ctx.getBean("accountTypeListDAO");
        List<AccountTypeList> roles = accountTypeListDAO.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        accountTypeListDAO = (AccountTypeListDAO) ctx.getBean("accountTypeListDAO");
        AccountTypeList accTypeList = accountTypeListDAO.getByPropertyName("accountType", "SAVINGS");
        Assert.assertEquals("SAVINGS", accTypeList.getAccountType());

    }

    @Test
    public void testDelete() {
        accountTypeListDAO = (AccountTypeListDAO) ctx.getBean("accountTypeListDAO");
        AccountTypeList currency = accountTypeListDAO.find(accountTypeListId);
        accountTypeListDAO.remove(currency);
        AccountTypeList r = accountTypeListDAO.find(accountTypeListId);
        Assert.assertNull(r);

    }
}
