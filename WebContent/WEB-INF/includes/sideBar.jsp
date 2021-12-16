<%
	String APP_ROOT = request.getContextPath();
	String APP_PAGE = "Home";
%>
<nav id="sidebar" class="sidebar-wrapper sidebar-dark">
    <div class="sidebar-content" data-simplebar style="height: calc(100% - 60px);">
        <div class="sidebar-brand">
            <a href="<%=APP_ROOT%>">
                <h4>Dashboard</h4>
            </a>
        </div>
        
        
        <ul class="sidebar-menu">
            <li class="active"><a href="<%=APP_ROOT%>"><i class="ti ti-home me-2"></i>Dashboard</a></li>
            <li><a href="add"><i class="ti ti-user-plus me-2"></i>Ajouter un utilisateur</a></li>
        </ul>
        <!-- sidebar-menu  -->
    </div>
    <!-- Sidebar Footer -->
    <ul class="sidebar-footer list-unstyled mb-0">
        <li class="list-inline-item mb-0">
            <a href="logout" class="btn btn-icon btn-soft-danger"><i class="ti ti-settings"></i></a> <small class="text-danger ms-1">se déconnecter</small>
        </li>
    </ul>
    <!-- Sidebar Footer -->
</nav>
<!-- sidebar-wrapper  -->