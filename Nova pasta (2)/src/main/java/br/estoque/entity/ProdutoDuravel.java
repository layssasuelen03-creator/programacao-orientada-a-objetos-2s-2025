
package br.estoque.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto_duravel")
@PrimaryKeyJoinColumn(name = "id")   // IMPORTANTE! Liga produto_duravel ao produto
public class ProdutoDuravel extends Produto {

    @Column(name = "garantia_meses", nullable = false)
    private Integer garantia;

    public ProdutoDuravel() { super(); }

    public ProdutoDuravel(String nome, String descricao, Integer quantidade, BigDecimal preco, Integer garantia) {
        super(nome, descricao, quantidade, preco);
        this.garantia = garantia;
    }

    public Integer getGarantia() { return garantia; }
    public void setGarantia(Integer garantia) { this.garantia = garantia; }

    @Override
    public String getTipo() { return "Durável"; }



    @Override
    public String toString() {
    return super.toString() + " | Garantia: " + garantia + " meses";
}

}
