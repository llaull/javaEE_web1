<jsp:include page="../elements/headerMenu.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

    



    

  <h1>Datas Catégories</h1>
  Action == ${param.action} - Id == ${sessionScope.id}
  
   <c:if test="${param.action == 1 || param.action == 2}">

  <h2>Creation</h2>
  <form role="form" action="<%=application.getContextPath()%>/datasCategorie" method="post">
      
    <input type="input" name="id_categorie" value="${requestScope.cat.id}"/>
    <input type="input" name="action" value="${param.action}"/>
            
    <div class="form-group">
      <label for="value">non de la vategorie</label>
      <input id="value" type="input" class="form-control" name="value" value="${requestScope.cat.value}">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
    </c:if>
    
   <c:if test="${param.action == 3}">
       <div>suppression  : ${requestScope.cat.value}</div>
       <form action="<%=application.getContextPath()%>/datasCategories" method="post">
           
            <input type="hidden" name="id_categorie" value="${requestScope.cat.id}"/>
            <input type="hidden" name="action" value="${param.action}"/>
            
            <input type="hidden" name="value" value="${requestScope.cat.value}"/>
            
            <input type="submit" value="go  ! "/>
            
       </form>
    </c:if>

</div>
<jsp:include page="../elements/footer.jsp" />