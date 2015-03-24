/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arkesys
 */
public class ServletOne extends HttpServlet {

   private String view = "/maPage.jsp";
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
                
        String nom = request.getParameter("nom");
        
        System.out.println("Nom => " + nom);
       /* try (PrintWriter out = response.getWriter()) {
        out.println("d->"+nom);
        }*/
        
        //on forward vers la page jsp
        this.getServletContext().getRequestDispatcher(view).forward(request, response);
        
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
       // this.getServletContext().getRequestDispatcher(view).forward(request, response);
    }

}
