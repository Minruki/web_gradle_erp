package web_gradle_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Employee;
import web_gradle_erp.service.EmployeeService;

@WebServlet("/EmployeeGetServlet")
public class EmployeeGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeService service;
    
    public EmployeeGetServlet() {
        service = new EmployeeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
		int empNo = Integer.parseInt(request.getParameter("empNo").trim());
		Employee employee = service.showEmployee(new Employee(empNo));
		System.out.println(employee);
		request.setAttribute("employee", employee);
		
		request.getRequestDispatcher("EmployeeInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
