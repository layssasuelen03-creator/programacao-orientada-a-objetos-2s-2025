public class Livro extends Material 
{
    private String autor;

    public Livro(String titulo, Integer anoPublicacao, String autor) 
    {
        super(titulo, anoPublicacao);
        this.autor = autor;
    }

    @Override // métados que sobreescrevi da superclasse 
    public void descricao() 
    {
        System.out.println("Título: " + getTitulo());
        System.out.println("Publicação: " + getAnoPublicacao());
        System.out.println("Autor: " + autor);
    }

    public String getAutor() 
    {
        return autor;
    }

    public void setAutor(String autor) 
    {
        this.autor = autor;
    }
}