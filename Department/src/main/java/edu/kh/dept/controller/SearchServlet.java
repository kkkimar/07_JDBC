package edu.kh.dept.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.service.DepartmentService;
import edu.kh.dept.model.service.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/department/search")
public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			String keyword = req.getParameter("keyword"); //검색어

			DepartmentService service = new DepartmentServiceImpl();
			
			//여러행 조회 -> List
			List<Department> deptList = service.searchDepartment(keyword);
			
			// 조회 결과를 request scope에 속성으로 세팅
			req.setAttribute("deptList", deptList);
			
			String message = null;
			HttpSession session = req.getSession();
			
			if(deptList.isEmpty()) {
				message = "조회 실패";
			}
			else {
				message = "조회 성공";
			}
			
			session.setAttribute("message", message);
			
			// forward할 jsp 경로
			String path = "/WEB-INF/views/search.jsp";
			req.getRequestDispatcher(path).forward(req, resp);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
;