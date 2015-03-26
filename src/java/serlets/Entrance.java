package serlets;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DataManager;

/**
 *
 * @author Moi
 */
public class Entrance extends HttpServlet {
    
    private String name = "laul";
    private String pass = "1234";
    HttpSession session;

    /**
     * 
     * @param config
     * @throws ServletException 
     */
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        System.out.println("**** InsideServlet::init()");
        
        DataManager dataManager = new DataManager();
        dataManager.setDbURL(config.getInitParameter("dbURL"));
        dataManager.setDbUserName(config.getInitParameter("DbUserName"));
        dataManager.setDbPassword(config.getInitParameter("dbPassword"));
        
        this.getServletContext().setAttribute("dataManager", dataManager);
       
        System.out.println("data : " + dataManager);
        
        try {
            Class.forName(config.getInitParameter("jdbcDriver"));
            System.out.println("data 11: " + dataManager);
            
        } catch (Exception e) {
            
            System.out.println(e.toString());
            
        }
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //en test
        if(session == null){
            out.println("0");
        } else {
            out.println("1");            
        }
        
       /* if(session == null){
            out.println("getAttribute");
            request.getRequestDispatcher("viewAdmin.jsp").forward(request, response);
        } else {*/
        request.getRequestDispatcher("viewLogin.jsp").forward(request, response);
        out.println("get");
       // }
        
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        out.println("post");
        
        if (request.getParameter("user").equals(name) && request.getParameter("pass").equals(pass)) {
            
            out.println("ok");
            session = request.getSession(true);
            session.setAttribute("ok", "ok");
            request.getRequestDispatcher("viewAdmin.jsp").forward(request, response);
            
        } else {
            out.println("non !");
            request.setAttribute("error", "");
            request.getRequestDispatcher("viewLogin.jsp").forward(request, response);
        }
    }

}
