package dev.syntax.step05statemanaging.step03practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.syntax.step05statemanaging.step03practice.data.*;
import dev.syntax.step05statemanaging.step03practice.model.*;
@WebServlet("/add")
public class MemberInsert extends HttpServlet{
	
	private loginDAO loginDAO;
	
	public MemberInsert() {
		this.loginDAO = new loginDAO();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		// 1. 브라우저에서 전달받은 입력값 추출
		String user_id = req.getParameter("user_id");
		String password= req.getParameter("password");
		
		member member = new member(user_id,password);
		loginDAO.add(member);
		
		resp.sendRedirect("/step02_servlet_syntax/login-practice.html");
	}
	
	
	

}
