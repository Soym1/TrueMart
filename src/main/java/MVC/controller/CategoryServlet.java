package MVC.controller;

import MVC.model.Category;
import MVC.model.Users;
import MVC.service.ICategoryService;
import MVC.service.Impl.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/admin/category")
public class CategoryServlet extends HttpServlet {
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
        int id = 0;
        switch (actionUser){
            case "add":
                request.getRequestDispatcher("/view/admin/category/add.jsp").forward(request,response);
                break;
            case "edit":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/category?err=1");
                    return;
                }
                request.setAttribute("category", iCategoryService.findAll(id));
                request.getRequestDispatcher("/view/admin/category/edit.jsp").forward(request,response);
                break;
            case "del":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/category?err=1");
                    return;
                }
                if(iCategoryService.del(id) > 0 ){
                    response.sendRedirect(request.getContextPath() + "/admin/category?msg=3");
                    return;
                }else{
                    response.sendRedirect(request.getContextPath() + "/admin/category?err=2");
                }
                break;
            default:
                request.setAttribute("categorysList", iCategoryService.ListCate());
                request.getRequestDispatcher("/view/admin/category/index.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
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
        List<Category> Categorys = new ArrayList<>();
        String category_name = null;
        switch (actionUser){
            case "add":
                category_name = request.getParameter("category_name");
                Categorys = iCategoryService.ListCate();
                for (Category ktc: Categorys){
                    if(category_name.equals(ktc.getCategory_name())){
                        request.setAttribute("category_name",category_name);
                        request.getRequestDispatcher("/view/admin/category/add.jsp?err=2").forward(request,response);
                        return;
                    }
                }
                if(iCategoryService.creat(category_name) > 0){
                    response.sendRedirect(request.getContextPath() + "/admin/category?msg=1");
                    return;
                }else{
                    request.setAttribute("category_name",category_name);
                    request.getRequestDispatcher("/view/admin/category/add.jsp?err=1").forward(request,response);
                }
                break;
            case "edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/category?err=1");
                    return;
                }
                category_name = request.getParameter("category_name");
                Category category = new Category(id,category_name);
                if(iCategoryService.edit(category) > 0){
                    response.sendRedirect(request.getContextPath() + "/admin/category?msg=2");
                    return;
                }else{
                    request.setAttribute("category",category);
                    request.getRequestDispatcher("/view/admin/category/add.jsp?err=1").forward(request,response);
                }
                break;
            default:
                request.setAttribute("categorysList", iCategoryService.ListCate());
                request.getRequestDispatcher("/view/admin/category/index.jsp").forward(request,response);
                break;
        }
    }
}
