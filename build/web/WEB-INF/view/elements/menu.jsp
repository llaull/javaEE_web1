<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">demo JAVAEE</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="<%=application.getContextPath()%>/news">News</a></li>
        <li><a href="<%=application.getContextPath()%>/categories">Categories</a></li>
        <li><a href="<%=application.getContextPath()%>/tags">Tags</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="<%=application.getContextPath()%>/login"><span class="glyphicon glyphicon-user"></span> Login</a></li>
        <li><a href="<%=application.getContextPath()%>/deco"><span class="glyphicon glyphicon-log-in"></span> Deco</a></li>
      </ul>
    </div>
  </div>
</nav>
