package MVC.controller;


import MVC.model.Messages;
import MVC.model.User;
import MVC.model.Users;
import MVC.respository.impl.ChatRepository;
import MVC.service.Impl.ServiceChat;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/chatData"})
public class ChatServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        String json;
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        if (req.getParameter("username") != null) {
            String username = String.valueOf(req.getParameter("username"));
            String userId = new ServiceChat().getIdByName(username);
            User user = new ServiceChat().getUser(username);
            List<Integer> listID =  new ServiceChat().getListContact(user.getUser_id());
            List<String> listUserName = new ServiceChat().getListUserNameByID(listID);
            List<String> listName = new ServiceChat().getListNameByID(listID);
            List<String> listShopName = new ServiceChat().getListShopNameByID(listID);
            Map<String, List<String>> listUsers = new HashMap<>();
            listUsers.put("listID", listID.stream().map(String::valueOf).collect(Collectors.toList()));
            listUsers.put("listUserName", listUserName);
            listUsers.put("listName", listName);
            listUsers.put("listShopName", listShopName);
            json = gson.toJson(listUsers);
            printWriter.print(json);
            printWriter.close();
        }
        if (req.getParameter("search") != null){
            String search = String.valueOf(req.getParameter("search"));
            List<Integer> listID = new ServiceChat().getListSearch(search);
            List<String> listUserName = new ServiceChat().getListUserNameByID(listID);
            List<String> listName = new ServiceChat().getListNameByID(listID);
            List<String> listShopName = new ServiceChat().getListShopNameByID(listID);
            Map<String, List<String>> listUsers = new HashMap<>();
            listUsers.put("listID", listID.stream().map(String::valueOf).collect(Collectors.toList()));
            listUsers.put("listUserName", listUserName);
            listUsers.put("listName", listName);
            listUsers.put("listShopName", listShopName);
            json = gson.toJson(listUsers);
            printWriter.print(json);
            printWriter.close();
        }
        if (req.getParameter("userId") != null){
            System.out.println("LINk "+ req.getServletPath());
            HttpSession session = req.getSession();
            int idUserSender = ((Users) session.getAttribute("UserLogin")).getId();
            int idUserReceiver = Integer.parseInt(req.getParameter("userId"));
            if (req.getParameter("maxAmountChatRecords") != null){
                int maxAmountChatRecords = new ServiceChat().getMaxChatRecords(idUserSender,idUserReceiver);
                printWriter.print(maxAmountChatRecords);
                System.out.println(maxAmountChatRecords + " max");
            } else {
                int indexLoadChat = Integer.parseInt(req.getParameter("indexLoadChat"));
                //      Gui du lieu ve Client
                List<Messages> listMessages = new ServiceChat().getMessage_2(idUserReceiver, idUserSender,indexLoadChat);
                json = gson.toJson(listMessages);
                printWriter.print(json);
            }
            printWriter.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}