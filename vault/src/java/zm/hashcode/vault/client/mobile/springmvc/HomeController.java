/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.mobile.springmvc;



/**
 *
 * @author Carlos
 */

 
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import zm.hashcode.vault.app.data.ClientDataService;
import zm.hashcode.vault.model.people.Users;
 
public class HomeController extends AbstractController {
    private ClientDataService data;
 
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
                //List<Users> users = data.getUsersService().findAll();
                String firstname="Couldn't find user";
//                for (Users u : users) {
//                    if(u.getUsername().equals("carlos@john.com")){
//                        firstname = u.getName().getFirstname();
//                    }
//        }
		
 
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", firstname);
 
		return modelAndView;
    }
}