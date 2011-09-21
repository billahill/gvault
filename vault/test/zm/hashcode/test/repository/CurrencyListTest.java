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
import zm.hashcode.vault.infrastructure.factories.metadata.CurrencyListFactory;
import zm.hashcode.vault.model.metadata.CurrencyList;
import zm.hashcode.vault.repository.jpa.metadata.CurrencyListDAO;

/**
 *
 * @author carlos
 */
public class CurrencyListTest {

    private static Long currencyListId;
    private CurrencyListDAO currencyListDAO;
    private static ApplicationContext ctx;

    public CurrencyListTest() {
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
        currencyListDAO = (CurrencyListDAO) ctx.getBean("currencyListDAO");
        CurrencyList currency = new CurrencyListFactory.Builder("Rand", "R").currencyCode("02").currencyShortCode("45").build();
        currencyListDAO.persist(currency);
        currencyListId = currency.getId();
        Assert.assertNotNull(currency.getId());
    }

    @Test
    public void testRead() {
        currencyListDAO = (CurrencyListDAO) ctx.getBean("currencyListDAO");
        CurrencyList currency = currencyListDAO.find(currencyListId);
        Assert.assertEquals("R", currency.getCurrencySymbol());
    }

    @Test
    public void testUpdate() {
        currencyListDAO = (CurrencyListDAO) ctx.getBean("currencyListDAO");
        CurrencyList currency = currencyListDAO.find(currencyListId);
        currency.setCurrencyName("Dollar");
        currency.setCurrencySymbol("$");
        currencyListDAO.merge(currency);
        CurrencyList r = currencyListDAO.find(currencyListId);
        Assert.assertEquals("02", r.getCurrencyCode());
    }

    @Test
    public void testCount() {
        currencyListDAO = (CurrencyListDAO) ctx.getBean("currencyListDAO");
        Long count = currencyListDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        currencyListDAO = (CurrencyListDAO) ctx.getBean("currencyListDAO");
        List<CurrencyList> roles = currencyListDAO.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        currencyListDAO = (CurrencyListDAO) ctx.getBean("currencyListDAO");
        CurrencyList currency = currencyListDAO.getByPropertyName("currencyName", "Dollar");
        Assert.assertEquals("02", currency.getCurrencyCode());

    }

    @Test
    public void testDelete() {
        currencyListDAO = (CurrencyListDAO) ctx.getBean("currencyListDAO");
        CurrencyList currency = currencyListDAO.find(currencyListId);
        currencyListDAO.remove(currency);
        CurrencyList r = currencyListDAO.find(currencyListId);
        Assert.assertNull(r);

    }
}
