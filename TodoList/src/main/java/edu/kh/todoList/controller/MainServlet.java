package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoService;
import edu.kh.todoList.model.service.TodoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// "" == 최상위 주소 요청
@WebServlet("")
public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			TodoService service = new TodoServiceImpl(); //서비스 객체 생성
			
			// 할 일 목록 조회 + 완료된 할 일 개수
			// 서비스 호출 후 결과 반환 받기
			
			// 메서드가 반환 가능한 개수는 1개
			// -> 여러개 반환 받기 위해 map으로 반환 받기
			Map<String, Object> map =  service.selectAll();
			
			// 미리 가공해서 jsp에 보내기
			// map에 담긴 데이터 분리
			// Object 상위객체 -> List 다운캐스팅
			List<Todo> todoList = (List<Todo>)map.get("todoList");
			int completeCount = (int)map.get("completeCount");
			
			//분리된 데이터를 request 객체에 속성으로 추가
			req.setAttribute("todoList", todoList);
			req.setAttribute("completeCount", completeCount);
			
			
			String path = "/WEB-INF/views/main.jsp";
			
			// main.jsp로 포워드
			req.getRequestDispatcher(path).forward(req, resp);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
