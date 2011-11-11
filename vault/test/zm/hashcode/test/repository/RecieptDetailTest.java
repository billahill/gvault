/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import org.junit.Ignore;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import org.springframework.context.ApplicationContext;
import junit.framework.Assert;
import zm.hashcode.vault.model.metadata.RecieptDetail;
import zm.hashcode.vault.infrastructure.factories.metadata.RecieptDetailFactory;
import zm.hashcode.vault.repository.jpa.metadata.RecieptDetailDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author David
 */
public class RecieptDetailTest {

    private static Long recieptDetailId;
    private RecieptDetailDAO recieptDetailDAO;
    private static ApplicationContext ctx;

    public RecieptDetailTest() {
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
    // @Test
    // public void hello() {}

    @Test
    public void createReciept100() {
        recieptDetailDAO = (RecieptDetailDAO) ctx.getBean("recieptDetailDAO");
        String str = "1";
        Long bob = Long.parseLong(str);
        RecieptDetail reciept = new RecieptDetailFactory.Builder(123.12).Price(123.12).Qty(1).Rid(bob).Total(123.12).descript("hello").build();
        recieptDetailDAO.persist(reciept);
        recieptDetailId = reciept.getId();
        Assert.assertNotNull(reciept.getId());
    }

    @Test
    public void testRead200() {
        recieptDetailDAO = (RecieptDetailDAO) ctx.getBean("recieptDetailDAO");
        RecieptDetail reciept = recieptDetailDAO.find(recieptDetailId);
        Assert.assertEquals(123.12, reciept.getPrice());
    }

    @Test
    public void testUpdate300() {
        recieptDetailDAO = (RecieptDetailDAO) ctx.getBean("recieptDetailDAO");
        RecieptDetail recieptDetail = recieptDetailDAO.find(recieptDetailId);
        recieptDetail.setPrice(123.12);
        recieptDetailDAO.merge(recieptDetail);
        Assert.assertEquals(123.12, recieptDetail.getPrice());
    }

    @Test
    public void testCount400() {
        recieptDetailDAO = (RecieptDetailDAO) ctx.getBean("recieptDetailDAO");
        Long count = recieptDetailDAO.count();
        Assert.assertEquals(new Long(0), count);
    }

    @Test
    public void testList500() {
        recieptDetailDAO = (RecieptDetailDAO) ctx.getBean("recieptDetailDAO");
        List<RecieptDetail> roles = recieptDetailDAO.findAll();
        Assert.assertTrue(roles.size() >= 0);
    }

    @Test
    public void testGetByParamater600() {
        recieptDetailDAO = (RecieptDetailDAO) ctx.getBean("recieptDetailDAO");
        RecieptDetail recieptDetail = recieptDetailDAO.getByPropertyName("descript", "hello");
        Assert.assertEquals("hello", recieptDetail.getDescript());

    }

    @Test
    public void testDelete700() {
        recieptDetailDAO = (RecieptDetailDAO) ctx.getBean("recieptDetailDAO");
        RecieptDetail currency = recieptDetailDAO.find(recieptDetailId);
        recieptDetailDAO.remove(currency);
        RecieptDetail r = recieptDetailDAO.find(recieptDetailId);
        Assert.assertNull(r);

    }
}
