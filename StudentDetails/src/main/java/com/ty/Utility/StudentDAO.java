package com.ty.Utility;

import com.ty.model.StudentModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDAO implements StudentModel {

    private static final String URL = "jdbc:postgresql://localhost:5432/E3";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static Connection connection;
    private static Scanner sc = new Scanner(System.in);

    // Establishing the connection
    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to the database established successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        System.out.println("Enter student name:");
        String name = sc.nextLine();
        System.out.println("Enter student ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        System.out.println("Enter student email:");
        String email = sc.nextLine();
        System.out.println("Enter student city:");
        String city = sc.nextLine();
        System.out.println("Enter student mobile number:");
        long mobile = sc.nextLong();
        

        String sql = "INSERT INTO public.\"Student\"(s_name, s_id, s_email, s_number, s_city) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, email);
            pstmt.setLong(4, mobile);
            pstmt.setString(5, city);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter the ID of the student to delete:");
        int id = sc.nextInt();

        String sql = "DELETE FROM public.\"Student\" WHERE s_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        System.out.println("Enter the ID of the student to update:");
        int id = sc.nextInt();
        sc.nextLine();  // Consume newline left-over
        System.out.println("Enter new student name:");
        String name = sc.nextLine();
        System.out.println("Enter new student email:");
        String email = sc.nextLine();
        System.out.println("Enter new student mobile number:");
        String mobile = sc.nextLine();
        System.out.println("Enter new student city:");
        String city = sc.nextLine();

        String sql = "UPDATE public.\"Student\" SET s_name=?, s_email=?, s_number=?, s_city=? WHERE s_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, mobile);
            pstmt.setString(4, city);
            pstmt.setInt(5, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
