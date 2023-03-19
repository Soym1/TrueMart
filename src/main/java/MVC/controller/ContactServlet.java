package MVC.controller;

import MVC.model.Shop;
import MVC.model.Users;
import MVC.service.IContactService;
import MVC.service.Impl.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContactServlet", value = "/admin/contact")
public class ContactServlet extends HttpServlet {
    private IContactService iContactService = new ContactService();
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
            case "del":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/contact?err=1");
                    return;
                }
                if(iContactService.del(id) > 0 ){
                    response.sendRedirect(request.getContextPath() + "/admin/contact?msg=3");
                    return;
                }else{
                    response.sendRedirect(request.getContextPath() + "/admin/contact?err=2");
                }
                break;
            default:
                request.setAttribute("ListContact",iContactService.listAll());
                request.getRequestDispatcher("/view/admin/contact/index.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
