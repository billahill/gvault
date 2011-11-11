/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import zm.hashcode.vault.repository.jpa.product.ProductDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zm.hashcode.vault.infrastructure.factories.product.productFactory;
import zm.hashcode.vault.model.product.product;
/**
 *
 * @author Kraakbeen
 */
public class ProductTest {
    private static Long productId;
    private ProductDAO productDAO;
    private static ApplicationContext ctx;

    public ProductTest() {
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
    public void createProduct01() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        product pro = new productFactory.Builder("Marlboro","1122334455").description("Marlboro").barcode("1122334455").price(28.50).vat(true).priceIncl(30.50).qty(11).build();
        productDAO.persist(pro);
        productId = pro.getId();
       Assert.assertNotNull(pro.getId());
    }

    @Ignore
    public void testRead02() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        product Product = productDAO.find(productId);
         Assert.assertEquals("Marlboro Silver", Product.getDescription()); 

    }

    @Test
    public void testUpdate04() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        product Product = productDAO.find(productId);
        Product.setDescription("Marlboro Silver");
        productDAO.merge(Product);
        product newProduct = productDAO.find(productId);
        Assert.assertEquals("1122334455", newProduct.getBarcode());
    }

    @Test
    public void testCount05() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        Long count = productDAO.count();
        Assert.assertEquals(new Long(1), count);
    }
    @Test
    public void testList06() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        List<product> pro = productDAO.findAll();
        Assert.assertTrue(pro.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        product Pro = productDAO.getByPropertyName("description", "Marlboro Silver");
        Assert.assertEquals("1122334455", Pro.getBarcode());

    }

    @Ignore
    public void testDelete08() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        product Product = productDAO.find(productId);
        productDAO.remove(Product);
        product newProduct = productDAO.find(productId);
        Assert.assertNull(newProduct);
    }  
}
