<%-- 
    Document   : Deletar
    Created on : 9 de out. de 2024, 09:23:55
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/Produto.css"/>
    </head>
    <body>
        <main>
            <article>
        <%
        packUser.Cadastro.setNome(request.getParameter("nome"));
        
        packUser.ProdutoDAL.deletaCadastro();
        
        if(packUser.Erro.getErro() == true)
            out.println(packUser.Erro.getMens());
        else
            out.println("Produto Deletado");
            
            packUser.Erro.setErro(false);
        %>
            </article>
        </main>
    </body>
</html>
