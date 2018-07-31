package com.ex.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQL {
    private static SQLConnection connectionUtil = SQLConnection.getConnectionUtil();

    public static void createAccount(Integer id, String first_name, String last_name, String department) {
        try (Connection conn = connectionUtil.getConnection()) {

            String query = "insert into employee (id, first_name, last_name, department) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, first_name);
            ps.setString(3, last_name);
            ps.setString(4,department);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //createAccount(1, "Kevin","Yeung", "ECE");

        System.out.println("Account Created");

        try(Connection conn = connectionUtil.getConnection()) {

            String query = "SELECT id, first_name, last_name, department FROM employee WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 1);

            ResultSet resultSet = ps.executeQuery();

            System.out.println("ps complete");
            // Process results
            if(resultSet.next()) {

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String department = resultSet.getString("department");

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
