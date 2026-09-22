package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        String roll = request.getParameter("rollNo");
        
        int mark1 = Integer.parseInt(request.getParameter("marks1"));
        int mark2 = Integer.parseInt(request.getParameter("marks2"));
        int mark3 = Integer.parseInt(request.getParameter("marks3"));

        int total = mark1 + mark2 + mark3;
        double percentage = (total / 300.0) * 100;

        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 75) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else {
            grade = "Fail";
        }

        out.println("<!DOCTYPE html><html><head><title>Result Summary</title></head><body>");
        out.println("<h2>Student Result Summary</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Roll Number:</strong> " + roll + "</p>");
        out.println("<p><strong>Subject 1:</strong> " + mark1 + "</p>");
        out.println("<p><strong>Subject 2:</strong> " + mark2 + "</p>");
        out.println("<p><strong>Subject 3:</strong> " + mark3 + "</p>");
        out.println("<hr>");
        out.println("<p><strong>Total Marks:</strong> " + total + " / 300</p>");
        out.println("<p><strong>Percentage:</strong> " + String.format("%.2f", percentage) + "%</p>");
        out.println("<p><strong>Grade:</strong> " + grade + "</p>");
        out.println("</body></html>");
    }
}