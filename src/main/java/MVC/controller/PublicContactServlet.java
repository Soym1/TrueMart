package MVC.controller;

import MVC.model.Contact;
import MVC.service.IContactService;
import MVC.service.Impl.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PublicContactServlet", value = "/contact")
public class PublicContactServlet extends HttpServlet {
    private IContactService iContactService = new ContactService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            default:
                request.getRequestDispatcher("/view/public/contact.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            default:
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String website = request.getParameter("website");
                String subject = request.getParameter("subject");
                String message = request.getParameter("message");
                Contact contact = new Contact(0,name,email,website,subject,message);
                if(iContactService.add(contact) > 0){
                    response.sendRedirect("/contact?msg=1");
                    return;
                }else {
                    request.setAttribute("contact",contact);
                    request.getRequestDispatcher("/view/public/contact.jsp?err=1").forward(request,response);
                }
                break;
        }
    }
}
