<%-- 
      <h1>Param http : <%=request.getParameter("name")%></h1> <!-- en JAVA -->
      <h1>Attribut de requete : <%=request.getParameter("name")%></h1>
      <h1>Attribut de requete : ${param.name}</h1><!-- via EL Expression language -->
      <h1>Attribut de requete : ${requestScope.attributDerequete}</h1><!--  en el -->
      <%=request.getParameter("email")%>
--%>

<jsp:include page="WEB-INF/view/elements/header.jsp" />
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <div class="container">

      
      <form class="form-signin" role="form" method="POST" action="login">
          <h2>Form</h2>
        <div class="form-group">
          <label for="user">User</label>
          <input type="input" class="form-control" id="user" name="user" placeholder="Enter User">
        </div>
        <div class="form-group">
          <label for="pass">Password</label>
          <input type="password" class="form-control" id="pass" name="pass" placeholder="Enter password">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <% if (request.getAttribute("error")!=null) { %>
        <div>Error !</div>
        <% } %>
      </form>
    </div>

<jsp:include page="WEB-INF/view/elements/footer.jsp" />

