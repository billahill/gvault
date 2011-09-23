/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.infrastructure.util;

import java.util.List;
import java.util.Random;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.model.people.Users;

/**
 *
 * @author Carlos
 */
public class GenerateAccountNumbers {

    private ClientDataService data = new ClientDataService();

    public GenerateAccountNumbers() {
    }

    public String getAccountNumber() {
        List<Users> users = data.getUsersService().findAll();
        String accountNumber = "";
        String finalAccountNumber = null;
        Random randomGenerator = new Random();
        for (int i = 0; i < 10; i++) {
            int randomInt = randomGenerator.nextInt(10);
            accountNumber += Integer.toString(randomInt);
        }
        finalAccountNumber = accountNumber;
        for (Users u : users) {
            if (accountNumber.equals(u.getAccount().getAccountNumber())) {
                finalAccountNumber = getAccountNumber();
                break;
            }
        }
        return finalAccountNumber;
    }
}
