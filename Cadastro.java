/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packUser;

/**
 *
 * @author Usuario
 */
public class Cadastro {
    private static String nome;
    private static String telefone;
    private static String email;
    private static String cep;
    private static String estado;
    private static String cidade;
    private static String bairro;
    private static String rua;
    private static String numero;
    private static String complemento;

   
public Cadastro(){}    
    
    public static void setNome(String _nome){nome=_nome;}
    public static void setTelefone(String _telefone){telefone=_telefone;}
    public static void setEmail(String _email){email=_email;}
    public static void setCep(String _cep){cep=_cep;}
    public static void setEstado(String _estado){estado=_estado;}
    public static void setCidade(String _cidade){cidade=_cidade;}
    public static void setBairro(String _bairro){bairro=_bairro;}
    public static void setRua(String _rua){rua=_rua;}
    public static void setNumero(String _numero){numero=_numero;}
    public static void setComplemento(String _complemento){complemento=_complemento;}



    public static String getNome(){return nome;}
    public static String getTelefone(){return telefone;}
    public static String getEmail(){return email;}
    public static String getCep(){return cep;}
    public static String getEstado(){return estado;}
    public static String getCidade(){return cidade;}
    public static String getBairro(){return bairro;}
    public static String getRua(){return rua;}
    public static String getNumero(){return numero;}
    public static String getComplemento(){return complemento;}


}