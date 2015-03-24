package serlets;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Moi
 */
public class Entrance extends HttpServlet {
    
    private String name = "laul";
    private String pass = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("viewLogin.jsp").forward(request, response);
        out.println("get");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        out.println("post");
        
        if (request.getParameter("user").equals(name) && request.getParameter("pass").equals(pass)) {
            
            out.println("ok");
            HttpSession session = request.getSession(true);
            session.setAttribute("ok", "ok");
            request.getRequestDispatcher("viewAdmin.jsp").forward(request, response);
            
        } else {
            out.println("non !");
            request.setAttribute("error", "");
            request.getRequestDispatcher("viewLogin.jsp").forward(request, response);
        }
    }

}
