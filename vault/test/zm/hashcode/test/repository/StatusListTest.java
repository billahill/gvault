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
import zm.hashcode.vault.infrastructure.factories.metadata.StatusListFactory;
import zm.hashcode.vault.model.metadata.StatusList;
import zm.hashcode.vault.repository.jpa.metadata.StatusListDAO;

/**
 *
 * @author carlos
 */
public class StatusListTest {

    private static Long rolesId;
    private StatusListDAO statusListDAO;
    private static ApplicationContext ctx;

    public StatusListTest() {
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
        statusListDAO = (StatusListDAO) ctx.getBean("statusListDAO");
        StatusList status = new StatusListFactory.Builder("CURRENT").build();
        statusListDAO.persist(status);
        rolesId = status.getId();
        Assert.assertNotNull(status.getId());
    }

    @Test
    public void testRead() {
        statusListDAO = (StatusListDAO) ctx.getBean("statusListDAO");
        StatusList status = statusListDAO.find(rolesId);
        Assert.assertEquals("CURRENT", status.getStatus());
    }

    @Test
    public void testUpdate() {
        statusListDAO = (StatusListDAO) ctx.getBean("statusListDAO");
        StatusList statusList = statusListDAO.find(rolesId);
        statusList.setStatus("OLD");
        statusListDAO.merge(statusList);
        StatusList sta = statusListDAO.find(rolesId);
        Assert.assertEquals("OLD", sta.getStatus());
    }

    @Test
    public void testCount() {
        statusListDAO = (StatusListDAO) ctx.getBean("statusListDAO");
        Long count = statusListDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        statusListDAO = (StatusListDAO) ctx.getBean("statusListDAO");
        List<StatusList> roles = statusListDAO.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        statusListDAO = (StatusListDAO) ctx.getBean("statusListDAO");
        StatusList status = statusListDAO.getByPropertyName("status", "OLD");
        Assert.assertEquals("OLD", status.getStatus());

    }

    @Test
    public void testDelete() {
        statusListDAO = (StatusListDAO) ctx.getBean("statusListDAO");
        StatusList status = statusListDAO.find(rolesId);
        statusListDAO.remove(status);
        StatusList st = statusListDAO.find(rolesId);
        Assert.assertNull(st);

    }
}
