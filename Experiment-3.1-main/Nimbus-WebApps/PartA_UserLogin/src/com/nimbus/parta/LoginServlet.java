package com.nimbus.parta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    // For simplicity using hardcoded credentials. Change as needed.
    private static final String USER = "admin";
    private static final String PASS = "admin123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (USER.equals(username) && PASS.equals(password)) {
            out.println("<h2>Welcome, " + escapeHtml(username) + "!</h2>");
            out.println("<p>Login successful (Part A).</p>");
        } else {
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password. Try again.</p>");
            out.println("<a href=\"index.html\">Back to Login</a>");
        }
        out.println("</body></html>");
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
    }
}
