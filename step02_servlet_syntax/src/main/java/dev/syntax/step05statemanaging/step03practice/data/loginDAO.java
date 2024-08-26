package dev.syntax.step05statemanaging.step03practice.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.syntax.step05statemanaging.step03practice.db.DBUtil;
import dev.syntax.step05statemanaging.step03practice.model.member;

public class loginDAO {

    // 기존 회원가입 메서드

    public int add(member member) {
        int result = 0;
        String query = "INSERT INTO users (user_id, password) VALUES(?, ?)";
        try (Connection con = DBUtil.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, member.getUser_id());
            pstmt.setString(2, member.getPassword());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        return result;
    }

    // user_id 존재 여부 확인 메서드
    public boolean isUserIdExists(String user_id) {
        boolean exists = false;
        String query = "SELECT COUNT(*) FROM users WHERE user_id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, user_id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    exists = rs.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        return exists;
    }
}
