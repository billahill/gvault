/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.vault.infrastructure.factories.people.UsersFactory;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.services.people.UsersService;
import zm.hashcode.vault.services.purchase.AdminService;
import zm.hashcode.vault.services.purchase.PurchaseService;

/**
 *
 * @author carlos
 */
public class AdminServiceTest {

    private Long userId;
    private AdminService adminService;
    private static ApplicationContext ctx;
    private PurchaseService purchaseService;
    private UsersService userService;

    public AdminServiceTest() {
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
    public void loadCredit() {
        adminService = (AdminService) ctx.getBean("adminService");
//        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
//        adminService.loadCredit(new BigDecimal(400), "carlos@john.com");
//        adminService.loadCredit(new BigDecimal(400), "carlos@john.com");
        Users user = purchaseService.getStudentInfo("carlos@john.com");
        System.out.println("User Details: \n" + "First Name: " + user.getName().getFirstname() + "\n" + "Last Name: "
                + user.getName().getLastname() + "\n" + "Account Number: " + user.getAccount().getAccountNumber() + "\n"
                + user.getAccount().getBalance().toString());
    }

    @Ignore
    public void createUserTest() {
        adminService = (AdminService) ctx.getBean("adminService");
        userService = (UsersService) ctx.getBean("usersService");
         Users user = new UsersFactory.Builder("Louis", "Lisandro").addressStatus("CURRENT").cellNumber("0867337373").
                contactStatus("CURRENT").emailAddress("donotknow@gmail.com").
                faxNumber("0218938393").otherName("Lukas").
                phoneNumber("921921912").physicalAddress("20 Chanda Mali Close").postalAddress("P.O.Box 23487").postalcode("7654").
                rolename("ADMIN").title("MR").username("louis@john.com").enabled(true).build();
        adminService.createUser(user);
        Users r = userService.getByPropertyName("username", "louis@john.com");
        Long cuserId = r.getId();
        Users u = userService.find(cuserId);
        Assert.assertNotNull(r.getId());
    }

    @Ignore
    public void disableUserTest() {
        adminService = (AdminService) ctx.getBean("adminService");
        userService = (UsersService) ctx.getBean("usersService");
        Users user = userService.getByPropertyName("username", "billahill@gmail.com");
        user.setEnabled(false);
        adminService.disableUser(user);
        Long DuserId = user.getId();
        Users u = userService.find(DuserId);
        Assert.assertEquals("billahill@gmail.com", u.getUsername());
    }
    @Ignore
    public void enableUserTest() {
        adminService = (AdminService) ctx.getBean("adminService");
        userService = (UsersService) ctx.getBean("usersService");
        Users user = userService.getByPropertyName("username", "billahill@gmail.com");
        user.setEnabled(true);
        adminService.disableUser(user);
        Long DuserId = user.getId();
        Users u = userService.find(DuserId);
        Assert.assertEquals("billahill@gmail.com", u.getUsername());
    }
}
