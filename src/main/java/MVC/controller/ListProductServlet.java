package MVC.controller;

import MVC.model.Category;
import MVC.model.Product;
import MVC.service.ICategoryService;
import MVC.service.Impl.CategoryService;
import MVC.service.Impl.Service;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ListProductServlet", value = "/ListProduct")
public class ListProductServlet extends HttpServlet {
    private ICategoryService iCategoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ajaxHeader = request.getHeader("x-requested-with");
        List<Product> list;
        Map<Integer, String> listGson = new HashMap<>();
        String type = null;
        int page=1;
        List<Integer> listPage = null;
        String category = request.getParameter("category");
        if (request.getParameter("type") == null){
            type = "";
        } else{
            type = request.getParameter("type");
        }
        if ("XMLHttpRequest".equals(ajaxHeader)) {
            if (type.equals("search")) {
                String[] listCategory = new String[0];
                if (category != null){listCategory = category.split(",");}
                Double minPrice = Double.parseDouble(request.getParameter("minPrice"));
                Double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
                if (request.getParameter("page") != null){page = Integer.parseInt(request.getParameter("page"));}
                int amount = Integer.parseInt(request.getParameter("amount"));
                Map<List<Product>, Integer> result = new Service().getProductBySearch(type, listCategory, minPrice, maxPrice, page, amount);
                Map<String, Object> listMap = new HashMap<>();
                result.forEach((K,V) ->{
                    listMap.put("ListProduct",K);
                    if (V % amount == 0) {
                        listMap.put("lastPage", V / amount);
                    } else {
                        listMap.put("lastPage", (V / amount) + 1);
                    }
                });
                listMap.put("page",page);
                Gson gson = new Gson();
                response.getWriter().write(gson.toJson(listMap));
            } else {
                Map<String, List<Product>> listMap = new HashMap<>();
                list = new Service().getProductByCategory(type, category);
                listMap.put("ListProduct", list);
                Gson gson = new Gson();
                response.getWriter().write(gson.toJson(listMap));
            }
        } else {
            List<Category> listCate = iCategoryService.ListCate();
            list = new Service().getProductByCategory(type, category);
            // Send back listProduct and listCategory to JSP
            request.setAttribute("category", category);
            request.setAttribute("ListP", list);
            request.setAttribute("ListC", listCate);
            request.getRequestDispatcher("/view/public/store.jsp").forward(request, response);
        }

        // Request from AJAX
//        if ("XMLHttpRequest".equals(ajaxHeader)) {
//            // Request data for list Product by category, minPrice, maxPrice and Current page
//            String type = request.getParameter("type");
//            String category = request.getParameter("category");
//            if (category != null) {
//                System.out.println("category = null");
//                list = new Service().getProductByCategory(type, category);
//            } else {
//                System.out.println("category != null");
//                String[] listCategory = request.getParameterValues("listCategory[]");
//                Double minPrice = Double.parseDouble(request.getParameter("minPrice"));
//                Double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
//                int page = Integer.parseInt(request.getParameter("page"));
//                int amount = Integer.parseInt(request.getParameter("amount"));
//                list = new Service().getProductBySearch(type, listCategory, minPrice, maxPrice, page, amount);
//            }
//            // Send back data to JSP
//            Map<String, List<Product>> listMap = new HashMap<>();
//            listMap.put("ListP", list);
//            Gson gson = new Gson();
//            response.getWriter().write(gson.toJson(listMap));
//        } else {
//            // Request from JSP
//            list = new Service().getProductByCategory("", request.getParameter("category"));
//            List<Category> listCate = iCategoryService.ListCate();
//            // Send back listProduct and listCategory to JSP
//            request.setAttribute("category", request.getParameter("category"));
//            request.setAttribute("ListP", list);
//            request.setAttribute("ListC", listCate);
//            request.setAttribute("test","chay dau");
//            request.getRequestDispatcher("/view/public/store.jsp").forward(request, response);
    }
}

