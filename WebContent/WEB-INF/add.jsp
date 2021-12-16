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
			<!-- home -->
			<jsp:include page="head.jsp"></jsp:include>
			<body>
				<div class="page-wrapper landrick-theme toggled">
		            <jsp:include page="includes/sideBar.jsp"></jsp:include>
		            <!-- Start Page Content -->
		            <main class="page-content bg-light">
		                <div class="container-fluid">
		                    <div class="layout-specing">
		                        <div class="d-md-flex justify-content-between align-items-center">
		                            <h5 class="mb-0">Ajouter un utilisateur</h5>
		
		                            <nav aria-label="breadcrumb" class="d-inline-block">
		                                <ul class="breadcrumb bg-transparent rounded mb-0 p-0">
		                                    <li class="breadcrumb-item text-capitalize"><a href="index.html">Accueil</a></li>
		                                    <li class="breadcrumb-item text-capitalize active" aria-current="page">Ajouter un utilisateur</li>
		                                </ul>
		                            </nav>
		                        </div>
		
		                        <div class="row">
		                            <div class="col-12 mt-4">
		                        		<div class="form-signin p-4 bg-white rounded shadow">
			                            	<form action="add" method="post">
				                                <h5 class="mb-3 text-center">Ajout d'un utilisateur</h5>
				                            
				                                <div class="form-floating mb-2">
				                                    <input value="${ sessionScope.addPayload.prenom }" type="text" class="form-control" id="floatingInput" name="prenom">
				                                    <label for="floatingInput">Prénom</label>
				                                </div>
				                            
				                                <div class="form-floating mb-2">
				                                    <input value="${ sessionScope.addPayload.nom }"  type="text" class="form-control" id="floatingInput" name="nom">
				                                    <label for="floatingInput">Nom</label>
				                                </div>
				                            
				                                <div class="form-floating mb-2">
				                                    <input value="${ sessionScope.addPayload.login }"  type="text" class="form-control" id="floatingInput" name="login">
				                                    <label for="floatingInput">Login</label>
				                                </div>
				                            
				                                <div class="form-floating mb-2">
				                                    <input type="password" class="form-control" id="floatingInput" name="password">
				                                    <label for="floatingInput">Mot de passe</label>
				                                </div>
				                            
				                                <div class="form-floating mb-2">
				                                    <input type="password" class="form-control" id="floatingInput" name="confirmPassword">
				                                    <label for="floatingInput">confirmer mot de passe</label>
				                                </div>
				                                
				                                <input class="btn btn-primary w-100" value="Valider" type="submit">
				                                
				                                <span class="text-danger">
				                                	<c:out value="${ param.error }"></c:out>
				                                </span>
				                                
			                            	</form>
		                            	</div><!--end form-signin-->
		                            </div><!--end col-->
		                        </div><!--end row-->
		
		                    </div>
		                </div><!--end container-->
		                
		                <!-- Footer Start -->
		                <footer class="bg-white shadow py-3">
		                    <div class="container-fluid">
		                        <div class="row align-items-center">
		                            <div class="col">
		                                <div class="text-sm-start text-center">
		                                    <!-- <p class="mb-0 text-muted">ï¿½ <script>document.write(new Date().getFullYear())</script> Landrick. Design with <i class="mdi mdi-heart text-danger"></i> by <a href="https://shreethemes.in/" target="_blank" class="text-reset">Shreethemes</a>.</p> -->
		                                </div>
		                            </div><!--end col-->
		                        </div><!--end row-->
		                    </div><!--end container-->
		                </footer><!--end footer-->
		            </main>
				</div>
			</body>			
		</c:when>	
	</c:choose>
</html>