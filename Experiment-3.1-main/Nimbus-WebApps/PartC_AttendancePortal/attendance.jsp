<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Part C - Attendance</title></head>
<body>
  <h2>Student Attendance (Part C)</h2>
  <form method="post" action="AttendanceServlet">
    <label>Student ID: <input type="text" name="studentId" required></label><br><br>
    <label>Date: <input type="date" name="date" required></label><br><br>
    <label>Status:
      <select name="status">
        <option value="Present">Present</option>
        <option value="Absent">Absent</option>
      </select>
    </label><br><br>
    <button type="submit">Submit Attendance</button>
  </form>
</body>
</html>
