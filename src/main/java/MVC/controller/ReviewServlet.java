package MVC.controller;

import MVC.model.Shop;
import MVC.model.Users;
import MVC.service.IReviewService;
import MVC.service.IShopService;
import MVC.service.Impl.ReviewService;
import MVC.service.Impl.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReviewServlet", value = "/admin/review")
public class ReviewServlet extends HttpServlet {
    private IReviewService iReviewService = new ReviewService();
    private IShopService iShopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Users UserLogin = (Users) session.getAttribute("UserLogin");
        if(UserLogin == null){
            response.sendRedirect(request.getContextPath() + "/admin/auth");
            return;
        }
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null){
            actionUser = "";
        }
        int id = 0;
        switch (actionUser){
            case "del":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/review?err=1");
                    return;
                }
                if(iReviewService.del(id) > 0 ){
                    response.sendRedirect(request.getContextPath() + "/admin/review?msg=3");
                    return;
                }else{
                    response.sendRedirect(request.getContextPath() + "/admin/review?err=2");
                }
                break;
            default:
                if(UserLogin.getRole().equals("Admin")){
                    request.setAttribute("ListReview",iReviewService.listAll());
                    request.getRequestDispatcher("/view/admin/review/index.jsp").forward(request,response);
                    return;
                }else {
                    Shop shop = iShopService.getShop(UserLogin.getId());
                    request.setAttribute("ListReview",iReviewService.listReviewShop(shop));
                    request.getRequestDispatcher("/view/admin/review/index.jsp").forward(request,response);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
