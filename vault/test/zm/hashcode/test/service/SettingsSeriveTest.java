/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

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
import zm.hashcode.vault.model.parameters.settings;
import zm.hashcode.vault.services.parameters.SettingsService;

/**
 *
 * @author Kraakbeen
 */
public class SettingsSeriveTest {
private static Long settingsId;
    private SettingsService settingsService;
    private static ApplicationContext ctx;

    public SettingsSeriveTest() {
        
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
        settingsService = (SettingsService) ctx.getBean("settingsService");
        settings add = new settings();

        // Now Save the Object to the Dtabaase
        settingsService.persist(add);
        //Get back the ID for the saved Employee
        settingsId = add.getId();
//        //Assert to see if the Employee Object  was created and Saved Indeed
       Assert.assertNotNull(add.getId());
    }

    @Ignore
    public void testRead02() {
        settingsService = (SettingsService) ctx.getBean("settingsService");
        settings Settings = settingsService.find(settingsId);
         Assert.assertEquals(14, Settings.getVat()); 

    }

    @Test
    public void testUpdate04() {
        settingsService = (SettingsService) ctx.getBean("settingsService");
        settings Settings = settingsService.find(settingsId);
        Settings.setVat(14);
        settingsService.merge(Settings);
        settings NewSettings = settingsService.find(settingsId);
        Assert.assertEquals(14, NewSettings.getVat());
    }

    @Test
    public void testCount05() {
        settingsService = (SettingsService) ctx.getBean("settingsService");
        Long count = settingsService.count();
        Assert.assertEquals(new Long(1), count);
    }
    @Test
    public void testList06() {
        settingsService = (SettingsService) ctx.getBean("settingsService");
        List<settings> pro = settingsService.findAll();
        Assert.assertTrue(pro.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        settingsService = (SettingsService) ctx.getBean("settingsService");
        settings Pro = settingsService.getByPropertyName("vat", "14");
        Assert.assertEquals("14", Pro.getVat());

    }

    @Ignore
    public void testDelete08() {
        settingsService = (SettingsService) ctx.getBean("settingsService");
        settings Settings = settingsService.find(settingsId);
        settingsService.remove(Settings);
        settings Newsettings = settingsService.find(settingsId);
        Assert.assertNull(Newsettings);
    }    
}
