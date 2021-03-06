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
@WebServlet(name = "DatasServlet", urlPatterns = {"/datasCategorie", "/datasTags", "/datasNews"})

public class DatasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet");

        DataManager dataManager = (DataManager) this.getServletContext().getAttribute("dataManager");

        Connection conn = dataManager.getConnection();

        HttpSession session = request.getSession();

        //controle session
        if (session != null && session.getAttribute("ok") != null) {

            //controle du patern
            String path = request.getServletPath();
            if (path.equals("/datasCategorie")) {

                Categorie cat;

                //controle action
                if (request.getParameter("action") != null) {

                    switch (Integer.parseInt(request.getParameter("action"))) {

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
            else if (path.equals("/datasTags")) {

                System.out.println("datasTags");

                Tags t;
                News n;

                //controle action
                if (request.getParameter("action") != null) {

                    switch (Integer.parseInt(request.getParameter("action"))) {

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

            }//patern -> datasCategorie
            else if (path.equals("/datasNews")) {

                System.out.println("datasNews");

                News n;
                List<Categorie> categories = new ArrayList<>();
                categories = CategorieModel.getCategories(conn);

                //controle action
                if (request.getParameter("action") != null) {

                    switch (Integer.parseInt(request.getParameter("action"))) {

                        case 1:
                            System.out.println("1");
                            request.setAttribute("listeCategorie", categories);
                            break;

                        //selectionne l'élément
                        case 2:
                            System.out.println("modif 2");
                            n = new News();
                            n.setId(Integer.parseInt(request.getParameter("id")));
                            request.setAttribute("n", n);
                            request.setAttribute("listeCategorie", categories);

                            NewsModel.getNewsByid(conn, n);

                            System.out.println("->" + request.getParameter("id"));

                            request.setAttribute("n", n);
                            break;
                        case 3:
                            System.out.println("del -> 3");
                            n = new News();
                            n.setId(Integer.parseInt(request.getParameter("id")));
                            n.setTitre(request.getParameter("titre"));
                            n.setTxt(request.getParameter("txt"));

                            NewsModel.getNews(conn);
                            System.out.println("->" + request.getParameter("id"));
                            request.setAttribute("n", n);

                            break;

                        case 4:
                            System.out.println("les tagzzzzzzzzzzzzz");
                            n = new News();
                            n.setId(Integer.parseInt(request.getParameter("id")));
                            
                            request.setAttribute("n", n);

                            List<Tags> listeTags = new ArrayList<>();
                            listeTags = TagsModel.getTags(conn);

                            NewsModel.getNewsTags(conn, n);
                            
                            System.out.println("->" + n.getNewsTags().size());

                            for (int i = 0; i < n.getNewsTags().size(); i++) {
                                for (int j = 0; j < listeTags.size(); j++) {
                                    if (listeTags.get(j).getValue().equals(n.getNewsTags().get(i).getValue())) {
                                        listeTags.remove(j);
                                    }

                                }

                            }
                            request.setAttribute("listeTags",listeTags);

                            break;

                    }

                    request.getRequestDispatcher("/WEB-INF/view/news/datas.jsp").forward(request, response);

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

        DataManager dataManager = (DataManager) this.getServletContext().getAttribute("dataManager");

        Connection conn = dataManager.getConnection();

        HttpSession session = request.getSession();

        String path = request.getServletPath();
        System.out.println("-> " + path);
        if (path.equals("/datasCategorie")) {

            //instance de l'entité concernée
            Categorie cat = new Categorie();

            //nourriture de l'objet depuis le formulaire
            cat.setValue(request.getParameter("value"));

            if (request.getParameter("action") != null) {

                switch (Integer.parseInt(request.getParameter("action"))) {

                    case 1:
                        System.out.println("1 - insert");
                        CategorieModel.insertCategorie(conn, cat);
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
                        break;

                }

                request.getRequestDispatcher("/categories").forward(request, response);
            }//action

        }//patern -> datasCategorie
        else if (path.equals("/datasTags")) {

            //instance de l'entité concernée
            Tags t = new Tags();

            //nourriture de l'objet depuis le formulaire
            t.setValue(request.getParameter("value"));

            if (request.getParameter("action") != null) {

                switch (Integer.parseInt(request.getParameter("action"))) {

                    case 1:
                        System.out.println("1 - insert");
                        TagsModel.insert(conn, t);
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
                        break;

                }

            }//action

            request.getRequestDispatcher("/tags").forward(request, response);
        }//patern -> datasNews
        else if (path.equals("/datasNews")) {

            //instance de l'entité concernée
            News n = new News();

            //nourriture de l'objet depuis le formulaire
            n.setTitre(request.getParameter("titre"));

            if (request.getParameter("action") != null) {

                switch (Integer.parseInt(request.getParameter("action"))) {

                    case 1:
                        System.out.println("1 - insert");
                        n.setTitre(request.getParameter("titre"));
                        n.setTxt(request.getParameter("txt"));
                        n.getCategorie().setId(Integer.parseInt(request.getParameter("categorie")));

                        NewsModel.insert(conn, n);
                        System.out.println("id cat -> " + request.getParameter("titre"));
                        break;
                    case 2:
                        System.out.println("2 - update");

                        n.setId(Integer.parseInt(request.getParameter("id")));
                        n.setTitre(request.getParameter("titre"));
                        n.setTxt(request.getParameter("txt"));
                        n.getCategorie().setId(Integer.parseInt(request.getParameter("categorie")));

                        NewsModel.modify(conn, n);
                        break;
                    case 3:
                        System.out.println("3 - delation " + request.getParameter("id"));

                        n.setId(Integer.parseInt(request.getParameter("id")));
                        NewsModel.delete(conn, n);
                        System.out.println("id cat ->" + n.getId());
                        break;
                    case 4:
                        System.out.println("les posty");
                        
                        n.setId(Integer.parseInt(request.getParameter("id")));
                        
                        String[] newsTags = request.getParameterValues("newTags");
                        
                        if(newsTags != null ){
                            for (int i = 0; i < newsTags.length; i++) {

                                n.getNewsTags().add(new Tags());
                                n.getNewsTags().get(i).setId(Integer.parseInt(newsTags[i]));

                            }
                        }
                        
                        //affiche les id 
                        for (Tags i : n.getNewsTags()) {
                            System.out.println("->" + i.getId());
                        }
                        
                        NewsModel.updateNewsTags(conn,n);
                        break;

                }

            }//action

            request.getRequestDispatcher("/news").forward(request, response);
        }//

    }

}
