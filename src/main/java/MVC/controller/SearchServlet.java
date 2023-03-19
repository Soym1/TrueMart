package MVC.controller;

import MVC.model.Category;
import MVC.model.Product;
import MVC.service.ICategoryService;
import MVC.service.Impl.CategoryService;
import MVC.service.Impl.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/Search")
public class SearchServlet extends HttpServlet {
    private ICategoryService iCategoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//            request.setCharacterEncoding("UTF-8"); Vietnamese
        String txtSearch = request.getParameter("txt");

        List<Product> list = new Service().SearchProductByName(txtSearch);
        List<Category> listCate = iCategoryService.ListCate();
        request.setAttribute("ListP", list);
        request.setAttribute("text", txtSearch);
        request.setAttribute("ListC", listCate);
        request.getRequestDispatcher("/view/public/store.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
