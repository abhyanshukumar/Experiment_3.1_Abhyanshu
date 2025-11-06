# Nimbus-WebApps
Full working example containing three parts for Web Applications using Servlets, JSP and JDBC.

**Contents**
- PartA_UserLogin: HTML form + LoginServlet (hardcoded credentials)
- PartB_EmployeeRecords: EmployeeServlet showing all employees & search by EmpID (JDBC)
- PartC_AttendancePortal: JSP attendance form + AttendanceServlet inserting into DB (JDBC)
- sql/schema.sql: SQL script to create database and tables with sample data
- README.md: Setup & deployment instructions

**Notes**
- Projects are plain dynamic webapp structures (not Maven). Deploy each `PartX_*` folder as a separate webapp in Tomcat `webapps/` (or combine as needed).
- Add MySQL Connector/J JDBC driver to `WEB-INF/lib/` of each webapp or Tomcat's `lib/`.
- Default DB settings in servlets: `jdbc:mysql://localhost:3306/nimbus_lab`, user `root`, password `root`. Change in code or provide via context params.

