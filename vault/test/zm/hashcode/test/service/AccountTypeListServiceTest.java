/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

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
import zm.hashcode.vault.services.metadata.AccountTypeListService;

/**
 *
 * @author carlos
 */
public class AccountTypeListServiceTest {

    private static Long accountTypeListId;
    private AccountTypeListService accountTypeListService;
    private static ApplicationContext ctx;

    public AccountTypeListServiceTest() {
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
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        AccountTypeList accTypeList = new AccountTypeListFactory.Builder("CHECK").build();
        accountTypeListService.persist(accTypeList);
        accountTypeListId = accTypeList.getId();
        Assert.assertNotNull(accTypeList.getId());
    }

    @Test
    public void testRead() {
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        AccountTypeList accTypeList = accountTypeListService.find(accountTypeListId);
        Assert.assertEquals("CHECK", accTypeList.getAccountType());
    }

    @Test
    public void testUpdate() {
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        AccountTypeList accTypeList = accountTypeListService.find(accountTypeListId);
        accTypeList.setAccountType("SAVINGS");
        accountTypeListService.merge(accTypeList);
        AccountTypeList accType = accountTypeListService.find(accountTypeListId);
        Assert.assertEquals("SAVINGS", accType.getAccountType());
    }

    @Test
    public void testCount() {
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        Long count = accountTypeListService.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        List<AccountTypeList> roles = accountTypeListService.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        AccountTypeList accTypeList = accountTypeListService.getByPropertyName("accountType", "SAVINGS");
        Assert.assertEquals("SAVINGS", accTypeList.getAccountType());

    }

    @Test
    public void testDelete() {
        accountTypeListService = (AccountTypeListService) ctx.getBean("accountTypeListService");
        AccountTypeList currency = accountTypeListService.find(accountTypeListId);
        accountTypeListService.remove(currency);
        AccountTypeList r = accountTypeListService.find(accountTypeListId);
        Assert.assertNull(r);

    }
}
