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
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import zm.hashcode.vault.model.product.product;
import zm.hashcode.vault.infrastructure.factories.product.productFactory;
import zm.hashcode.vault.services.product.ProductService;
/**
 *
 * @author Kraakbeen
 */

public class ProductServiceTest {
    private static Long productId;
    private ProductService productService;
    private static ApplicationContext ctx;

    public ProductServiceTest() {
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
    public void createProduct01() {
        productService = (ProductService) ctx.getBean("productService");
        product pro = new productFactory.Builder("Marlboro", "1122334455").description("Marlboro").price(28.50).vat(true).priceIncl(30.50).barcode("1122334455").qty(11).build();
       
        productService.persist(pro);
        productId = pro.getId();
        Assert.assertNotNull(pro.getId());
    }

    @Test
    public void testRead02() {
        productService = (ProductService) ctx.getBean("productService");
        product Product = productService.find(productId);
        Assert.assertEquals("Marlboro", Product.getDescription());
    }

    @Test
    public void testUpdate04() {
        productService = (ProductService) ctx.getBean("productService");
        product Product = productService.find(productId);
        Product.setDescription("Marlboro Silver");
        productService.merge(Product);
        product newProduct = productService.find(productId);
        Assert.assertEquals("1122334455", newProduct.getBarcode());
    }

    @Test
    public void testCount05() {
        productService = (ProductService) ctx.getBean("productService");
        Long count = productService.count();
        Assert.assertEquals(new Long(1), count);
    }
    
        @Test
    public void testList06() {
        productService = (ProductService) ctx.getBean("productService");
        List<product> pro = productService.findAll();
        Assert.assertTrue(pro.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        productService = (ProductService) ctx.getBean("productService");
        product Pro = productService.getByPropertyName("description", "Marlboro");
        Assert.assertEquals("1122334455", Pro.getBarcode());
    }

    @Ignore
    public void testDelete08() {
        productService = (ProductService) ctx.getBean("productService");
        product Product = productService.find(productId);
        productService.remove(Product);
        product newProduct = productService.find(productId);
        Assert.assertNull(newProduct);
    }  
}
