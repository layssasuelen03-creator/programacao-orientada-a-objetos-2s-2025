package br.estoque.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "produto_perecivel")
@PrimaryKeyJoinColumn(name = "id") // <<--- ADICIONADO
public class ProdutoPerecivel extends Produto {

    private LocalDate validade;

    public ProdutoPerecivel() { super(); }

    public ProdutoPerecivel(String nome, String descricao, Integer quantidade, BigDecimal preco, LocalDate validade) {
        super(nome, descricao, quantidade, preco);
        this.validade = validade;
    }

    public LocalDate getValidade() { return validade; }
    public void setValidade(LocalDate validade) { this.validade = validade; }

    @Override
    public String getTipo() { return "Perecível"; }


    @Override
    public String toString() {
    return super.toString() + " | Validade: " + validade;
    }
 
}
