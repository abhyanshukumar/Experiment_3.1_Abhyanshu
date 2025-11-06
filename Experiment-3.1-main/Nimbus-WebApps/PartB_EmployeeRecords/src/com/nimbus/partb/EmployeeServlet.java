package com.nimbus.partb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/nimbus_lab";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String all = request.getParameter("all");
        String empid = request.getParameter("empid");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            if (all != null || (empid == null || empid.isEmpty())) {
                String sql = "SELECT EmpID, Name, Salary FROM Employee";
                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(sql)) {
                    out.println("<h2>All Employees</h2>");
                    out.println("<table border='1'><tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");
                    while (rs.next()) {
                        out.println("<tr><td>" + rs.getInt("EmpID") + "</td><td>" + rs.getString("Name") + "</td><td>" + rs.getDouble("Salary") + "</td></tr>");
                    }
                    out.println("</table>");
                }
            } else {
                String sql = "SELECT EmpID, Name, Salary FROM Employee WHERE EmpID = ?";
                try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setInt(1, Integer.parseInt(empid));
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            out.println("<h2>Employee Details</h2>");
                            out.println("<p>EmpID: " + rs.getInt("EmpID") + "</p>");
                            out.println("<p>Name: " + rs.getString("Name") + "</p>");
                            out.println("<p>Salary: " + rs.getDouble("Salary") + "</p>");
                        } else {
                            out.println("<p>No employee found with ID=" + empid + "</p>");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            out.println("<p>Error connecting to DB: " + e.getMessage() + "</p>");
        }
        out.println("<p><a href='index.html'>Back</a></p>");
        out.println("</body></html>");
    }
}
