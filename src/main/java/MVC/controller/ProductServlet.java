package MVC.controller;

import MVC.model.Category;
import MVC.model.Product;
import MVC.model.Shop;
import MVC.model.Users;
import MVC.service.ICategoryService;
import MVC.service.IProductService;
import MVC.service.IShopService;
import MVC.service.Impl.CategoryService;
import MVC.service.Impl.ProductService;
import MVC.service.Impl.ShopService;
import MVC.util.DefineUtil;
import MVC.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ProductServlet", value = "/admin/product")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();
    private ICategoryService iCategoryService = new CategoryService();
    private IShopService iShopService = new ShopService();
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
        Shop shop = null;

        switch (actionUser){
            case "add":
                if(!UserLogin.getRole().equals("Producter")){
                    response.sendRedirect(request.getContextPath() + "/admin/product?err=3");
                    return;
                }else{
                    shop = iShopService.getShop(UserLogin.getId());
                    if(shop == null){
                        response.sendRedirect(request.getContextPath() + "/admin/product?err=4");
                        return;
                    }
                }
                request.setAttribute("categoris", iCategoryService.ListCate());
                request.getRequestDispatcher("/view/admin/product/add.jsp").forward(request,response);
                break;
            case "edit":

                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/product?err=1");
                    return;
                }
                Product prt = iProductService.findAll(id);
                request.setAttribute("categoris", iCategoryService.ListCate());
                request.setAttribute("product", prt);
                request.getRequestDispatcher("/view/admin/product/edit.jsp").forward(request,response);
                break;
            case "del":

                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/product?err=1");
                    return;
                }
                Product pr = iProductService.findAll(id);

                if(iProductService.del(id) > 0 ){
                    //xóa ảnh
                    final String dirPathName = "C:/Users/ASUS/IdeaProjects/TrueMart/src/main/webapp/files";
                    String picture = pr.getImage();
                    if(!picture.isEmpty()){
                        String filePathName = dirPathName + File.separator + picture;
                        File file = new File(filePathName);
                        if(file.exists()){
                            file.delete();
                        }
                    }
                    response.sendRedirect(request.getContextPath() + "/admin/product?msg=3");
                    return;
                }else{
                    response.sendRedirect(request.getContextPath() + "/admin/product?err=2");
                }
                break;
            default:
                request.setAttribute("productList", iProductService.productList());
                request.getRequestDispatcher("/view/admin/product/index.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
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
        String search = request.getParameter("search");
        if(search != null && !search.equals("")){
            request.setAttribute("productList", iProductService.search(search));
            request.getRequestDispatcher("/view/admin/product/index.jsp").forward(request,response);
            return;
        }
        List<Users> usersList = new ArrayList<>();
        String shop_id = null;
        String name = null;
        Shop shop = null;
        String price = null;
        String describe = null;
        Category category = null;
        String detail = null;
        Product product = null;
        int id_cate = 0;
        int quantity = 0;
        switch (actionUser){
            case "add":
                shop = iShopService.getShop(UserLogin.getId());
                name = request.getParameter("name");
                price = request.getParameter("price");
                describe = request.getParameter("describe");
                detail = request.getParameter("detail");
                id_cate = Integer.parseInt(request.getParameter("category"));
                category = new Category(id_cate,null);
                quantity = Integer.parseInt(request.getParameter("quantity"));


                Part filePart = request.getPart("image");


                String fileName = FileUtil.getName(filePart);
                String image = FileUtil.rename(fileName);
                product = new Product(0,name,null,category,shop,image, price, describe,detail,quantity);
                if(iProductService.creat(product) > 0){
                    Product productnew = iProductService.newPro();
                    final String dirPathName = request.getServletContext().getRealPath("/templates/public/img/total_category/"+productnew.getId());
                    File dirFile = new File(dirPathName);
                    if(!dirFile.exists()){
                        dirFile.mkdirs();
                    }
                    String filePathName = dirPathName + File.separator + image;
                    //ghi file
                    if(!fileName.isEmpty()){
                        filePart.write(filePathName);
                    }

                    response.sendRedirect(request.getContextPath() + "/admin/product?msg=1");
                    return;
                }else{
                    request.setAttribute("product",product);
                    request.setAttribute("productList", iProductService.productList());
                    request.getRequestDispatcher("/view/admin/product/add.jsp?err=1").forward(request,response);
                }
                break;
            case "edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath() + "/admin/product?err=1");
                    return;
                }
                Product pr = iProductService.findAll(id);
                name = request.getParameter("name");
                price = request.getParameter("price");
                describe = request.getParameter("describe");
                detail = request.getParameter("detail");
                id_cate = Integer.parseInt(request.getParameter("category"));
                category = new Category(id_cate,null);
                quantity = Integer.parseInt(request.getParameter("quantity"));

                Part fileParte = request.getPart("image");
                // tạo thư mục lưu ảnh
                final String dirPathName = request.getServletContext().getRealPath("/templates/public/img/total_category/"+id);
                File dirFilee = new File(dirPathName);
                if(!dirFilee.exists()){
                    dirFilee.mkdirs();
                }

                // lấy tên file từ part
                String fileNamee = FileUtil.getName(fileParte);
                // đổi tên file
                String imagee = "";
                if(fileNamee.isEmpty()){
                    imagee = pr.getImage();
                } else{
                    imagee = FileUtil.rename(fileNamee);
                }
                String filePathNamee = dirPathName + File.separator + imagee;

                product = new Product(id,name,category,null,imagee, price, describe,detail,quantity);
                if(iProductService.edit(product) > 0){
                    if(!fileNamee.isEmpty()){
                        //xóa file cũ
                        String oldFilePathName = dirPathName + File.separator + pr.getImage();
                        File oldFile = new File(oldFilePathName);
                        if(oldFile.exists()){
                            oldFile.delete();
                        }

                        //ghi file
                        fileParte.write(filePathNamee);
                    }
                    response.sendRedirect(request.getContextPath() + "/admin/product?msg=2");
                    return;
                }else{
                    request.setAttribute("categoris", iCategoryService.ListCate());
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("/view/admin/product/add.jsp?err=1").forward(request,response);
                }
                break;
            default:
                request.setAttribute("productList", iProductService.productList());
                request.getRequestDispatcher("/view/admin/product/index.jsp").forward(request,response);
                break;
        }
    }
}
