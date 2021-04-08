package web_gradle_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_erp.dto.Department;
import web_gradle_erp.service.DepartmentService;




@WebServlet("/DeptUpdateServlet")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service;

    public DeptUpdateServlet() {
    	service = new DepartmentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int deptNo = Integer.parseInt(request.getParameter("deptNo").trim());
		String deptName = request.getParameter("deptName");
		int floor = Integer.parseInt(request.getParameter("floor").trim());
		
		Department department = new Department(deptNo, deptName, floor);
		System.out.println(department);
		
		service.modifyDepartment(department);
		response.sendRedirect("DeptListServlet");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
