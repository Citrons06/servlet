package hello.servlet.web.servletmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
	
	/*
	 * 고격 요청이 오면 호출
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/new-form.jsp";	// 호출되는 JSP
		RequestDispatcher dispather = request.getRequestDispatcher(viewPath);		// 컨트롤러에서 뷰로 이동
		dispather.forward(request, response);	// 서블릿에서 JSP 호출
		
	}

}
