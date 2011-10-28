/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.client.mobile.springmvc;



/**
 *
 * @author Carlos
 */

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
 
public class HomeController extends AbstractController {
 
 
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
		String aMessage = "Hello World MVC!";
 
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", aMessage);
 
		return modelAndView;
    }
}