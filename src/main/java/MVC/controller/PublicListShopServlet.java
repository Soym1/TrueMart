package MVC.controller;

import MVC.model.Shop;
import MVC.service.IShopService;
import MVC.service.Impl.ShopService;
import MVC.util.DefineUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PublicListShopServlet", value = "/ListShop")
public class PublicListShopServlet extends HttpServlet {
    private IShopService iShopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberOfItems = iShopService.countItems();
        int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
        int currentPage = 1;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            currentPage = 1;
        }
        int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
        List<Shop> listShop =  iShopService.listAll(offset);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("listShop",listShop);
        request.getRequestDispatcher("view/public/listShop.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
