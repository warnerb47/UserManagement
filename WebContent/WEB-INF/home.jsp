<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<c:choose>
		<c:when test="${empty sessionScope.currentUser}">
			<!-- login -->
			<c:import url="login.jsp"></c:import>
		</c:when>
		<c:when test="${!empty sessionScope.currentUser}">
			<!-- home page -->
			<jsp:include page="head.jsp"></jsp:include>
			<body>
				<div class="page-wrapper landrick-theme toggled">
		            <%-- <%@include file="includes/sideBar.jsp" %> --%>
		            <jsp:include page="includes/sideBar.jsp"></jsp:include>
		            <!-- Start Page Content -->
		            <main class="page-content bg-light">
		                <div class="container-fluid">
		                    <div class="layout-specing">
		                        <div class="d-md-flex justify-content-between align-items-center">
		                            <h5 class="mb-0">Liste des Utilisateurs</h5>
		
		                            <nav aria-label="breadcrumb" class="d-inline-block">
		                                <ul class="breadcrumb bg-transparent rounded mb-0 p-0">
		                                    <li class="breadcrumb-item text-capitalize"><a href="index.html">Accueil</a></li>
		                                    <li class="breadcrumb-item text-capitalize active" aria-current="page">Liste des Utilisateurs</li>
		                                </ul>
		                            </nav>
		                        </div>
		
								<span> <c:out value="${param.error}"/> </span>
		                        <div class="row">
		                            <div class="col-12 mt-4">
		                                <div class="table-responsive shadow rounded">
		                                    <table class="table table-center bg-white mb-0">
		                                        <thead>
		                                            <tr>
		                                                <th class="border-bottom p-3">Numéro</th>
		                                                <th class="border-bottom p-3" style="min-width: 220px;">Prénom</th>
		                                                <th class="border-bottom p-3" style="min-width: 200px;">Nom</th>
		                                                <th class="border-bottom p-3" style="min-width: 150px;">Login</th>
		                                                <th class="border-bottom p-3" style="min-width: 200px;">Action</th>
		                                            </tr>
		                                        </thead>
												<tbody>
													<c:forEach items="${requestScope.users}" var="user">
		 		                                            <tr>
				                                                <th class="p-3"> <c:out value="${user.id}"></c:out> </th>
				                                                <th class="p-3"> <c:out value="${user.prenom}"></c:out> </th>
				                                                <th class="p-3"> <c:out value="${user.nom}"></c:out> </th>
				                                                <th class="p-3"> <c:out value="${user.login}"></c:out> </th>
				                                                <td class="p-3">
				                                                    <a href="update?user=<c:out value="${user.id}" />" class="btn btn-sm btn-primary">Modifier</a>
				                                                    <a href="delete?user=<c:out value="${user.id}" />" class="btn btn-sm btn-danger">Supprimer</a>
				                                                </td>
				                                            </tr>
													</c:forEach>
												</tbody>
		                                    </table>
		                                </div>
		                            </div><!--end col-->
		                        </div><!--end row-->
		
		                    </div>
		                </div><!--end container-->
		                
			 				<%-- <%@include file="includes/footer.html" %> --%>
			 				<jsp:include page="includes/footer.jsp"></jsp:include>
		            </main>
				</div>
			</body>
		</c:when>
	</c:choose>

</html>