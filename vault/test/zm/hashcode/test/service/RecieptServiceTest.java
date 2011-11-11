/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import zm.hashcode.vault.infrastructure.factories.metadata.RecieptDetailFactory;
import zm.hashcode.vault.model.metadata.RecieptDetail;
import zm.hashcode.vault.services.Impl.RecieptDetailServiceImpl;
import zm.hashcode.vault.services.metadata.RecieptDetailService;
import zm.hashcode.vault.services.metadata.RecieptDetailService;

/**
 *
 * @author David
 */
public class RecieptServiceTest {
    private static Long recieptDetailId;
    private RecieptDetailService recieptDetailService;
    private static ApplicationContext ctx;
    public RecieptServiceTest() {
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
    public void createReciept100() {
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        String str = "1";
        Long bob = Long.parseLong(str);
        RecieptDetail reciept = new RecieptDetailFactory.Builder(123.12).Price(123.12).Qty(1).Rid(bob).Total(123.12).descript("hello").build();
        recieptDetailService.persist(reciept);
        recieptDetailId = reciept.getId();
        Assert.assertNotNull(reciept.getId());
    }

    @Test
    public void testRead200() {
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        RecieptDetail reciept = recieptDetailService.find(recieptDetailId);
        Assert.assertEquals(123.12, reciept.getPrice());
    }

    @Test
    public void testUpdate300() {
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        RecieptDetail recieptDetail = recieptDetailService.find(recieptDetailId);
        recieptDetail.setPrice(123.12);
        recieptDetailService.merge(recieptDetail);
        Assert.assertEquals(123.12, recieptDetail.getPrice());
    }

    @Test
    public void testCount400() {
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        Long count = recieptDetailService.count();
        Assert.assertEquals(new Long(0), count);
    }

    @Test
    public void testList500() {
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        List<RecieptDetail> roles = recieptDetailService.findAll();
        Assert.assertTrue(roles.size() >= 0);
    }

    @Test
    public void testGetByParamater600() {
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        RecieptDetail recieptDetail = recieptDetailService.getByPropertyName("descript", "hello");
        Assert.assertEquals("hello", recieptDetail.getDescript());

    }

    @Test
    public void testDelete700() {
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        RecieptDetail currency = recieptDetailService.find(recieptDetailId);
        recieptDetailService.remove(currency);
        RecieptDetail r = recieptDetailService.find(recieptDetailId);
        Assert.assertNull(r);
    }
    
    @Test
    public void testInsertRid(){
        recieptDetailService = (RecieptDetailService) ctx.getBean("recieptDetailService");
        RecieptDetail receipt = recieptDetailService.find(recieptDetailId);
        String str = "21";
        Long bob = Long.parseLong(str);
        receipt.setRid(bob);
        Assert.assertEquals(recieptDetailId, receipt.getRid());
    }
}