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
import zm.hashcode.vault.infrastructure.factories.metadata.CurrencyListFactory;
import zm.hashcode.vault.model.metadata.CurrencyList;
import zm.hashcode.vault.services.metadata.CurrencyListService;

/**
 *
 * @author carlos
 */
public class CurrencyTypeListServiceTest {

    private static Long currencyListId;
    private CurrencyListService currencyListService;
    private static ApplicationContext ctx;

    public CurrencyTypeListServiceTest() {
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
    public void createCurrency() {
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        CurrencyList currency = new CurrencyListFactory.Builder("Rand", "R").currencyCode("02").currencyShortCode("45").build();
        currencyListService.persist(currency);
        currencyListId = currency.getId();
        Assert.assertNotNull(currency.getId());
    }

    @Test
    public void testRead() {
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        CurrencyList currency = currencyListService.find(currencyListId);
        Assert.assertEquals("R", currency.getCurrencySymbol());
    }

    @Test
    public void testUpdate() {
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        CurrencyList currency = currencyListService.find(currencyListId);
        currency.setCurrencyName("Dollar");
        currency.setCurrencySymbol("$");
        currencyListService.merge(currency);
        CurrencyList r = currencyListService.find(currencyListId);
        Assert.assertEquals("02", r.getCurrencyCode());
    }

    @Test
    public void testCount() {
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        Long count = currencyListService.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        List<CurrencyList> roles = currencyListService.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        CurrencyList currency = currencyListService.getByPropertyName("currencyName", "Dollar");
        Assert.assertEquals("02", currency.getCurrencyCode());

    }

    @Test
    public void testDelete() {
        currencyListService = (CurrencyListService) ctx.getBean("currencyListService");
        CurrencyList currency = currencyListService.find(currencyListId);
        currencyListService.remove(currency);
        CurrencyList r = currencyListService.find(currencyListId);
        Assert.assertNull(r);

    }
}
