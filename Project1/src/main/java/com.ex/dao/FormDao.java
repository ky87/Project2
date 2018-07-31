package com.ex.dao;

import com.ex.sql.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormDao {
    private static SQLConnection connectionUtil = SQLConnection.getConnectionUtil();

    public static void createForm(Integer eid, String date, String time, String location, Integer cost, String type, String grade, String des) {

        try (Connection conn = connectionUtil.getConnection()) {

            String query = "INSERT into form (employee_id, date, event_time, event_location, event_cost, event_type, grading, description)" +
                    " values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, eid);
            ps.setString(2, date);
            ps.setString(3, time);
            ps.setString(4, location);
            ps.setInt(5, cost);
            ps.setString(6, type);
            ps.setString(7, grade);
            ps.setString(8, des);

            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
