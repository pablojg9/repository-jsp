package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import utils.Message;

import java.io.IOException;

@WebFilter(urlPatterns = {"/main/*"}) //Intercepta todas as requisições que vierem do projeto ou mapeamento
public class FilterAuthentication implements Filter {
    //Encerra os processos quando o servidor é parado
    //Encerraria o processo com a conexão com o banco
    public void destroy() {
    }
    //Incia os processos ou recursos quando o servidor sobe o projeto
    //ex. iniciar a conexão com o banco
    public void init(FilterConfig config) throws ServletException {
    }

    //Intercepta as requisições e a respostas do sistema
    //Tudo o que fizermos do sistema irá passar pelo metodo doFilter()
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession hasSession = req.getSession();

        String userLogged = (String) hasSession.getAttribute("user");

        String urlAuthenticate = req.getServletPath();//URL está sendo acessado

        if (userLogged == null || (userLogged != null && userLogged.isEmpty()) &&
            !urlAuthenticate.contains("ServletLogin")) { //Não está logado

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp?url=" + urlAuthenticate);
            request.setAttribute("msg", Message.MESSAGE_AUTHENTICATE);

            requestDispatcher.forward(request, response);

            return; // Para a execução e redireciona para o login
        }

        chain.doFilter(request, response);
    }
}
