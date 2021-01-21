package exception_old;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllers implements ErrorController{

 
//    @RequestMapping("/error")
//    public String handleError() {
//        return "error.html";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }   

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
	
	//@Override
    public String getErrorPath() {
		
		return "/error";
    }
	
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
    	String errorPage = "error";
		String pageTitle = "Error";
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				pageTitle = "Page not found";
				errorPage = "/error/404";
				
				LOGGER.error("Error 404");
			}
		}
		
		model.addAttribute("pageTitle", pageTitle);
        return errorPage;
    }

    
}
