package rs.engineering.javacourse.myspringmvcapp.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * ne koristim vise,  @ControllerAdvice klasa sada to radi
 */
//@Component
public class MyGlobalExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		System.out.println("====== MyGlobalExceptionHandler ==========================");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/globalException");
		modelAndView.addObject("errorObj", ex);
		modelAndView.addObject("errorMessage", ex.getMessage());

		return modelAndView;
	}

}
