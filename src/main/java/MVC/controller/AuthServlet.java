package MVC.controller;

import MVC.model.Users;
import MVC.service.IShopService;
import MVC.service.IUsersService;
import MVC.service.Impl.ShopService;
import MVC.service.Impl.UsersService;
import MVC.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/admin/auth")
public class AuthServlet extends HttpServlet {
    private IUsersService iUsersService = new UsersService();
    private IShopService iShopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users UserLogin = (Users) session.getAttribute("UserLogin");
        String actionUser = request.getParameter("actionUser");
        if(actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            case "logout":
                if(UserLogin == null){
                    response.sendRedirect(request.getContextPath() + "/admin/auth");
                    return;
                }
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/admin/auth");
                return;
            default:
                if(UserLogin != null){
                    response.sendRedirect(request.getContextPath() + "/admin");
                    return;
                }
                request.getRequestDispatcher("/view/admin/auth/login.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        Users UserLogin = (Users) session.getAttribute("UserLogin");
        if(UserLogin != null){
            response.sendRedirect(request.getContextPath() + "/admin");
            return;
        }
        String actionUser = request.getParameter("actionUser");
        if(actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            default:
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if(password != null || !password.equals("")){
                    password = StringUtil.md5(password);
                }
                Users users = iUsersService.kiemtra(username,password);
                if(users != null){
                    session.setAttribute("ShopLogin", iShopService.getShop(users.getId()));
                    session.setAttribute("UserLogin", users);
                    response.sendRedirect(request.getContextPath() + "/admin");
                    return;
                }else{
                    response.sendRedirect(request.getContextPath() + "/admin/auth?err=1");
                }
                break;
        }
    }
}
