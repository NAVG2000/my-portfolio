package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("name");
    String recruiter = request.getParameter("recruiter");
    String summary = request.getParameter("summary");
    String message = request.getParameter("message");

    // Print the value so you can see it in the server logs.
    System.out.println("Message from: " + name);
    System.out.println("Is a recruiter: " + recruiter);
    System.out.println("Summary of Message: " + summary);
    System.out.println("Message: " + message);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Message from: " + name);
    response.getWriter().println("Is a recruiter: " + recruiter);
    response.getWriter().println("Summary of Message: " + summary);
    response.getWriter().println("Message: " + message);
    response.sendRedirect(request.getContextPath());
  }
}