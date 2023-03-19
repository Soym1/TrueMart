package MVC.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SendReviewServlet", value = "/SendReview")
public class SendReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_review = request.getParameter("txt-name");
        String user_email = request.getParameter("txt-email");
        String user_content = request.getParameter("txt-content");
        String user_rating = request.getParameter("txt-rating");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
