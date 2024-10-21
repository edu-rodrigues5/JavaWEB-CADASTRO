<%-- 
    Document   : Consultar
    Created on : 8 de out. de 2024, 09:52:05
    Author     : Usuario
--%>

<%@page import="packUser.Cadastro"%>
<%@page import="packUser.ProdutoDAL"%>
<%@page import="packUser.Erro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" href="CSS/Produto.css"/>
    </head>
    <body>
        <main>
            <article>
        <%
            packUser.Cadastro.setNome(request.getParameter("nome"));
            
            ProdutoDAL.consultaCadastro();
        
            if(!Erro.getErro())
                out.println("Produto Encontrado");
            else
                out.println("Produto Não Encontrado");  

                packUser.Erro.setErro(false);

        %>
            </article>
        </main>
    </body>
</html>
