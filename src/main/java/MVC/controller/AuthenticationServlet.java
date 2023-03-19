package MVC.controller;
import MVC.model.Shop;
import MVC.model.User;
import MVC.model.Users;
import MVC.service.IShopService;
import MVC.service.IUsersService;
import MVC.service.Impl.ServiceChat;
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

@WebServlet(urlPatterns = "/Authed")
public class AuthenticationServlet extends HttpServlet {
    private IUsersService iUsersService = new UsersService();
    private IShopService iShopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Users UserLogin = (Users) session.getAttribute("UserLogin");
        String actionUser = req.getParameter("actionUser");
        if(actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            case "logout":
                if(UserLogin == null){
                    resp.sendRedirect(req.getContextPath() + "/Authed");
                    return;
                }
                session.invalidate();
                resp.sendRedirect(req.getContextPath() + "/Authed");
                return;
            default:
                if(UserLogin != null){
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                    return;
                }
                req.getRequestDispatcher("/view/public/login.jsp").forward(req,resp);
                break;
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Users UserLogin = (Users) session.getAttribute("UserLogin");
        String actionUser = req.getParameter("actionUser");
        if(actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            case "logout":
                break;
            default:
                if(UserLogin != null){
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                    return;
                }
                String username = String.valueOf(req.getParameter("email"));
                String password = String.valueOf(req.getParameter("password"));
                if(password != null || !password.equals("")){
                    password = StringUtil.md5(password);
                }
                Users users = iUsersService.kiemtra(username,password);
                int userId = Integer.parseInt(new ServiceChat().getIdByName(username));
                if(users != null){
                    Shop shop = iShopService.getShop(users.getId());
                    if(users.getRole().equals("Producter") && shop == null ){
                        session.setAttribute("UserDK",users);
                        req.getRequestDispatcher("/view/public/shopRegister.jsp?err=5").forward(req,resp);
                        return;
                    }
                    if(shop != null){
                        session.setAttribute("shopLogin",shop);
                    }
                    session.setAttribute("username",username);
                    session.setAttribute("password",password);
                    session.setAttribute("userId",userId);
                    session.setAttribute("UserLogin", users);
                    req.getRequestDispatcher("/index.jsp").forward(req,resp);
                    return;
                }else {
                    resp.sendRedirect(req.getContextPath() + "/Authed?err=1");
                }
            break;
        }
    }
}
