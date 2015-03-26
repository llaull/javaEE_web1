<jsp:include page="../elements/headerMenu.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

  <h1>Catégories</h1>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>id</th>
        <th>Libellé</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach var="row" items="${requestScope.listeCategorie}">
    <tr>
        <td>${row.id_categorie}</td>
        <td>${row.libelle}</td>
        <td>
            <button type="button" class="btn btn-warning btn-sm">Editer</button>
            <button type="button" class="btn btn-danger btn-sm">Supprimer</button>
        </td>
    </tr>
    </c:forEach>
      
    </tbody>
  </table>
</div>
<jsp:include page="../elements/footer.jsp" />