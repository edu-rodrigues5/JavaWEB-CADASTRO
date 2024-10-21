<%-- 
    Document   : Editar
    Created on : 9 de out. de 2024, 09:33:03
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
            packUser.Cadastro.setTelefone(request.getParameter("telefone"));
            packUser.Cadastro.setEmail(request.getParameter("email"));
            packUser.Cadastro.setCep(request.getParameter("cep"));
            packUser.Cadastro.setEstado(request.getParameter("estado"));
            packUser.Cadastro.setCidade(request.getParameter("cidade"));
            packUser.Cadastro.setBairro(request.getParameter("bairro"));
            packUser.Cadastro.setRua(request.getParameter("rua"));
            packUser.Cadastro.setNumero(request.getParameter("numero"));
            packUser.Cadastro.setComplemento(request.getParameter("complemento"));
            
            packUser.ProdutoDAL.alteraCadastro();
            
            if(packUser.Erro.getErro())
                out.print(packUser.Erro.getMens());
            else
                out.print("Produto Alterado");
                
            packUser.Erro.setErro(false);
        %>
            </article>
        </main>
    </body>
</html>
