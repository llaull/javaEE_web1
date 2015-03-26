<jsp:include page="../elements/headerMenu.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

  <h1>tags</h1>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>id</th>
        <th>Libellé</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach var="row" items="${requestScope.liste}">
    <tr>
        <td>${row.id_tag}</td>
        <td>${row.libelle}</td>
        <td>
            <a href="<%=application.getContextPath()%>/datasCategorie?action=1&id=${row.id_tag}"><button type="button" class="btn btn-warning btn-sm">Editer</button></a>
            <a href="<%=application.getContextPath()%>/datasCategorie?action=2&id=${row.id_tag}"><button type="button" class="btn btn-danger btn-sm">Supprimer</button></a>
        </td>
    </tr>
    </c:forEach>
      
    </tbody>
  </table>
</div>
<jsp:include page="../elements/footer.jsp" />