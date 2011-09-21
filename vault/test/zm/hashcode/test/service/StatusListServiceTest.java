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
import zm.hashcode.vault.infrastructure.factories.metadata.StatusListFactory;
import zm.hashcode.vault.model.metadata.StatusList;
import zm.hashcode.vault.services.metadata.StatusListService;

/**
 *
 * @author carlos
 */
public class StatusListServiceTest {

    private static Long rolesId;
    private StatusListService statusListService;
    private static ApplicationContext ctx;

    public StatusListServiceTest() {
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
        statusListService = (StatusListService) ctx.getBean("statusListService");
        StatusList status = new StatusListFactory.Builder("CURRENT").build();
        statusListService.persist(status);
        rolesId = status.getId();
        Assert.assertNotNull(status.getId());
    }

    @Test
    public void testRead() {
        statusListService = (StatusListService) ctx.getBean("statusListService");
        StatusList status = statusListService.find(rolesId);
        Assert.assertEquals("CURRENT", status.getStatus());
    }

    @Test
    public void testUpdate() {
        statusListService = (StatusListService) ctx.getBean("statusListService");
        StatusList statusList = statusListService.find(rolesId);
        statusList.setStatus("OLD");
        statusListService.merge(statusList);
        StatusList sta = statusListService.find(rolesId);
        Assert.assertEquals("OLD", sta.getStatus());
    }

    @Test
    public void testCount() {
        statusListService = (StatusListService) ctx.getBean("statusListService");
        Long count = statusListService.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList() {
        statusListService = (StatusListService) ctx.getBean("statusListService");
        List<StatusList> roles = statusListService.findAll();
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void tstGetByParamater() {
        statusListService = (StatusListService) ctx.getBean("statusListService");
        StatusList status = statusListService.getByPropertyName("status", "OLD");
        Assert.assertEquals("OLD", status.getStatus());

    }

    @Test
    public void testDelete() {
        statusListService = (StatusListService) ctx.getBean("statusListService");
        StatusList status = statusListService.find(rolesId);
        statusListService.remove(status);
        StatusList st = statusListService.find(rolesId);
        Assert.assertNull(st);

    }
}

