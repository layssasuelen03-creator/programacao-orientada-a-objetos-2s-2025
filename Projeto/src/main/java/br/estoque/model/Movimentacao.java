package br.estoque.model;
import java.time.LocalDateTime;
public class Movimentacao{
    private int id,idProduto,quantidade; private String tipo,observacao;
    private LocalDateTime dataMovimento;
    public Movimentacao(int idProduto,String tipo,int quantidade,String obs){
        this.idProduto=idProduto;this.tipo=tipo;this.quantidade=quantidade;this.observacao=obs;
    }
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public int getIdProduto(){return idProduto;} public String getTipo(){return tipo;}
    public int getQuantidade(){return quantidade;} public String getObservacao(){return observacao;}
    public LocalDateTime getDataMovimento(){return dataMovimento;}
    public void setDataMovimento(LocalDateTime d){dataMovimento=d;}
}
