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
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import zm.hashcode.vault.infrastructure.factories.metadata.RolesListFactory;
import zm.hashcode.vault.model.metadata.RolesList;
import zm.hashcode.vault.services.metadata.RolesListService;

/**
 *
 * @author carlos
 */
public class RolesListServiceTest {

    private static Long rolesListId;
    private RolesListService rolesListService;
    private static ApplicationContext ctx;

    public RolesListServiceTest() {
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
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        RolesList role = new RolesListFactory.Builder("STUDENT").build();
        rolesListService.persist(role);
        rolesListId = role.getId();
        Assert.assertNotNull(role.getId());
    }

    @Test
    public void testRead() {
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        RolesList role = rolesListService.find(rolesListId);
        Assert.assertEquals("STUDENT", role.getRolename());
    }

    @Test
    public void testUpdate() {
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        RolesList role = rolesListService.find(rolesListId);
        role.setRolename("ADMIN");
        rolesListService.merge(role);
        RolesList r = rolesListService.find(rolesListId);
        Assert.assertEquals("ADMIN", r.getRolename());
    }

    @Test
    public void testCount() {
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        Long count = rolesListService.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        List<RolesList> roles = rolesListService.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        RolesList role = rolesListService.getByPropertyName("rolename", "ADMIN");
        Assert.assertEquals("ADMIN", role.getRolename());

    }

    @Test
    public void testDelete() {
        rolesListService = (RolesListService) ctx.getBean("rolesListService");
        RolesList role = rolesListService.find(rolesListId);
        rolesListService.remove(role);
        RolesList r = rolesListService.find(rolesListId);
        Assert.assertNull(r);

    }
}
