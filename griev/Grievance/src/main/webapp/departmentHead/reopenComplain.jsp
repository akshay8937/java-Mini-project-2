<%@page import="com.cybage.model.Complain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<%-- Link the Bootstrap css and js and Jquery files --%>

<link rel="stylesheet" href="styles.css">
<script defer
	src="<%=request.getContextPath()%>/src/main/webapp/css/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/src/main/webapp/css/bootstrap.css">
<script defer
	src="<%=request.getContextPath()%>/src/main/webapp/css/bootstrap.js"></script>

<script defer src="script.js"></script>
</head>

<body>

<!-- Navigation bar Of Department Head page -->


	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<a href="home.html" class="navbar-brand"> <img src="logo.png"
			alt="logo" class="rounded">
		</a> <span class="temp"></span>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<!-- <div class=" container justify-content-center"> -->
			<ul class="navbar-nav ml-lg-auto">

				<li class="nav-item active"><a
					class="nav-link  mr-3 text-white"
					href="<%=request.getContextPath()%>/DepartmentHeadController/complains">Complains</a>
				</li>

				< <li class="nav-item">
                    <a class="nav-link  mr-3 text-white" href="<%=request.getContextPath()%>/DepartmentHeadController/reopenComplain">Reopen Complain</a>
                </li> 
				<li class="nav-item"><a class="nav-link mr-3 text-white"
					href="<%=request.getContextPath()%>/DepartmentHeadController/reminderList">Reminder<span class="badge badge-light"><c:out value="${reminderCount}"></c:out></span></a></li>
				<li class="nav-item">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModal" data-whatever="@fat">Transfer
						Complain</button>
						
<%-- Pop Up Box For Transfer Complain Button --%>

					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Transfer
										Complain</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								
								<div class="modal-body">
									<form
										action="<%=request.getContextPath()%>/DepartmentHeadController/transferComplain">
										<div class="form-group">
											<label for="citizen-id" class="col-form-label">Complain
												ID:</label> <input type="text" class="form-control" id="citizen-id"
												name="compId" style="width: 15rem">
										</div>
										<div class="form-group">
										
<%--Show the dynamic List of Department Names --%>

											<label for="message-text" class="col-form-label">Select
												Department:</label> <br> <select class="custom-select"
												style="width: 15rem" name="department">
												<option>--Select--</option>
												<c:forEach var="department" items="${departmentList}">
												
												<option>${department.deptName}</option>
												</c:forEach>
											</select>
											<hr>
											<button type="submit" class="btn btn-success">Update</button>
											<button type="button" class="btn btn-danger "
												data-dismiss="modal">Close</button>
									</form>
								</div>

							</div>
						</div>
					</div>

				</li>
				<li class="nav-item"><a class="nav-link mr-3 text-white"
					href="<%=request.getContextPath()%>/logout.jsp">Logout</a></li>
			</ul>

		</div>

		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarSupportedContent">
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>


	<div>






		<!-- center text -->

		<div class=" text-center mt-3 center_text">
			<h3><c:out value="${reopen[0].deptName}"></c:out> Department</h3>
		</div>


<%-- Show the Table contain list Of Complain --%>

		<div class="container">
			<table class="table table-striped mt-4">
				<thead>
					<tr>
						<th></th>
						<th>Complain Id</th>
						<th>Name</th>
						<th>Contact No.</th>
						<th>Description</th>
						<th>File</th>
						<th>Remark</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="Complain" items="${reopen}">
					
						<tr>
							<td></td>
							<td><c:out value="${Complain.compId}"></c:out></td>
							<td><c:out value="${Complain.name}"></c:out></td>
							<td><c:out value="${Complain.contactNo}"></c:out></td>
							<td><c:out value="${Complain.description}"></c:out></td>
							<td><c:out value="${Complain.file}"></c:out></td>
						
							<td><button type="button" class="btn btn-outline-primary"
									data-toggle="modal" data-target="#exampleModalCenter">
									Remark</button>
									
<%-- Pop Up Box for Remark Button --%>			
							
								
								</td>
								<td>
									<div class="modal fade" id="exampleModalCenter" tabindex="-1"
									aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Write
													to citizen ...</h5>
													
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<form method="post" action="<%=request.getContextPath()%>/DepartmentHeadController/reopenRemark">
													
													<div class="form-group">
											<label for="citizen-id" class="col-form-label">Complain
												ID:</label> 
												<input type="text" class="form-control" name="compId"  style="width: 15rem">
										</div>
										<label for="remark" class="col-form-label">Remark:
											</label> 
													<textarea class="form-control" name="remark" rows="3"></textarea>
													
													<hr>
													
													<button type="submit" class="btn btn-primary">Submit</button>
													<button type="button" class="btn btn-danger"
														data-dismiss="modal">Close</button>
												</form>
											</div>
										</div>
									</div>
								</div>
								</td>

						</tr>



					</c:forEach>


				</tbody>
			</table>

		</div>

<%-- Link CDN for Bootstrap --%>

		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
			crossorigin="anonymous">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
			
			
<!-- Footer -->

		<footer class="page-footer font-small blue pt-4 text-white "
			style="position: fixed; bottom: 0; width: 100%">

<!-- Copyright -->

			<div class="footer-copyright text-center py-3"
				style="background-color: #2F363F">
				© 2020 Copyright: <a
					href="https://www.cybage.com/worldwide-locations/india/gandhinagar"
					class="text-white"> www.cybage.com</a>
			</div>
		

		</footer>
</body>

</html>