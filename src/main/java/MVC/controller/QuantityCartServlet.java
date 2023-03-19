package MVC.controller;

import MVC.model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuantityCartServlet", value = "/QuantityCart")
public class QuantityCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();

       int id = Integer.parseInt(request.getParameter("id"));

        ArrayList<Cart> Cart_List = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");

        if(id >= 1)
        {
         {
             for(Cart c:Cart_List)
             {
                 if(c.getId() == id)
                 {
                     int quantity = c.getQuantity();
                     quantity++;
                     c.setQuantityProduct(quantity);
                     response.sendRedirect("/Cart");
                 }
             }
         }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
