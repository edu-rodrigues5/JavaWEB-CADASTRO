/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packUser;
import java.sql.*;

/**
 *
 * @author unisanta
 */
public class ProdutoDAL {

    private static Connection con = null;

    public static void conecta()
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/BD/Livros2.mdb", "", "");
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void desconecta()
    {
        try 
        {
            con.close();
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void inseriCadastro()
    {
        String aux = "INSERT INTO TabCadastro (nome, telefone, email, cep, estado, cidade, bairro, rua, numero, complemento) VALUES ('" + Cadastro.getNome() + "','" + Cadastro.getTelefone()+ "','" + Cadastro.getEmail() + "', '"+ Cadastro.getCep()+"','"+ Cadastro.getEstado()+"','" + Cadastro.getCidade()+"','" + Cadastro.getBairro()+"','" + Cadastro.getRua()+"','" + Cadastro.getNumero()+"','" + Cadastro.getComplemento()+"')";
    
    Erro.setErro(false);
    conecta();
    if (Erro.getErro()) return;
    try {
        Statement st = con.createStatement();
        st.executeUpdate(aux);
        st.close();
    }
    catch(Exception e){ Erro.setErro("Pessoa não cadastrada!"); }
    finally{desconecta();}
        
       
    }
    
    public static void alteraCadastro()
    {
        Erro.setErro(false);
    conecta();
    if (Erro.getErro()) return;
        try 
        {
        PreparedStatement st = con.prepareStatement("UPDATE TabCadastro SET  telefone=?, email=?, cep=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,complemento=? WHERE nome=?");
        st.setString(1,Cadastro.getTelefone());
        st.setString(2,Cadastro.getEmail());
        st.setString(3,Cadastro.getCep());        
        st.setString(4,Cadastro.getEstado());        
        st.setString(5,Cadastro.getCidade());
        st.setString(6,Cadastro.getBairro());
        st.setString(7,Cadastro.getRua());
        st.setString(8,Cadastro.getNumero());
        st.setString(9,Cadastro.getComplemento());
        st.setString(10,Cadastro.getNome());
        st.executeUpdate();
        st.close();
        }
        catch(Exception e)
        {
            Erro.setErro("Pessoa Não Alterada");
        }
        finally{desconecta();}
    }

    public static void deletaCadastro()
    {
        conecta();
        try
        {
        PreparedStatement st = con.prepareStatement("DELETE FROM TabCadastro WHERE nome=?");
        st.setString(1,Cadastro.getNome());
        st.executeUpdate();
        st.close();
        }
        catch(Exception e)
        {
            Erro.setErro("Pessoa não Deletada");
        }
        finally{desconecta();}
        
    }
    
    public static void consultaCadastro()
    {
        
        ResultSet rs;

        conecta();
        
        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM TabCadastro WHERE nome=?");
            st.setString(1,Cadastro.getNome());
            rs = st.executeQuery();
            if (rs.next())
            {
                Cadastro.setTelefone(rs.getString("telefone"));
                Cadastro.setEmail(rs.getString("email"));
                Cadastro.setCep(rs.getString("cep"));
                Cadastro.setEstado(rs.getString("estado"));
                Cadastro.setCidade(rs.getString("cidade"));
                Cadastro.setBairro(rs.getString("bairro"));
                Cadastro.setRua(rs.getString("rua"));
                Cadastro.setNumero(rs.getString("numero"));
                Cadastro.setComplemento(rs.getString("complemento"));
                st.close();
                return;
            }
            else{
                Erro.setErro("Pessoa Não Cadastrada");
                st.close();
                return;
            }
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
            
        }
        finally{desconecta();}
    }
}