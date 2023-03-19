package MVC.controller;

import MVC.model.Users;
import MVC.service.IUsersService;
import MVC.service.Impl.UsersService;
import MVC.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UsersServlet", value = "/admin/users")
public class UsersServlet extends HttpServlet {
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
        if (actionUser == null){
            actionUser = "";
        }
        int id = 0;
        switch (actionUser){
            case "creat":
                request.getRequestDispatcher("/view/admin/users/add.jsp").forward(request,response);
                break;
            case "edit":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
                    return;
                }
                request.setAttribute("users", iUsersService.findAll(id));
                request.getRequestDispatcher("/view/admin/users/edit.jsp").forward(request,response);
                break;
            case "del":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
                    return;
                }
                if(iUsersService.del(id) > 0 ){
                    response.sendRedirect(request.getContextPath() + "/admin/users?msg=3");
                    return;
                }else{
                    response.sendRedirect(request.getContextPath() + "/admin/users?err=2");
                }
                break;
            default:
                request.setAttribute("usersList", iUsersService.findAll());
                request.getRequestDispatcher("/view/admin/users/index.jsp").forward(request,response);
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
        String username = null;
        String password = null;
        String role = null;
        String lastname = null;
        String firstname = null;
        String email = null;
        String phonenumber = null;
        String address = null;
        Users users = null;
        List<Users> usersList = new ArrayList<>();
        switch (actionUser){
            case "creat":
                username = request.getParameter("username");
                password = request.getParameter("password");
                password = StringUtil.md5(password);
                role = request.getParameter("role");
                lastname = request.getParameter("lastname");
                firstname = request.getParameter("firstname");
                email = request.getParameter("email");
                phonenumber = request.getParameter("phonenumber");
                address = request.getParameter("address");
                users = new Users(0,username, password, role, firstname, lastname, email, phonenumber, address);
                usersList = new ArrayList<>();
                usersList = iUsersService.findAll();
                for (Users ktu: usersList) {
                    if(username.equals(ktu.getUsername())){
                        request.setAttribute("users",users);
                        request.getRequestDispatcher("/view/admin/users/add.jsp?err=2").forward(request,response);
                    }
                }
                if(iUsersService.creat(users) > 0){
                    response.sendRedirect(request.getContextPath() + "/admin/users?msg=1");
                    return;
                }else{
                    request.setAttribute("users",users);
                    request.getRequestDispatcher("/view/admin/users/add.jsp?err=1").forward(request,response);
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
                username = request.getParameter("username");
                password = request.getParameter("password");
                if(password == null || password == ""){
                   Users gap = iUsersService.findAll(id);
                   password = gap.getPassword();
                }else{
                    password = StringUtil.md5(password);
                }
                lastname = request.getParameter("lastname");
                firstname = request.getParameter("firstname");
                email = request.getParameter("email");
                phonenumber = request.getParameter("phonenumber");
                address = request.getParameter("address");
                users = new Users(id,username, password, null, firstname, lastname, email, phonenumber, address);
                if(iUsersService.edit(users) > 0){
                    response.sendRedirect(request.getContextPath() + "/admin/users?msg=2");
                    return;
                }else{
                    request.setAttribute("users",users);
                    request.getRequestDispatcher("/view/admin/users/add.jsp?err=1").forward(request,response);
                }
                break;
            default:
                request.setAttribute("usersList", iUsersService.findAll());
                request.getRequestDispatcher("/view/admin/users/index.jsp").forward(request,response);
                break;
        }
    }
}
