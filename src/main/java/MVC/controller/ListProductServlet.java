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
//        if (request.getParameter("category") != null){
        if ("XMLHttpRequest".equals(ajaxHeader)) {
            String type = request.getParameter("type");
            String category = request.getParameter("category");
            if (type.equals("search")){
                System.out.println("type: "+type);
                String[] listCategory = request.getParameterValues("listCategory[]");
                Double minPrice = Double.parseDouble(request.getParameter("minPrice"));
                Double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
                int page = Integer.parseInt(request.getParameter("page"));
                list = new Service().getProductBySearch(type,listCategory,minPrice,maxPrice,page);
            } else{
                list = new Service().getProductByCategory(type, category);
            }
            Map<String, List<Product>> listMap = new HashMap<>();
            listMap.put("Product", list);
            Gson gson = new Gson();
            response.getWriter().write(gson.toJson(listMap));
//            Gson gson = new Gson();
//            list.forEach(element -> {
//                listGson.put(element.getId(),gson.toJson(element));
//            });
//            response.getWriter().write(gson.toJson(list));
        } else {
            if (request.getParameter("category") != null){
                 list = new Service().getProductByCategory("",request.getParameter("category"));
                 request.setAttribute("category",request.getParameter("category"));
            }else{
                 list = new Service().getProductByCategory("",null);
            }
            List<Category> listCate = iCategoryService.ListCate();
            request.setAttribute("ListP", list);
            request.setAttribute("ListC", listCate);
            request.getRequestDispatcher("/view/public/store.jsp").forward(request, response);
        }

//        } else {
//            List<Product> list = new Service().getAllProduct();
//            List<Category> listCate = iCategoryService.ListCate();
//            request.setAttribute("ListC", listCate);
//            request.setAttribute("ListP", list);
//            // set data to jsp
//            request.getRequestDispatcher("/view/public/store.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
