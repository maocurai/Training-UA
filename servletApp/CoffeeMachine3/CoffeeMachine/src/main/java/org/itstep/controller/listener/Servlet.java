//package org.itstep.controller.listener;
//
//import org.itstep.controller.command.Command;
//import org.itstep.controller.command.Exception;
//import org.itstep.controller.command.LogOut;
//import org.itstep.controller.command.Login;
//import org.itstep.controller.command.Registration;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//
//public class Servlet extends HttpServlet {
//
//    private Map<String, Command> commands = new HashMap<>();
//
//    public void init(ServletConfig servletConfig){
//
//        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
//
//        commands.put("logout", new LogOut());
//        commands.put("exception" , new Exception());
//    }
//
//    public void doGet(HttpServletRequest request,
//                      HttpServletResponse response)
//            throws IOException, ServletException {
//        processRequest(request, response);
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        processRequest(request, response);
//    }
//
//    private void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String path = request.getRequestURI();
//        path = path.replaceAll(".*/app/" , "");
//        System.out.println("path: " + path);
//        Command command = commands.getOrDefault(path ,
//                (r)->"/index.jsp");
//        System.out.println(command.getClass().getName());
//        String page = command.execute(request);
//        request.getRequestDispatcher(page).forward(request,response);
////        if(page.contains("redirect:")){
////            response.sendRedirect(page.replace("redirect:", "/coffee"));
////        }else {
////            request.getRequestDispatcher(page).forward(request, response);
////        }
//    }
//}