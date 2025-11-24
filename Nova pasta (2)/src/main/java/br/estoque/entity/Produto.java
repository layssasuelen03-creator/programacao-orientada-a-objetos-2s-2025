package br.estoque.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao; // <-- ADICIONADO PARA CORRIGIR O BANCO

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    public Produto() {}

    public Produto(String nome,String descricao, Integer quantidade, BigDecimal preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    public abstract String getTipo();



    @Override
    public String toString() {
    String cat = (categoria != null ? categoria.getNome() : "Nenhuma");
    String forn = (fornecedor != null ? fornecedor.getNome() : "Nenhum");

    return String.format(
        "ID: %d | Nome: %s | Preço: %s | Quantidade: %d | Categoria: %s | Fornecedor: %s | Tipo: %s",
        id, nome, preco, quantidade, cat, forn, getTipo()
    );
    }

}
