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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.vault.infrastructure.factories.account.AccountFactory;
import zm.hashcode.vault.infrastructure.factories.people.UsersFactory;
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.repository.jpa.people.UsersDAO;

/**
 *
 * @author boniface
 */
public class UsersTest {

    private static Long usersId;
    private UsersDAO usersDAO;
    private static ApplicationContext ctx;

    public UsersTest() {
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
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users user = new UsersFactory.Builder("Carlos", "Antonio").addressStatus("CURRENT").cellNumber("0867337373").
                contactStatus("CURRENT").emailAddress("current@gmail.com").
                faxNumber("0218938393").otherName("Lukas").
                phoneNumber("921921912").physicalAddress("20 Chanda Mali Close").postalAddress("P.O.Box 23487").postalcode("7654").
                rolename("STUDENT").title("MR").username("carlos@john.com").enabled(true).password("test123").build();
        Account account = new AccountFactory.Builder("07313013949", "115544").accountType("savings").build();
        user.setAccount(account);
        usersDAO.persist(user);
        usersId = user.getId();
        Assert.assertNotNull(user.getId());

    }

    @Ignore
    public void createAccount02() {
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users user = usersDAO.find(usersId);
        Account account = new AccountFactory.Builder("07313013948", "115544").accountType("savings").build();
        user.setAccount(account);
        usersDAO.merge(user);
        Users u = usersDAO.find(usersId);
        System.out.println("Users Number : " + u.getAccount().getAccountNumber());

    }

    @Test
    public void testRead03() {
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users users = usersDAO.find(usersId);
        Assert.assertEquals("John", users.getName().getFirstname());
    }

    @Test
    public void testUpdate04() {
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users user = usersDAO.find(usersId);
        user.getName().setLastname("Louis");
        usersDAO.merge(user);
        Users u = usersDAO.find(usersId);
        Assert.assertEquals("John", u.getName().getFirstname());
    }

    @Test
    public void testCount05() {
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        Long count = usersDAO.count();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    public void testList06() {
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        List<Users> u = usersDAO.findAll();
        Assert.assertTrue(u.size() > 0);
    }

    @Test
    public void tstGetByParamater07() {
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users u = usersDAO.getByPropertyName("username", "carlos@john.com");
        Assert.assertEquals("Louis", u.getName().getLastname());

    }

    @Ignore
    public void testDelete08() {
        usersDAO = (UsersDAO) ctx.getBean("usersDAO");
        Users users = usersDAO.find(usersId);
        usersDAO.remove(users);
        Users user = usersDAO.find(usersId);
        Assert.assertNull(user);

    }
}
