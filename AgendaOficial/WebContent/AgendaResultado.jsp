<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.Agenda"%>
<!DOCTYPEhtml >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agenda</title>
</head>
<body>
	<%
		Agenda agenda = (Agenda) request.getAttribute("agenda");
	%>

	Id:
	<%=agenda.getId()%><br> 
	Nome:
	<%=agenda.getNome()%><br> 
	Fone:
	<%=agenda.getTelefone()%><br> 
	E-mail:
	<%=agenda.getEmail()%><br>
</body>
</html>