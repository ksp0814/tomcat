package dev.syntax.step05statemanaging.step01cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first-cookie-set")
public class FirstCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		// 브라우저가 보관하도록 서버에서 쿠키 객체 생성
		Cookie cookie1 = new Cookie("id", "guest"); // key-value 형태로 생성, 
		// id라는 이름의 key값으로 guest라는 문자열 값을 설정
		
		// 응답 객체에 쿠키 객체를 담아서 응답
		resp.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("nickName", "spiderman");
		cookie2.setMaxAge(30);
		resp.addCookie(cookie2);
		
		PrintWriter out = resp.getWriter();
		out.print("서버에서 생성한 쿠키가 브라우저로 전달되었음");
		out.close();
	}

}
