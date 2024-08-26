package dev.syntax.step05statemanaging.step02session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그인 처리를 수행하는 서블릿

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	// <form action="login" method="post">의 method와 동일한 이름의 메서드로 오버라이딩
	// method="post"이기 때문에 doPost()를 사용
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// <input type="text" name="id" id="id" />에서 name 어트리뷰트와 일치하도록
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		if (id.isEmpty() || password.isEmpty()) {
			out.print("아이디 혹은 비밀번호를 입력하세요");
			return;
		}
		
		// ID/PW 확인이 완료되었다고 가정
		
		// 로그인한 회원 정보를 구분할 수 있는 key값을 보관할 세션 객체 생성
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("로그인 완료");
		} else {
			out.print("현재 로그인 상태입니다.");
		}
		
		out.close();
	}
	

}
