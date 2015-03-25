/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        String chemin = request.getServletPath();
        System.out.println("chemin =" + chemin);
        
        HttpSession session = request.getSession();
        System.out.println("session =" + session);
        
        //controle session
        if (session != null && session.getAttribute("ok")!= null) {
            
            System.out.println("ok");
            
            //gestions des pages/categories
            if (chemin.equals("/login") || chemin.equals("/categories")) {
                
                request.getRequestDispatcher("/WEB-INF/view/categories/index.jsp").forward(request, response);
                
            } else if(chemin.equals("/news")){
                
                request.getRequestDispatcher("/WEB-INF/view/news/index.jsp").forward(request, response);
                
            } else if(chemin.equals("/tags")){
                
                request.getRequestDispatcher("/WEB-INF/view/tags/index.jsp").forward(request, response);
                
            }
            
            
        } else {
            
            System.out.println("session pas ok ");
            request.getRequestDispatcher("/login").forward(request, response);
            
        }//fin session 
        
                    
        
        
//        DataManager dataManager = (DataManager)this.getServletContext().getAttribute("dataManger");
//        
//        Connection conn = dataManager.getConnection();
//        
//        System.out.println("conn " + conn);
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
