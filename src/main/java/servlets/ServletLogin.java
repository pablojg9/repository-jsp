package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Login;
import utils.Message;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletLogin() {

    }

    // Recebe os dados pela url em parametros
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // Recebe os dados enviados por um formulario
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String login = request.getParameter("login");
       String password = request.getParameter("password");

       if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
           Login modelLogin = new Login();
           modelLogin.setLogin(login);
           modelLogin.setPassword(password);

           RequestDispatcher requestDispatcher;

           if (modelLogin.getLogin().equalsIgnoreCase("admin") && modelLogin.getPassword().equalsIgnoreCase("admin")) {
               requestDispatcher = request.getRequestDispatcher("main.jsp");
           } else {
               requestDispatcher = request.getRequestDispatcher("index.jsp");
               request.setAttribute("message", Message.MESSAGE_ERROR);
           }
           requestDispatcher.forward(request, response);

       } else {
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
           request.setAttribute("message", Message.MESSAGE_ERROR);
           requestDispatcher.forward(request, response);
       }
    }
}
