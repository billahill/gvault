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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.vault.model.parameters.settings;
import zm.hashcode.vault.repository.jpa.parameters.SettingsDAO;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Kraakbeen
 */
public class SettingsTest {
    private static Long settingsId;
    private SettingsDAO settingsDAO;
    private static ApplicationContext ctx;

    public SettingsTest() {
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
        settingsDAO = (SettingsDAO) ctx.getBean("settingsDAO");
        settings add = new settings();

        // Now Save the Object to the Dtabaase
        settingsDAO.persist(add);
        //Get back the ID for the saved Employee
        settingsId = add.getId();
//        //Assert to see if the Employee Object  was created and Saved Indeed
       Assert.assertNotNull(add.getId());
    }

    @Ignore
    public void testRead02() {
        settingsDAO = (SettingsDAO) ctx.getBean("settingsDAO");
        settings Settings = settingsDAO.find(settingsId);
         Assert.assertEquals(14, Settings.getVat()); 

    }

    @Test
    public void testUpdate04() {
        settingsDAO = (SettingsDAO) ctx.getBean("settingsDAO");
        settings Settings = settingsDAO.find(settingsId);
        Settings.setVat(14);
        settingsDAO.merge(Settings);
        settings NewSettings = settingsDAO.find(settingsId);
        Assert.assertEquals(14, NewSettings.getVat());
    }

    @Test
    public void testCount05() {
        settingsDAO = (SettingsDAO) ctx.getBean("settingsDAO");
        Long count = settingsDAO.count();
        Assert.assertEquals(new Long(1), count);
    }
    @Test
    public void testList06() {
        settingsDAO = (SettingsDAO) ctx.getBean("settingsDAO");
        List<settings> pro = settingsDAO.findAll();
        Assert.assertTrue(pro.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        settingsDAO = (SettingsDAO) ctx.getBean("settingsDAO");
        settings Pro = settingsDAO.getByPropertyName("vat", "14");
        Assert.assertEquals(14, Pro.getVat());

    }

    @Ignore
    public void testDelete08() {
        settingsDAO = (SettingsDAO) ctx.getBean("settingsDAO");
        settings Settings = settingsDAO.find(settingsId);
        settingsDAO.remove(Settings);
        settings Newsettings = settingsDAO.find(settingsId);
        Assert.assertNull(Newsettings);
    }    
}
