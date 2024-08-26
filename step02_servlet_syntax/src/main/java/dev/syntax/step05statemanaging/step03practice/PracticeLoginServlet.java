package dev.syntax.step05statemanaging.step03practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.syntax.step05statemanaging.step03practice.data.loginDAO;

@WebServlet("/login-practice")
public class PracticeLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String user_id = req.getParameter("user_id");
        String password = req.getParameter("password");

        if (user_id == null || user_id.isEmpty() || password == null || password.isEmpty()) {
            out.print("아이디 혹은 비밀번호를 입력하세요");
            return;
        }

        // loginDAO 인스턴스를 생성하여 ID 존재 여부 확인
        loginDAO dao = new loginDAO();
        if (dao.isUserIdExists(user_id)) {
            // 로그인한 회원 정보를 구분할 수 있는 key값을 보관할 세션 객체 생성
            HttpSession session = req.getSession();
            System.out.println("Session ID: " + session.getId());

            if (session.isNew() || session.getAttribute("user_id") == null) {
                // 세션에 사용자 ID 저장
                session.setAttribute("user_id", user_id);
                out.print("로그인 완료");
            } else {
                out.print(user_id + "님 안녕하세요.");
            }
        } else {
            out.print("로그인 실패: 아이디가 존재하지 않습니다.");
        }

        out.close();
    }
}
