package serlets;

import beans.Categorie;
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
import utils.DataManager;

/**
 *
 * @author Arkesys
 */
@WebServlet(name = "DatasServlet", urlPatterns = {"/datasCategorie"})

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
                            
                            CategorieModel.getCategorieByid(conn, cat);
                            System.out.println("->" + request.getParameter("id"));
                            System.out.println("->" + request.getParameter("value"));
                            request.setAttribute("cat", cat);
                            break;
                              
                    }
                    
                    request.getRequestDispatcher("/WEB-INF/view/categories/datas.jsp").forward(request, response);
                    
                }//action
                
            }//patern
            
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
                              
                }        
                    
                    
            }//action
            
        }//patern
        
        
    }

    

}
