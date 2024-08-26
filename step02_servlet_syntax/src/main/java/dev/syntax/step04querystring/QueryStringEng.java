package dev.syntax.step04querystring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-test-eng")
public class QueryStringEng extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 헤더에 컨텐츠의 타입과 인코딩 타입을 명시
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<h1>GET방식으로 요청되었음</h1>");
		
		// <input type="text" name="id"/>에서 name attribute의 값과 일치하도록
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobby");//쿼리스트링의 변수 형태가 배열타입일 때
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		String introduction = req.getParameter("introduction");
		
		
		out.print("ID : " + id + " <br/> ");
		out.print("비밀번호 : " + password + " <br/> ");
		out.print("이름 : " + name + " <br/> ");
		out.print("취미 : ");
		for(int i = 0; i < hobbies.length; i++) {
			 out.print(hobbies[i] + " ");
		}
		out.print("<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("국가 : "+ country + "<br/>");
		out.print("소개 : " + introduction + "<br/>");
		out.close();
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		// POST 방식에서의 한글 처리
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		
		
		PrintWriter out = resp.getWriter();
		out.print("<h1>POST 방식으로 요청 되었음.</h1>");
		out.print("이름 : " + name + " <br/> ");
		
		out.close();
	}

	
}
