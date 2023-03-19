package MVC.controller;

import MVC.model.Shop;
import MVC.model.Shopper_Details;
import MVC.model.Users;
import MVC.service.IShopService;
import MVC.service.IUsersService;
import MVC.service.Impl.ShopService;
import MVC.service.Impl.UsersService;
import MVC.util.FileUtil;
import MVC.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MultipartConfig
@WebServlet(name = "SingupServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private IUsersService iUsersService = new UsersService();
    private IShopService iShopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/view/public/resigter.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
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
        String category = null;
        int quantitys = 0;
        List<Users> usersList = new ArrayList<>();
        switch (actionUser){
            case "addshop":
                email = request.getParameter("email");
                phonenumber = request.getParameter("phonenumber");
                category = request.getParameter("category");
                address = request.getParameter("address");
                quantitys = Integer.parseInt(request.getParameter("quantitys"));
                java.util.Date utilDate = new java.util.Date();
                long timeInMillis = utilDate.getTime();
                java.sql.Date sqlDate = new java.sql.Date(timeInMillis);

                Part filePart = request.getPart("image");
                final String dirPathName = request.getServletContext().getRealPath("/templates/img");
                File dirFile = new File(dirPathName);
                if(!dirFile.exists()){
                    dirFile.mkdirs();
                }

                String fileName = FileUtil.getName(filePart);
                String image = FileUtil.rename(fileName);
                String filePathName = dirPathName + File.separator + image;

                Shopper_Details shopper_details = new Shopper_Details(0,email,phonenumber,address,category,quantitys, sqlDate,image);
                if(iShopService.addshopdeatl(shopper_details) > 0){
                    if(!fileName.isEmpty()){
                        filePart.write(filePathName);
                    }
                    String shop_name = request.getParameter("shop_name");
                    Users UserDK = (Users) session.getAttribute("UserDK");
                    Shopper_Details shopper_details1 = iShopService.getShopdetails();
                    Shop shop = new Shop(0,UserDK,shop_name,address,shopper_details1);
                    iShopService.addshop(shop);
                    response.sendRedirect("/Authed");
                }
                break;
            default:
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
                usersList = iUsersService.findAll();
                for (Users ktu: usersList) {
                    if(username.equals(ktu.getUsername())){
                        request.setAttribute("users",users);
                        request.getRequestDispatcher("/view/public/resigter.jsp?err=2").forward(request,response);
                    }
                }
                if(iUsersService.creat(users) > 0){
                    if(users.getRole().equals("Producter")){
                        session.setAttribute("UserDK",iUsersService.kiemtra(users.getUsername(),users.getPassword()));
                        request.getRequestDispatcher("/view/public/shopRegister.jsp").forward(request,response);
                        return;
                    }else{
                        response.sendRedirect("/Authed");
                    }
                }
                else{
                    request.setAttribute("users",users);
                    request.getRequestDispatcher("/view/public/resigter.jsp?err=1").forward(request,response);
                }
                break;
        }

    }
}
