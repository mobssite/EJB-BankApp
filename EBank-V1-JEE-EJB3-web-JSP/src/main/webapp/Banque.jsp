<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@tagliburi = "http://java.sun.com/jsp/jstl/core"prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<!-- Formulaire de Recherche d'un compte -->
	<div id="formRecherche">
		<form action="controleur" method="post">
			<table>
				<tr>
					<td>Code :</td>
					<td><input type="text" name="numeroCompte" value="${numeroCompte}"
						required="required"></td>
					<td>${errCode}</td>
					<td><input type="submit" name="action" value="Consulter">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- Detail d'un compte -->
	<c:if test="${(compte!=null)||(mtMsgErr!=null)}">
		<div id="compte">
			<table>
				<tr>
					<td>Code:</td>
					<td>${compte.numeroCompte}</td>
				</tr>
				<tr>
					<td>Solde:</td>
					<td>${compte.solde}</td>
				</tr>
				<tr>
					<td>Date Création:</td>
					<td>${compte.dateCreation}</td>
				</tr>
			</table>
		</div>
		<div id="formOperations">
			<form action="controleur" method="post">
				<table>
					<tr>
						<td><input type="hidden" name="numeroCompte" value="${numeroCompte}"></td>
						<td><input type="number" name="montant" required="required"
							value="${montant}"></td>
						<td>${mtMsgERr}</td>
						<td><input type="submit" name="action" value="Verser">
						</td>
						<td><input type="submit" name="action" value="Retirer">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</c:if>
	
	<form action="controleur" method="get">
		<td><input type="submit" name="action"value="Tous Les comptes"></td>
	</form>
	<!-- LISTE DES COMPTES -->	
	<c:if test="${comptes!=null}">
		<div id="listeComptes">
			<table border="1" width="80%">
				<tr>
					<th>CODE</th>
					<th>SOLDE</th>
					<th>DATE CREATION</th>
				</tr>
				<c:forEach items="${comptes}" var="cp">
					<tr>
						<td>${cp.numeroCompte}</td>
						<td>${cp.solde}</td>
						<td>${cp.dateCreation}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<div id="errors">${exception}</div>
</body>
</html>