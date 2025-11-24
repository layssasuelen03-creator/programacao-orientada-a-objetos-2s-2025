package br.estoque.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(name = "dataMovimento", updatable = false)
    private LocalDateTime dataMovimento;

    public Movimentacao() {}

    public Movimentacao(Produto produto, String tipo, Integer quantidade, String observacao) {
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.dataMovimento = LocalDateTime.now();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public LocalDateTime getDataMovimento() { return dataMovimento; }
    public void setDataMovimento(LocalDateTime dataMovimento) { this.dataMovimento = dataMovimento; }

    @Override
    public String toString() {
        String prodInfo = produto != null ? produto.getNome() + " (ID:" + produto.getId() + ")" : "N/A";
        return String.format("Mov[%d] %s - %s qte=%d - %s - %s",
                id, prodInfo, tipo, quantidade, dataMovimento, observacao);
    }
}










package br.estoque.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // relacionamento com Produto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private String tipo; // Entrada, Saída, Ajuste

    @Column(nullable = false)
    private Integer quantidade;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(name = "dataMovimento", updatable = false)
    private LocalDateTime dataMovimento;

    public Movimentacao() {}

    public Movimentacao(Produto produto, String tipo, Integer quantidade, String observacao) {
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.dataMovimento = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public LocalDateTime getDataMovimento() { return dataMovimento; }
    public void setDataMovimento(LocalDateTime dataMovimento) { this.dataMovimento = dataMovimento; }

    @Override
    public String toString() {
        String prodInfo = produto != null ? produto.getNome() + " (ID:" + produto.getId() + ")" : "N/A";
        return String.format("Mov[%d] %s - %s qte=%d - %s - %s",
                id, prodInfo, tipo, quantidade, dataMovimento, observacao);
    }
}
