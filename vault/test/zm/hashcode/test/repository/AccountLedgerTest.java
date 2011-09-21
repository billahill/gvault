/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.util.Date;
import java.math.BigDecimal;
import junit.framework.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.vault.repository.jpa.account.AccountLedgerDAO;
import org.springframework.context.ApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zm.hashcode.vault.infrastructure.factories.account.AccountLedgerFactory;
import zm.hashcode.vault.model.account.AccountLedger;
import static org.junit.Assert.*;

/**
 *
 * @author carlos
 */
public class AccountLedgerTest {

    private static Long accountLedgerId;
    private AccountLedgerDAO accountLedgerDAO;
    private static ApplicationContext ctx;

    public AccountLedgerTest() {
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
     public void createAccountLedger() {
         accountLedgerDAO =(AccountLedgerDAO) ctx.getBean("accountLedgerDAO");
         AccountLedger accountLedger = new AccountLedgerFactory.Builder(new Date(), "Chocolate").
                 debit(BigDecimal.valueOf(45)).balance(BigDecimal.valueOf(4955)).build();
         accountLedgerDAO.persist(accountLedger);
         Assert.assertNotNull(accountLedger.getId());
     }
}
