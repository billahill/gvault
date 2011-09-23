/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zm.hashcode.vault.model.people.Users;
import zm.hashcode.vault.services.purchase.PurchaseService;

/**
 *
 * @author carlos
 */
public class PurchaseServiceTest {
    private PurchaseService purchaseService;
    private static ApplicationContext ctx;
    public PurchaseServiceTest() {
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
    public void getStudentInfoTest01() {
        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
        Users user = new Users();
        user = (Users) purchaseService.getStudentInfo("carlos@john.com");
        System.out.println("User Details: \n" + "First Name: " + user.getName().getFirstname() + "\n" + "Last Name: "+
                user.getName().getLastname() + "\n" + "Account Number: " + user.getAccount().getAccountNumber());
        
    }
    @Test
    public void verifyPinTest02(){
        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
       // boolean pin = purchaseService.verifyPin("carlos@john.com", "115544");
        System.out.println("--------TESTING VERIFYPIN---------");
//        if(pin==true)
//            System.out.println("\nCorrect pin");
//        else
//            System.out.println("\nIncorrect pin");
    }
    @Test
    public void checkBalance03(){
        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
        System.out.println("\n--------TESTING CHECKBALANCE---------\n");
        String acc = "07313013948";
        BigDecimal amount = new BigDecimal("3000");
       String balance = (String)purchaseService.checkBalance(amount, "fernandoneto@gmail.com");
        if(balance.equals("You have enough funds")){
            System.out.println("Enough money");
        }else{
            System.out.println("Get some money you are broke nigga!!");
        }
        
    }
    @Test
    public void getBalance04(){
        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
        System.out.println("\n--------TESTING GETBALANCE---------\n");
        BigDecimal balance = purchaseService.getBalance("fernandoneto@gmail.com");
        System.out.println(balance.toString());
    }
    
}
