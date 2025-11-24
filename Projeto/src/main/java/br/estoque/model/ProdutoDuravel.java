package br.estoque.model;
public class ProdutoDuravel extends Produto{
    private int garantia;
    public ProdutoDuravel(String nome,String descricao,int quantidade,double preco,int garantia){
        super(nome,descricao,quantidade,preco); this.garantia=garantia;
    }
    public int getGarantia(){return garantia;}
    public String getTipo(){return "Durável";}
}
