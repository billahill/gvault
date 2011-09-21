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
import zm.hashcode.vault.infrastructure.factories.metadata.RolesListFactory;
import zm.hashcode.vault.model.metadata.RolesList;
import zm.hashcode.vault.repository.jpa.metadata.RolesListDAO;

/**
 *
 * @author carlos
 */
public class RolesListTest {

    private static Long rolesListId;
    private RolesListDAO rolesListDAO;
    private static ApplicationContext ctx;

    public RolesListTest() {
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
        rolesListDAO = (RolesListDAO) ctx.getBean("rolesListDAO");
        RolesList role = new RolesListFactory.Builder("STUDENT").build();
        rolesListDAO.persist(role);
        rolesListId = role.getId();
        Assert.assertNotNull(role.getId());
    }

    @Test
    public void testRead() {
        rolesListDAO = (RolesListDAO) ctx.getBean("rolesListDAO");
        RolesList role = rolesListDAO.find(rolesListId);
        Assert.assertEquals("STUDENT", role.getRolename());
    }

    @Test
    public void testUpdate() {
        rolesListDAO = (RolesListDAO) ctx.getBean("rolesListDAO");
        RolesList role = rolesListDAO.find(rolesListId);
        role.setRolename("ADMIN");
        rolesListDAO.merge(role);
        RolesList r = rolesListDAO.find(rolesListId);
        Assert.assertEquals("ADMIN", r.getRolename());
    }

    @Test
    public void testCount() {
        rolesListDAO = (RolesListDAO) ctx.getBean("rolesListDAO");
        Long count = rolesListDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        rolesListDAO = (RolesListDAO) ctx.getBean("rolesListDAO");
        List<RolesList> roles = rolesListDAO.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        rolesListDAO = (RolesListDAO) ctx.getBean("rolesListDAO");
        RolesList role = rolesListDAO.getByPropertyName("rolename", "ADMIN");
        Assert.assertEquals("ADMIN", role.getRolename());

    }

    @Test
    public void testDelete() {
        rolesListDAO = (RolesListDAO) ctx.getBean("rolesListDAO");
        RolesList role = rolesListDAO.find(rolesListId);
        rolesListDAO.remove(role);
        RolesList r = rolesListDAO.find(rolesListId);
        Assert.assertNull(r);

    }
}
