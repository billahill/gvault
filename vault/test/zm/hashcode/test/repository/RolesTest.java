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
import zm.hashcode.vault.infrastructure.factories.people.RolesFactory;
import zm.hashcode.vault.model.people.Roles;
import zm.hashcode.vault.repository.jpa.people.RolesDAO;

/**
 *
 * @author carlos
 */
public class RolesTest {

    private static Long rolesId;
    private RolesDAO rolesDAO;
    private static ApplicationContext ctx;

    public RolesTest() {
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
    public void createRole() {
        rolesDAO = (RolesDAO) ctx.getBean("rolesDAO");
        Roles role = new RolesFactory.Builder("user@roles.com", "ADMIN").build();
        rolesDAO.persist(role);
        rolesId = role.getId();
        Assert.assertNotNull(role.getId());
    }

    @Test
    public void testRead() {
        rolesDAO = (RolesDAO) ctx.getBean("rolesDAO");
        Roles role = rolesDAO.find(rolesId);
        Assert.assertEquals("ADMIN", role.getRolename());
    }

    @Test
    public void testUpdate() {
        rolesDAO = (RolesDAO) ctx.getBean("rolesDAO");
        Roles role = rolesDAO.find(rolesId);
        role.setRolename("STUDENT");
        rolesDAO.merge(role);
        Roles r = rolesDAO.find(rolesId);
        Assert.assertEquals("user@roles.com", r.getUsername());
    }

    @Test
    public void testCount() {
        rolesDAO = (RolesDAO) ctx.getBean("rolesDAO");
        Long count = rolesDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        rolesDAO = (RolesDAO) ctx.getBean("rolesDAO");
        List<Roles> roles = rolesDAO.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        rolesDAO = (RolesDAO) ctx.getBean("rolesDAO");
        Roles role = rolesDAO.getByPropertyName("username", "user@roles.com");
        Assert.assertEquals("STUDENT", role.getRolename());

    }

    @Test
    public void testDelete() {
        rolesDAO = (RolesDAO) ctx.getBean("rolesDAO");
        Roles role = rolesDAO.find(rolesId);
        rolesDAO.remove(role);
        Roles r = rolesDAO.find(rolesId);
        Assert.assertNull(r);

    }
}
