/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.mobile.springmvc;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/**
 *
 * @author Carlos
 */
public class LoginController extends AbstractController {
 
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

                String firstname="Couldn't find user";
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("message", firstname);

		return modelAndView;
    }
}
