/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DataManager;

/**
 *
 * @author Arkesys
 */
@WebServlet(name = "InsideServlet", urlPatterns = {"/inside","/categories","/tags","/news"})

public class InsideServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // connexion 
        DataManager dataManager = (DataManager)this.getServletContext().getAttribute("dataManager");
        
        Connection conn = dataManager.getConnection();
        
        System.out.println("conn " + conn);
        
        //check session et chemin
        String chemin = request.getServletPath();
        System.out.println("chemin =" + chemin);
        
        HttpSession session = request.getSession();
        System.out.println("session =" + session);
        
        //controle session
        if (session != null && session.getAttribute("ok")!= null) {
            
            System.out.println("ok");
            
            //gestions des pages/categories
            switch (chemin) {
                case "/login":
                case "/categories":
                    request.getRequestDispatcher("/WEB-INF/view/categories/index.jsp").forward(request, response);
                    break;
                case "/news":
                    request.getRequestDispatcher("/WEB-INF/view/news/index.jsp").forward(request, response);
                    break;
                case "/tags":
                    request.getRequestDispatcher("/WEB-INF/view/tags/index.jsp").forward(request, response);
                    break;
            }
            
            
        } else {
            
            System.out.println("session pas ok ");
            request.getRequestDispatcher("/login").forward(request, response);
            
        }//fin session 
        
                    
        
        

//        
//        if (session != null && session.getAttribute("ok")!= null) {
//            System.out.println("ok");
//            
//            if (chemin.equals("/inside")|| chemin.equals("/categorie")) {
//                
//                List<Categorie> categories = new ArrayList<>();
//                categorie = CategorieManager.getCategories(conn);
//                System.out.println("cat = " + categories.size());
//                
//                resq
//            }
//            
//        } else {
//            
//        }
    }


}
