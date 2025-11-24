package br.estoque.model;
public class Categoria{
    private int id; private String nome; private String descricao;
    public Categoria(String nome,String descricao){this.nome=nome;this.descricao=descricao;}
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNome(){return nome;} public String getDescricao(){return descricao;}
    public void setNome(String n){nome=n;} public void setDescricao(String d){descricao=d;}
}
