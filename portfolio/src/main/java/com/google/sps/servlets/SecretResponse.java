package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Servlet that returns HTML that contains the page view count. */
@WebServlet("/secret-response")
public class SecretResponse extends HttpServlet {

    private String[] responses = {
        "My favorite season is winter", 
        "I\'ve never had a dog, but I would like to have one someday", 
        "I like playing video games"
    };

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Gson gson = new Gson();
    String responses_json = gson.toJson(this.responses);
    response.setContentType("application/json;");
    response.getWriter().println(responses_json);
  }
}
