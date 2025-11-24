package br.estoque.model;
public class Fornecedor{
    private int id; private String nome; private String cnpj; private String telefone;
    private String email; private String endereco;
    public Fornecedor(String n,String c,String t,String e,String end){
        nome=n;cnpj=c;telefone=t;email=e;endereco=end;
    }
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNome(){return nome;} public String getCnpj(){return cnpj;}
    public String getTelefone(){return telefone;} public String getEmail(){return email;}
    public String getEndereco(){return endereco;}
}
