package br.estoque.model;
public class ProdutoPerecivel extends Produto{
    private String validade;
    public ProdutoPerecivel(String nome,String descricao,int quantidade,double preco,String validade){
        super(nome,descricao,quantidade,preco); this.validade=validade;
    }
    public String getValidade(){return validade;}
    public String getTipo(){return "Perecível";}
}
