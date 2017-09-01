<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<body>
<form method="POST" action="/upload"  enctype="multipart/form-data">

<table>
<tr>
<td>Upload File</td>
</tr>
<tr>
<td> <input type="file" id="inputFile" name="file" title="Procurar por arquivo"></td>
</tr>

</table>

  <button type="submit" class="btn btn-primary">Enviar</button>


<c:if test="${filialResponse != null}">
<table>
<tr>
<td>- Filial que mais vendeu no período;</td><td>${filialResponse.filialMaisVendeu.name} </td>
</tr>
<tr>
<td>- Filial que teve o maior crescimento;</td><td>${filialResponse.filialMaiorCrescimento.name}</td>
</tr>
<tr>
<td>- Filial que teve a maior queda nas vendas;</td><td>${filialResponse.filialMaiorQueda.name}</td>
</tr>
<tr>
<td>- Mês em que a empresa mais vendeu.</td><td>${filialResponse.mesMaisVendeu}</td>
</tr>

</table>
</c:if>

<form>





</body>


</html>



