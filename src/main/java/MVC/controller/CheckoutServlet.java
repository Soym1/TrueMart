package MVC.controller;

import MVC.model.Product;
import MVC.model.Users;
import MVC.service.Impl.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet(urlPatterns = "/Checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = ((Users) session.getAttribute("UserLogin")).getUsername();
        Map<Product,Integer> parsedListCart = new HashMap<>();

        AtomicLong total = new AtomicLong();
        CartServlet.listCart.get(username).forEach((productId, qty) -> {
            Product product = new Service().getProductById(productId);
            parsedListCart.put(product,qty);
            total.set(Long.parseLong(String.valueOf(total)) + Long.parseLong(product.getPrice().replace(".", "")) * qty);
        });
        req.setAttribute("userInfo",(Users) session.getAttribute("UserLogin"));
        req.setAttribute("listCart",parsedListCart);
        req.setAttribute("total",total);
        req.getRequestDispatcher("/view/public/checkout.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
