package MVC.controller;

import MVC.model.Category;
import MVC.model.Product;
import MVC.service.Impl.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategorySearchServlet", value = "/CategorySearch")
public class CategorySearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cateID = request.getParameter("cid");
        List<Product> list = new Service().getProductByCategoryID(cateID);
        List<Category> listc = new Service().getAllCategory();

        request.setAttribute("ListP",list);
        request.setAttribute("ListC",listc);
        request.getRequestDispatcher("/view/public/store.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
