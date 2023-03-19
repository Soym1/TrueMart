package MVC.controller;

import MVC.model.Cart;
import MVC.model.Product;
import MVC.service.Impl.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RemoveProductServlet", value = "/RemoveProduct")
public class RemoveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            if(id != null)
            {
                ArrayList<Cart> Cart_List = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
                if(Cart_List != null)
                {
                    for (Cart cart:Cart_List)
                    {
                        if(cart.getId() == Integer.parseInt(id))
                        {
                            Cart_List.remove(Cart_List.indexOf(cart));
                            break;
                        }
                    }
                    response.sendRedirect("/Cart");
                }
            }else
            {
                response.sendRedirect("/Cart");
            }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
