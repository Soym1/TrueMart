package MVC.controller;

import MVC.model.*;
import MVC.service.IReviewService;
import MVC.service.Impl.ReviewService;
import MVC.service.Impl.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductDetailServlet", value = "/ProductDetail")
public class ProductDetailServlet extends HttpServlet {
//    private ListProduct listProduct = new ListProduct();
    private IReviewService iReviewService = new ReviewService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        }catch (NumberFormatException e){
            response.sendRedirect(request.getContextPath() + "/ListProduct?err=1");
            return;
        }
        Product product = new Service().findID(id);
        List<Review> reviews = iReviewService.getReviews(id);
        float dem = 0;
        float tong = 0;
        for (Review laytb: reviews) {
            tong += laytb.getRating();
            dem++;
        }
        float trungbinh = 0;
        if(dem != 0){
            trungbinh = tong / dem;
        }
        request.setAttribute("trungbinh",trungbinh);
        request.setAttribute("numreview", reviews.size());
        // set data to jsp
        request.setAttribute("product",product);
        request.setAttribute("review",reviews);
        request.getRequestDispatcher("/view/public/product.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users UserLogin = (Users) session.getAttribute("UserLogin");
        int rating = Integer.parseInt(request.getParameter("arating"));
        int id = Integer.parseInt(request.getParameter("aid"));
        String review = request.getParameter("areview");
        String user_review = UserLogin.getUsername();
        String email = UserLogin.getEmail();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String timestampStr = dateFormat.format(date);
        Timestamp datetime = Timestamp.valueOf(timestampStr);
        Product product = new Product(id,null,null,null,null,null,null,null);
        Review reviewmain = new Review(0,user_review,email,product,review,rating,datetime);
        iReviewService.addRe(reviewmain);
        List<Review> reviews = iReviewService.getReviews(id);
        if(reviews != null && reviews.size() > 0){
            for (Review rv: reviews) {
                response.getWriter().print(
                        "<li>\n" +
                            "<div class=\"review-heading\">\n" +
                                "<h5 class=\"name\">"+ rv.getUser_review() + "</h5>\n" +
                                "<p class=\"date\">"+ rv.getDate() +"</p>\n" +
                                "<div class=\"review-rating\">");
                                    for (int i = 1; i <= rv.getRating(); i++){
                                        response.getWriter().print(
                                                "<i class=\"fa fa-star\"></i>");
                                    }
                                    for (int i = (int) rv.getRating(); i < 5 ; i++){
                                        response.getWriter().print(
                                            "<i class=\"fa fa-star-o empty\"></i>");
                                    }
                                response.getWriter().print(
                                "</div>\n" +
                            "</div>\n" +
                            "<div class=\"review-body\">\n" +
                                "<p>" + rv.getContent() + "\n" +
                            "</div>\n" +
                        "</li>");
            }
        }
    }
}
