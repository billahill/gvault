/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.vault.infrastructure.factories.account.AccountFactory;
import zm.hashcode.vault.infrastructure.factories.people.UsersFactory;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.services.people.UsersService;

/**
 *
 * @author boniface
 */

public class UsersServiceTest {

    private static Long usersId;
    private UsersService usersService;
    private static ApplicationContext ctx;

    public UsersServiceTest() {
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
    public void createUser01() {
        usersService = (UsersService) ctx.getBean("usersService");
        Users user = new UsersFactory.Builder("John", "Banda").addressStatus("CURRENT").cellNumber("0867337373").
                contactStatus("CURRENT").emailAddress("current@gmail.com").
                faxNumber("0218938393").otherName("Lukas").
                phoneNumber("921921912").physicalAddress("20 Chanda Mali Close").postalAddress("P.O.Box 23487").postalcode("7654").
                rolename("ADMIN").title("MR").username("carlos@john.com").enabled(true).password("lala").build();
         Account account = new AccountFactory.Builder("07213013948", "115544").accountType("savings").build();
        user.setAccount(account);
        usersService.persist(user);
        usersId = user.getId();
        Assert.assertNotNull(user.getId());

    }

    @Ignore
    public void createAccount02() {
        usersService = (UsersService) ctx.getBean("usersService");
        Users user = usersService.find(usersId);
        Account account = new AccountFactory.Builder("0721345687", "115544").accountType("savings").build();
        user.setAccount(account);
        usersService.merge(user);
        Users u = usersService.find(usersId);
        System.out.println("Users Number : " + u.getAccount().getAccountNumber());

    }
    @Test
    public void testRead03() {
        usersService = (UsersService) ctx.getBean("usersService");
        Users users = usersService.find(usersId);
        Assert.assertEquals("John", users.getName().getFirstname());
    }

    @Test
    public void testUpdate04() {
        usersService = (UsersService) ctx.getBean("usersService");
        Users user = usersService.find(usersId);
        user.getName().setLastname("Louis");
        usersService.merge(user);
        Users u = usersService.find(usersId);
        System.out.println("User Last Name: " + u.getName().getLastname());
        Assert.assertEquals("John", u.getName().getFirstname());
    }

    @Test
    public void testCount05() {
        usersService = (UsersService) ctx.getBean("usersService");
        Long count = usersService.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList06() {
        usersService = (UsersService) ctx.getBean("usersService");
        List<Users> u = usersService.findAll();
        Assert.assertTrue(u.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        usersService = (UsersService) ctx.getBean("usersService");
        Users u = usersService.getByPropertyName("username", "carlos@john.com");
        Assert.assertEquals("Louis", u.getName().getLastname());

    }

    @Test
    public void testDelete08() {
        usersService = (UsersService) ctx.getBean("usersService");
        Users users = usersService.find(usersId);
        usersService.remove(users);
        Users user = usersService.find(usersId);
        Assert.assertNull(user);

    }

   
}
