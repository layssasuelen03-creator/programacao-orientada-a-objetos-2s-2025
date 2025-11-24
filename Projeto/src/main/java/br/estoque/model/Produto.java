package br.estoque.model;
public abstract class Produto {
    protected int id; protected String nome; protected String descricao;
    protected int quantidade; protected double preco;
    public Produto(String nome,String descricao,int quantidade,double preco){
        this.nome=nome;this.descricao=descricao;this.quantidade=quantidade;this.preco=preco;
    }
    public int getId(){return id;} public String getNome(){return nome;}
    public String getDescricao(){return descricao;} public int getQuantidade(){return quantidade;}
    public double getPreco(){return preco;}
    public void setNome(String n){nome=n;} public void setDescricao(String d){descricao=d;}
    public void setQuantidade(int q){quantidade=q;} public void setPreco(double p){preco=p;}
    public abstract String getTipo();
}
