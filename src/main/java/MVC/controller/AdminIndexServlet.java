package MVC.controller;

import MVC.model.Users;
import MVC.service.ICategoryService;
import MVC.service.IInvoiceService;
import MVC.service.IProductService;
import MVC.service.IUsersService;
import MVC.service.Impl.CategoryService;
import MVC.service.Impl.InvoiceService;
import MVC.service.Impl.ProductService;
import MVC.service.Impl.UsersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminIndexServlet", value = "/admin")
public class AdminIndexServlet extends HttpServlet {
    private IInvoiceService iinvoiceService = new InvoiceService();
    private IProductService iProductService = new ProductService();
    private IUsersService iUsersService = new UsersService();
    private ICategoryService iCategoryService = new CategoryService();
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
        switch (actionUser){
            default:
                request.setAttribute("numCate",iCategoryService.numAll());
                request.setAttribute("numUsser",iUsersService.numAll());
                request.setAttribute("numPro", iProductService.numAll());
                request.setAttribute("numOder", iinvoiceService.numAll());
                request.getRequestDispatcher("/view/admin/index.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        switch (actionUser){
            default:
                request.setAttribute("numCate",iCategoryService.numAll());
                request.setAttribute("numUsser",iUsersService.numAll());
                request.setAttribute("numPro", iProductService.numAll());
                request.setAttribute("numOder", iinvoiceService.numAll());
                request.getRequestDispatcher("/view/admin/index.jsp").forward(request,response);
                break;
        }
    }
}
