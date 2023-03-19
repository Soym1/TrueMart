package MVC.controller;


import MVC.model.Messages;
import MVC.model.User;
import MVC.respository.impl.BaseRespositoryChat;
import MVC.service.Impl.ServiceChat;
import com.google.gson.Gson;
import MVC.service.Impl.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<String> listSenderById = new ServiceChat().getListContact(String.valueOf(user.getUser_id()));
            List<String> listSenderByName = new ServiceChat().getListSenderByName(listSenderById);
            Map<String, List<String>> listUsers = new HashMap<>();
            listUsers.put("listSenderById", listSenderById);
            listUsers.put("listSenderByName", listSenderByName);
            json = gson.toJson(listUsers);
            printWriter.print(json);
            printWriter.close();
        }
        if (req.getParameter("search") != null){
            String search = String.valueOf(req.getParameter("search"));
            List<String> listSenderById = new ServiceChat().getListSearch(search);
            List<String> listSenderByName = new ServiceChat().getListSenderByName(listSenderById);
            Map<String, List<String>> listUsers = new HashMap<>();
            listUsers.put("listSenderById", listSenderById);
            listUsers.put("listSenderByName", listSenderByName);
            json = gson.toJson(listUsers);
            printWriter.print(json);
            printWriter.close();
        }
        if ((req.getParameter("userId") != null) && (req.getParameter("senderId") != null)) {
            int idUserReceiver = Integer.parseInt(req.getParameter("userId"));
            int idUserSender = Integer.parseInt(req.getParameter("senderId"));
            //      Gui du lieu ve Client
            List<Messages> listMessages = new BaseRespositoryChat().getMessage_2(idUserReceiver, idUserSender);
            json = gson.toJson(listMessages);
            printWriter.print(json);
            printWriter.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}