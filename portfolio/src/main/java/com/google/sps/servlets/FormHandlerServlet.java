package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

import com.google.gson.Gson;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("name");
    String recruiter = request.getParameter("recruiter");
    String summary = request.getParameter("summary");
    String message = request.getParameter("message");

    // sentiment analysis
    Document doc = Document.newBuilder()
        .setContent(request.getParameter("message"))
        .setType(Document.Type.PLAIN_TEXT).build();
    LanguageServiceClient languageService = LanguageServiceClient.create();
    Sentiment sentiment = languageService.analyzeSentiment(doc).getDocumentSentiment();
    float score = sentiment.getScore();
    languageService.close();

    // Print the value so you can see it in the server logs.
    System.out.println("Message from: " + name);
    System.out.println("Is a recruiter: " + recruiter);
    System.out.println("Summary of Message: " + summary);
    System.out.println("Message: " + message);
    System.out.println("Sentiment Score: "+ score);

    // Write the value to the response so the user can see it.
    Gson gson = new Gson();
    String score_response = gson.toJson(score);
    response.setContentType("application/json;");
    response.getWriter().println(score_response);
  }
}