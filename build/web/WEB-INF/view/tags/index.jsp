<jsp:include page="../elements/headerMenu.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

  <h1>tags</h1>
  <a href="<%=application.getContextPath()%>/datasTags?action=1"><button type="button" class="btn btn-success">Ajouter</button></a>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>id</th>
        <th>Libell�</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach var="row" items="${requestScope.liste}">
    <tr>
        <td>${row.id}</td>
        <td>${row.value}</td>
        <td>
            <a href="<%=application.getContextPath()%>/datasTags?action=2&id=${row.id}"><button type="button" class="btn btn-warning btn-sm">Editer</button></a>
            <a href="<%=application.getContextPath()%>/datasTags?action=3&id=${row.id}"><button type="button" class="btn btn-danger btn-sm">Supprimer</button></a>
        </td>
    </tr>
    </c:forEach>
      
    </tbody>
  </table>
</div>
<jsp:include page="../elements/footer.jsp" />