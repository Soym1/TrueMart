package MVC.controller;

import MVC.model.Product;
import MVC.model.Users;
import MVC.service.Impl.Service;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/Cart")
public class CartServlet extends HttpServlet {
    static Map<String,Map<Integer,Integer>> listCart = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = ((Users) session.getAttribute("UserLogin")).getUsername();
        Map<String, Integer> subListCart = new HashMap<>();
        Gson gson = new Gson();
        int id;
        int quantity;
        String ajaxHeader = req.getHeader("x-requested-with");
        if ("XMLHttpRequest".equals(ajaxHeader)){
            String type = String.valueOf(req.getParameter("type"));
            switch (type){
                case "get-cart":
                    if (!listCart.containsKey(username)){
                        listCart.put(username,new HashMap<>());
                    }
                    break;
                case "add-cart":
                    id = Integer.parseInt(req.getParameter("productID"));
                    quantity = Integer.parseInt(req.getParameter("quantity"));

                    if(listCart.get(username).containsKey(id)){
                        listCart.get(username).put(id,listCart.get(username).get(id) + quantity);
                    }
                    if(!listCart.get(username).containsKey(id)){
                        listCart.get(username).put(id,quantity);
                    }
                    break;
                case "delete-cart":
                    id = Integer.parseInt(req.getParameter("productID"));
                    listCart.get(username).remove(id);
                    break;
                case "update-cart":
                    id = Integer.parseInt(req.getParameter("productID"));
                    quantity = Integer.parseInt(req.getParameter("quantity"));
                    listCart.get(username).put(id,quantity);
                    break;
            }
            listCart.get(username).forEach((productId,qty) -> {
                Product product = new Service().getProductById(productId);
                subListCart.put(gson.toJson(product),qty);
            });
            resp.getWriter().write(gson.toJson(subListCart));
        } else {
            Map<Product,Integer> parsedListCart = new HashMap<>();
            listCart.get(username).forEach((productId,qty) -> {
                Product product = new Service().getProductById(productId);
                parsedListCart.put(product,qty);
            });
            req.setAttribute("listCart",parsedListCart);
            req.getRequestDispatcher("/view/public/cart.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
