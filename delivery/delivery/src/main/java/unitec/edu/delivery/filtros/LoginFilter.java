package unitec.edu.delivery.filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import unitec.edu.delivery.modelos.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@Component
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	@SuppressWarnings("serial")
	List<String> Permitidas = new ArrayList<String>() {
		{
			add("/login.jsp");
			add("/");
			add("/ingresar");
			add("/Plantillas/css/login.css");
			
		}
	};
	private static final long serialVersionUID = -3370865239087407550L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest requesthttp =(HttpServletRequest) request;
		
		Usuario usuario = (Usuario) requesthttp.getSession().getAttribute("usuario");
		
		String ruta = requesthttp.getRequestURI();
		if (usuario ==null && !Permitidas.contains(ruta) ) {
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		else if (usuario !=null && Permitidas.contains(ruta) ) {
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
		else {
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
		
	}

}
