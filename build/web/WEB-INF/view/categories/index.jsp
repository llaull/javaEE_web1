<jsp:include page="../elements/headerMenu.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

  <h1>Catégories</h1>
  
  <a href="${pageContext.request.contextPath}/datasCategorie?action=1"><button type="button" class="btn btn-success">Ajouter</button></a>
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
        <td>${row.id}</td>
        <td>${row.value}</td>
        <td>
            <a href="<%=application.getContextPath()%>/datasCategorie?action=2&id=${row.id}"><button type="button" class="btn btn-warning btn-sm">Editer</button></a>
            <a href="<%=application.getContextPath()%>/datasCategorie?action=3&id=${row.id}"><button type="button" class="btn btn-danger btn-sm">Supprimer</button></a>
        </td>
    </tr>
    </c:forEach>
      
    </tbody>
  </table>
</div>
<jsp:include page="../elements/footer.jsp" />