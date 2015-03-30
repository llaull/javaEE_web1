package serlets;

import beans.Categorie;
import beans.Tags;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategorieModel;
import model.TagsModel;
import utils.DataManager;

/**
 *
 * @author Arkesys
 */
@WebServlet(name = "DatasServlet", urlPatterns = {"/datasCategorie","/datasTags"})

public class DatasServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet");
        
        DataManager dataManager = (DataManager)this.getServletContext().getAttribute("dataManager");
        
        Connection conn = dataManager.getConnection();

        HttpSession session = request.getSession();
        
        //controle session
        if (session != null && session.getAttribute("ok")!= null) {
            
            //controle du patern
            String path = request.getServletPath();
            if (path.equals("/datasCategorie")) {
                
                Categorie cat;
                
                //controle action
                if(request.getParameter("action") != null){
                    
                    switch(Integer.parseInt(request.getParameter("action"))){
                        
                        case 1:
                            System.out.println("1");
                            break;
                        
                            //selectionne l'élément
                        case 2:
                            System.out.println("2");
                            cat = new Categorie();
                            cat.setId(Integer.parseInt(request.getParameter("id")));
                            cat.setValue(request.getParameter("value"));
                            
                            CategorieModel.getCategorieByid(conn, cat, "categories");
                            System.out.println("->" + request.getParameter("id"));
                            System.out.println("->" + request.getParameter("value"));
                            request.setAttribute("cat", cat);
                            break;
                        case 3:
                            System.out.println("3");
                            cat = new Categorie();
                            cat.setId(Integer.parseInt(request.getParameter("id")));
                            cat.setValue(request.getParameter("value"));
                            
                            CategorieModel.getCategorieByid(conn, cat, "categories");
                            System.out.println("->" + request.getParameter("id"));
                            System.out.println("->" + request.getParameter("value"));
                            request.setAttribute("cat", cat);
                            
                            break;
                              
                    }
                    
                    request.getRequestDispatcher("/WEB-INF/view/categories/datas.jsp").forward(request, response);
                    
                }//action 
                
            }//patern -> datasCategorie
            else if(path.equals("/datasTags")) {
                
                System.out.println("datasTags");
                
                Tags t;
                
                //controle action
                if(request.getParameter("action") != null){
                    
                    switch(Integer.parseInt(request.getParameter("action"))){
                        
                        case 1:
                            System.out.println("1");
                            break;
                        
                            //selectionne l'élément
                        case 2:
                            System.out.println("2");
                            t = new Tags();
                            t.setId(Integer.parseInt(request.getParameter("id")));
                            t.setValue(request.getParameter("value"));
                            
                            TagsModel.getTagsByid(conn, t, "tags");
                            System.out.println("->" + request.getParameter("id"));
                            System.out.println("->" + request.getParameter("value"));
                            request.setAttribute("t", t);
                            break;
                        case 3:
                            System.out.println("del -> 3");
                            t = new Tags();
                            t.setId(Integer.parseInt(request.getParameter("id")));
                            t.setValue(request.getParameter("value"));
                            
                            TagsModel.getTagsByid(conn, t, "tags");
                            System.out.println("->" + request.getParameter("id"));
                            System.out.println("->" + request.getParameter("value"));
                            request.setAttribute("t", t);
                            
                            break;
                              
                    }
                    
                    request.getRequestDispatcher("/WEB-INF/view/tags/datas.jsp").forward(request, response);
                    
                }//action 
                
            }
            
        }//session
        else {
            System.out.println("session pas ok ");
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("doPost");
        
        DataManager dataManager = (DataManager)this.getServletContext().getAttribute("dataManager");
        
        Connection conn = dataManager.getConnection();

        HttpSession session = request.getSession();
        
        String path = request.getServletPath();
        System.out.println("-> " + path);
        if (path.equals("/datasCategorie")) {
            
            //instance de l'entité concernnné
            Categorie cat = new Categorie();
            
            //nourriture de l'obet depuis le formulaire
            cat.setValue(request.getParameter("value"));
            
            if(request.getParameter("action") != null){
                
                switch(Integer.parseInt(request.getParameter("action"))){
                        
                    case 1:
                        System.out.println("1 - insert");
                        CategorieModel.insertCategorie(conn, cat);
                        //System.out.println("id cat ->"+ cat.getId());
                    break;
                    case 2:
                        System.out.println("2 - update");
                        
                         cat.setId(Integer.parseInt(request.getParameter("id")));
                         cat.setValue(request.getParameter("value"));
                            
                        System.out.println("id cat -> " + cat.getId() + " < label > " + cat.getValue());
                        CategorieModel.modifyCategorie(conn, cat);
                    break;
                    case 3:
                        System.out.println("3 - delation");
                        
                        cat.setId(Integer.parseInt(request.getParameter("id")));
                        CategorieModel.deleteCategorie(conn, cat);
                        //System.out.println("id cat ->"+ cat.getId());
                    break;                        
                        
                }        
                    
             request.getRequestDispatcher("/categories").forward(request, response);       
            }//action
            
        }//patern -> datasCategorie
        else if(path.equals("/datasTags")) {
            
            //instance de l'entité concernnné
            Tags t = new Tags();
            
            //nourriture de l'obet depuis le formulaire
            t.setValue(request.getParameter("value"));
            
            if(request.getParameter("action") != null){
                
                switch(Integer.parseInt(request.getParameter("action"))){
                        
                    case 1:
                        System.out.println("1 - insert");
                        TagsModel.insert(conn, t);
                        //System.out.println("id cat ->"+ cat.getId());
                    break;
                    case 2:
                        System.out.println("2 - update");
                        
                         t.setId(Integer.parseInt(request.getParameter("id")));
                         t.setValue(request.getParameter("value"));
                            
                        System.out.println("id cat -> " + t.getId() + " < label > " + t.getValue());
                        TagsModel.modify(conn, t);
                    break;
                    case 3:
                        System.out.println("3 - delation " + request.getParameter("id"));
                        
                        t.setId(Integer.parseInt(request.getParameter("id")));
                        TagsModel.delete(conn, t);
                        //System.out.println("id cat ->"+ cat.getId());
                    break;                        
                        
                }        
                    
                    
            }//action
            
            request.getRequestDispatcher("/tags").forward(request, response);
        }
        
        
    }

    

}
