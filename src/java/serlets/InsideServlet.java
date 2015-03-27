/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serlets;

import beans.Categorie;
import beans.News;
import beans.Tags;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategorieModel;
import model.NewsModel;
import model.TagsModel;
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

                    List<Categorie> categories = new ArrayList<>();
                    categories = CategorieModel.getCategories(conn);
                    System.out.println("cat = " + categories.size());
                    request.setAttribute("liste", categories);
                    
                    request.getRequestDispatcher("/WEB-INF/view/categories/index.jsp").forward(request, response);
  
                    break;
                case "/news":
                    
                    List<News> news = new ArrayList<>();
                    news = NewsModel.getNews(conn);
                    System.out.println("cat = " + news.size());
                    request.setAttribute("liste", news);
                    
                    request.getRequestDispatcher("/WEB-INF/view/news/index.jsp").forward(request, response);
                    break;
                case "/tags":
                    
                    List<Tags> tags = new ArrayList<>();
                    tags = TagsModel.getTags(conn);
                    System.out.println("cat = " + tags.size());
                    request.setAttribute("liste", tags);
                    
                    request.getRequestDispatcher("/WEB-INF/view/tags/index.jsp").forward(request, response);
                    break;
            }
            
            
        } else {
            
            System.out.println("session pas ok ");
            request.getRequestDispatcher("/login").forward(request, response);
            
        }//fin session 

    }

}
