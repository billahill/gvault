/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.util.List;
import zm.hashcode.vault.infrastructure.factories.metadata.RecieptFactory;
import zm.hashcode.vault.model.metadata.Reciept;
import org.springframework.context.ApplicationContext;
import zm.hashcode.vault.repository.jpa.metadata.RecieptDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author David
 */
public class ReceiptTest {
    private static Long recieptId;
    private RecieptDAO recieptDAO;
    private static ApplicationContext ctx;
    public ReceiptTest() {
        
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

    @Test
    public void createReciept100() {
        recieptDAO = (RecieptDAO) ctx.getBean("recieptDAO");
        Reciept reciept = new RecieptFactory.Builder(123.12).build();
        recieptDAO.persist(reciept);
        recieptId = reciept.getId();
        Assert.assertNotNull(reciept.getId());
    }

    @Test
    public void testRead200() {
        recieptDAO = (RecieptDAO) ctx.getBean("recieptDAO");
        Reciept reciept = recieptDAO.find(recieptId);
        Assert.assertEquals(123.12, reciept.getPrice());
    }

    @Test
    public void testUpdate300() {
        recieptDAO = (RecieptDAO) ctx.getBean("recieptDAO");
        Reciept reciept = recieptDAO.find(recieptId);
        reciept.setPrice(123.12);
        recieptDAO.merge(reciept);
        Reciept accType = recieptDAO.find(recieptId);
        Assert.assertEquals(123.12, reciept.getPrice());
    }

    @Test
    public void testCount400() {
        recieptDAO = (RecieptDAO) ctx.getBean("recieptDAO");
        Long count = recieptDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList500() {
        recieptDAO = (RecieptDAO) ctx.getBean("recieptDAO");
        List<Reciept> roles = recieptDAO.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void testGetByParamater600() {
        recieptDAO = (RecieptDAO) ctx.getBean("recieptDAO");
        Reciept Reciept = recieptDAO.getByPropertyName("reciept", "SAVINGS");
        Assert.assertEquals(123.12, Reciept.getPrice());

    }

    @Test
    public void testDelete700() {
        recieptDAO = (RecieptDAO) ctx.getBean("recieptDAO");
        Reciept currency = recieptDAO.find(recieptId);
        recieptDAO.remove(currency);
        Reciept r = recieptDAO.find(recieptId);
        Assert.assertNull(r);

    }
}