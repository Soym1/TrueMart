package MVC.controller;

import MVC.model.Cart;
import MVC.model.Product;
import MVC.respository.impl.BaseRespository;
import MVC.service.Impl.Service;
import javafx.print.Printer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AddtoCartServlet", value = "/AddCart")
public class AddtoCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<Cart> cartList = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Cart cart = new Cart();
        cart.setId(id);
        cart.setQuantity(1);
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");

        if (cart_list == null) {
            cartList.add(cart);
            session.setAttribute("cart_list", cartList);
            response.sendRedirect("/ListProduct");
        } else {
            cartList = cart_list;
            boolean exist = false;
            for (Cart c : cart_list) {
                if (c.getId() == id) {
                    exist = true;
                    c.incrementQuantity(quantity);
                    response.sendRedirect("/ListProduct");
                }
            }

            if (!exist) {
                cartList.add(cart);
                response.sendRedirect("/ListProduct");
            }
        }
    }
        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }

