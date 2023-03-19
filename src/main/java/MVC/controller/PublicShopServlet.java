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
import MVC.util.FileUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet(name = "PublicShopServlet", value = "/shop")
public class PublicShopServlet extends HttpServlet {
    private IShopService iShopService = new ShopService();
    private IProductService iProductService = new ProductService();
    private ICategoryService iCategoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null){
            actionUser = "";
        }
        Shop shop =null;
        int numpro = 0;
        ArrayList<Product> listPS = new ArrayList<>();
        switch (actionUser){
            case "addproduct":
                request.setAttribute("listCate",iCategoryService.ListCate());
                request.getRequestDispatcher("/view/public/addProduct.jsp").forward(request,response);
                break;
            case "view":
                int ids = 0;
                try {
                    ids = Integer.parseInt(request.getParameter("ids"));
                } catch (NumberFormatException e){
                }

                shop = iShopService.getShopAll(ids);

                listPS = iProductService.productShop(shop.getId());
                for (Product dem: listPS) {
                    numpro++;
                }
                request.setAttribute("numpro",numpro);
                request.setAttribute("listPS",listPS);
                request.setAttribute("shop",shop);
                request.getRequestDispatcher("/view/public/productHomepage.jsp").forward(request,response);
                break;
            default:
                HttpSession session = request.getSession();
                Users UserLogin = (Users) session.getAttribute("UserLogin");
                shop = iShopService.getShopAll(UserLogin.getId());

                listPS = iProductService.productShop(shop.getId());
                for (Product dem: listPS) {
                    numpro++;
                }
                request.setAttribute("numpro",numpro);
                request.setAttribute("listPS",listPS);
                request.setAttribute("shop",shop);
                request.getRequestDispatcher("/view/public/productHomepage.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Users UserLogin = (Users) session.getAttribute("UserLogin");
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null){
            actionUser = "";
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
        switch (actionUser){
            case "addproduct":
                shop = iShopService.getShop(UserLogin.getId());
                name = request.getParameter("name");
                price = request.getParameter("price");
                describe = request.getParameter("decription");
                detail = request.getParameter("details");
                id_cate = Integer.parseInt(request.getParameter("category"));
                category = new Category(id_cate,null);
                int quantity = Integer.parseInt(request.getParameter("quantity"));


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

                    response.sendRedirect(request.getContextPath() + "/shop?msg=1");
                    return;
                }else{
                    request.setAttribute("listCate",iCategoryService.ListCate());
                    request.getRequestDispatcher("/view/public/addProduct.jsp?err=1").forward(request,response);
                }
                break;
            default:
                shop = iShopService.getShopAll(UserLogin.getId());
                System.out.println(UserLogin.getId());
                request.setAttribute("listPS",iProductService.productShop(shop.getId()));
                System.out.println(iProductService.productShop(shop.getId()).size());
                request.setAttribute("shop",shop);
                request.getRequestDispatcher("/view/public/productHomepage.jsp").forward(request,response);
                break;
        }
    }
}
