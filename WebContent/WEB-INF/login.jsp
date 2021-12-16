<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
	</head>
	<jsp:include page="head.jsp"></jsp:include>
	<body>
        <!-- Hero Start -->
        <section class="bg-home bg-circle-gradiant d-flex align-items-center">
            <div class="bg-overlay bg-overlay-white"></div>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="form-signin p-4 bg-white rounded shadow">
                            <form action="login" method="post">
                                <a href="index.html"><img src="assets/images/logo-icon.png" class="avatar avatar-small mb-4 d-block mx-auto" alt=""></a>
                                <h5 class="mb-3 text-center">Connexion</h5>
                            
                                <div class="form-floating mb-2">
                                    <input type="text" class="form-control" name="login" id="floatingInput">
                                    <label for="floatingInput">Login</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="password" name="password" class="form-control" id="floatingPassword">
                                    <label for="floatingPassword">Mot de passe</label>
                                </div>
                            
                                <div class="d-flex justify-content-between">
                                    <div class="mb-3">
                                        <div class="form-check">
                                        	<label class="form-check-label text-danger" for="flexCheckDefault">
												<c:out value="${param.error}"></c:out>
											</label>
                                        </div>
                                    </div>
                                </div>
                				<input class="btn btn-primary w-100" type="submit" value="Se connecter">

                            </form>
                        </div>
                    </div>
                </div>
            </div> <!--end container-->
        </section><!--end section-->
        <!-- Hero End -->
	</body>
</html>