package MVC.controller;

import MVC.model.Config;
import MVC.model.Product;
import MVC.model.Users;
import MVC.service.Impl.Service;
import com.google.gson.Gson;
import org.json.simple.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet(urlPatterns = "/Payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = ((Users) session.getAttribute("UserLogin")).getUsername();
        Users customer = (Users) session.getAttribute("UserLogin");
        Map<String,String> resultPayment = new HashMap<>();
        Map<Product,Integer> parsedListCart = new HashMap<>();
        AtomicLong total = new AtomicLong();
        CartServlet.listCart.get(username).forEach((productId, qty) -> {
            Product product = new Service().getProductById(productId);
            parsedListCart.put(product,qty);
            total.set(Long.parseLong(String.valueOf(total)) + Long.parseLong(product.getPrice().replace(".", "")) * qty);

        });
        if (request.getParameter("vnp_TxnRef") != null){
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }
            resultPayment.put("code",String.valueOf(request.getParameter("vnp_TxnRef")));
            resultPayment.put("address",String.valueOf(request.getParameter("vnp_OrderInfo")));
            resultPayment.put("vnp_SecureHash",String.valueOf(request.getParameter("vnp_SecureHash")));
            resultPayment.put("bankCode",String.valueOf(request.getParameter("vnp_BankCode")));
            resultPayment.put("payDate",String.valueOf(request.getParameter("vnp_PayDate")));
            resultPayment.put("ResponseCode",String.valueOf(request.getParameter("vnp_ResponseCode")));
            resultPayment.put("method","VNPay");
            Gson gson = new Gson();
            System.out.println(gson.toJson(resultPayment));

            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);
        }else{
            String vnp_TxnRef = Config.getRandomNumber(8);
            resultPayment.put("code",vnp_TxnRef);
            resultPayment.put("payDate",String.valueOf(request.getParameter("vnp_PayDate")));
            resultPayment.put("address",String.valueOf(request.getParameter("address")));
            resultPayment.put("method","Cash");
            resultPayment.put("bankCode","None");
        };
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        resultPayment.put("payDate",dateFormat.format(cal.getTime()));
        request.setAttribute("customerInfo",customer);
        request.setAttribute("total",total);
        request.setAttribute("listCart",parsedListCart);
        request.setAttribute("result",resultPayment);
        request.setAttribute("discount",0);
        CartServlet.listCart.put(username, new HashMap<>());
        request.getRequestDispatcher("/view/public/invoice.jsp").forward(request,response);
    }
}
