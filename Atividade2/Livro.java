
public class Livro extends Material 
{
    private String autor;
    private String edicao;

    public Livro(String titulo, int anoPublicacao, String autor, String edicao) 
    {
        super(titulo, anoPublicacao);
        this.autor = autor;
        this.edicao = edicao;
    }

    @Override //anotação que sobrescrevi da superclasse
    public void descricao() 
    {
        System.out.println("Livro: " + getTitulo());
        System.out.println("Ano de Publicação: " + getAnoPublicacao());
        System.out.println("Autor: " + autor);
        System.out.println("Edição: " + edicao);
    }

    public String getEdicao() 
    {
        return edicao;
    }

    public void setEdicao(String edicao) 
    {
        this.edicao = edicao;
    }
}
