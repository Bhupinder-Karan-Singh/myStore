

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get_user_detail")
public class get_user_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
             HttpSession session = request.getSession();
             String session_email = (String) session.getAttribute("session_email");
             
			 response.setContentType("application/json"); 
			 PrintWriter outPrintWriter = response.getWriter();
			 String jsonString = new RDBMS_TO_JSON().generateJSON("Select name, phone from user where email = \'" + session_email + "\'");
			 outPrintWriter.println(jsonString);
         }

	// Post method request
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
	}

}
