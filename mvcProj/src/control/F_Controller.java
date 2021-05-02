package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ActionForward;

/**
 * Servlet implementation class F_Controller
 */
@WebServlet("/board/*")
public class F_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public F_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		String service = uri.substring(request.getContextPath().length()+"/board/".length());
		System.out.println("service : "+service);
		
		
		
		try {
			Action action = (Action)Class.forName("service."+service).newInstance();
			ActionForward af = action.execute(request, response);
			
			if(af.getUrl() != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/"+af.getUrl()+".jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}

	
}
