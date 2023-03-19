package MVC.controller;

import MVC.model.Shop;
import MVC.model.Users;
import MVC.service.IShopService;
import MVC.service.IUsersService;
import MVC.service.Impl.ShopService;
import MVC.service.Impl.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/admin/shop")
public class ShopServlet extends HttpServlet {
    private IShopService iShopService = new ShopService();
    private IUsersService iUsersService = new UsersService();
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
        if(actionUser == null){
            actionUser = "";
        }
        int id = 0;
        String requestUrl = request.getRequestURL().toString();
        System.out.println("Current URL: " + requestUrl);
        switch (actionUser){
            case "creat":
                request.setAttribute("listUserNS", iUsersService.listUserNS());
                if(iUsersService.listUserNS().size() == 0){
                    response.sendRedirect(request.getContextPath() + "/admin/shop?err=3");
                    return;
                }
                request.getRequestDispatcher("/view/admin/shop/add.jsp").forward(request,response);
                break;
            case "edit":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/shop?err=1");
                    return;
                }
                request.setAttribute("shop", iShopService.find(id));
                request.getRequestDispatcher("/view/admin/shop/edit.jsp").forward(request,response);
                break;
            case "del":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/shop?err=1");
                    return;
                }
                if(iShopService.del(id) > 0 ){
                    response.sendRedirect(request.getContextPath() + "/admin/shop?msg=3");
                    return;
                }else{
                    response.sendRedirect(request.getContextPath() + "/admin/shop?err=2");
                }
                break;
            default:
                request.setAttribute("listShop", iShopService.listAll());
                request.getRequestDispatcher("/view/admin/shop/index.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        int id_user = 0;
        String name = null;
        String address = null;
        Users users = null;
        Shop shop = null;
        List<Shop> shoplist = new ArrayList<>();
        switch (actionUser){
            case "creat":
                name = request.getParameter("name");
                address = request.getParameter("address");
                try{
                    id_user = Integer.parseInt(request.getParameter("id_user"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/shop?err=1");
                    return;
                }
                users = new Users(id_user,null,null,null,null,null,null,null,null);
                shop = new Shop(0,users,name,address);
                shoplist = iShopService.listAll();
                for (Shop kts: shoplist) {
                    if(name.equals(kts.getShop_name())){
                        request.setAttribute("shop",shop);
                        request.getRequestDispatcher("/view/admin/shop/add.jsp?err=2").forward(request,response);
                    }
                }
                if(iShopService.creat(shop) > 0){
                    response.sendRedirect(request.getContextPath() + "/admin/shop?msg=1");
                    return;
                }else{
                    request.setAttribute("users",users);
                    request.getRequestDispatcher("/view/admin/shop/add.jsp?err=1").forward(request,response);
                }
                break;
            case "edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
                    return;
                }
                name = request.getParameter("name");
                address = request.getParameter("address");
                users = new Users(0,iShopService.find(id).getUsers().getUsername(),null,null,null,null,null,null,null);
                shop = new Shop(id,users,name,address);
                shoplist = iShopService.listAll();
                if(!name.equals(iShopService.find(id).getShop_name())){
                    for (Shop kts: shoplist) {
                        if(name.equals(kts.getShop_name())){
                            request.setAttribute("shop",shop);
                            request.getRequestDispatcher("/view/admin/shop/add.jsp?err=2").forward(request,response);
                            return;
                        }
                    }
                }
                if(iShopService.edit(shop) > 0){
                    response.sendRedirect(request.getContextPath() + "/admin/shop?msg=2");
                    return;
                }else{
                    request.setAttribute("shop",shop);
                    request.getRequestDispatcher("/view/admin/shop/edit.jsp?err=1").forward(request,response);
                }
                break;
            default:
                request.setAttribute("listShop", iShopService.listAll());
                request.getRequestDispatcher("/view/admin/shop/index.jsp").forward(request,response);
                break;
        }
    }
}
