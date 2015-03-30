<jsp:include page="../elements/headerMenu.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

    <h1>Datas news</h1>

    <c:if test="${param.action == 1 || param.action == 2}">

        <c:choose>
            <c:when test="${param.action == 1}">
                <h2>Creation</h2>
            </c:when>
            <c:when test="${param.action == 2}">
                <h2>Modifier</h2>
            </c:when>                    
        </c:choose>

        <!-- formulaire d'ajout et modification -->
        <form role="form" action="<%=application.getContextPath()%>/datasNews" method="post">

            <input type="hidden" id="id" name="id" value="${requestScope.t.id}"/>
            <input type="hidden" name="action" value="${param.action}"/>

            <div class="form-group">
                <label>Categorie de la news
                    <select id="categorie" name="categorie" class="form-control">
                        <c:forEach var="row" items="${requestScope.listeCategorie}">
                        <option ${(row.id == requestScope.n.categorie.id)?"selected='select'":""} value="${row.id}">${row.value}</option>
                        </c:forEach>
                    </select>
                </label> 
            </div>

            <div class="form-group">
                <label for="titre">titre de la news</label>
                <input type="input" id="titre" class="form-control" name="titre" value="${requestScope.n.titre}">
            </div>

            <div class="form-group">
                <label for="txt">texte de la news</label>
                <input type="input" id="txt" class="form-control" name="txt" value="${requestScope.n.txt}">
            </div>
            
            <button type="submit" class="btn btn-success">Submit</button>
            <a href="<%=application.getContextPath()%>/news"><button type="button" class="btn btn-warning">Annuler</button></a>
        </form>


    </c:if>

    <c:if test="${param.action == 3}">

        <div>suppression s : <strong>${requestScope.n.titre}</strong></div>
        <form action="<%=application.getContextPath()%>/datasNews" method="post">

            <input type="hidden" name="id" value="${requestScope.n.id}"/>
            <input type="hidden" name="action" value="${param.action}"/>

            <input type="hidden" name="value" value="${requestScope.n.titre}"/>

            <button type="submit" class="btn btn-success">Confirmer</button>
            <a href="<%=application.getContextPath()%>/news"><button type="button" class="btn btn-warning">Annuler</button></a>

        </form>

    </c:if>

</div>
<jsp:include page="../elements/footer.jsp" />