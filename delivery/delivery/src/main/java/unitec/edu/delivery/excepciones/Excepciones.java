package unitec.edu.delivery.excepciones;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Excepciones {
	
	@ExceptionHandler(Exception.class)
	public String excepcion() {
		return "redirect:./Error.jsp";
	}

}
