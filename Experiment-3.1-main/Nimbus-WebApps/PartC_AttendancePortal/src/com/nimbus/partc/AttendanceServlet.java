package com.nimbus.partc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/nimbus_lab";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        response.setContentType("text/html");
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO Attendance (StudentID, attend_date, status) VALUES (?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, studentId);
                pst.setDate(2, Date.valueOf(date));
                pst.setString(3, status);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><body>");
                out.println("<h2>Error saving attendance</h2>");
                out.println("<pre>" + e.getMessage() + "</pre>");
                out.println("<a href='attendance.jsp'>Back</a>");
                out.println("</body></html>");
            }
            return;
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h2>Attendance saved successfully</h2>");
            out.println("<a href='attendance.jsp'>Add More</a>");
            out.println("</body></html>");
        }
    }
}
