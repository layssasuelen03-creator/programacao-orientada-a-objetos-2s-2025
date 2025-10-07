
public class Revista extends Material 
{
    private String autor;

    public Revista(String titulo, int anoPublicacao, String autor) 
    {
        super(titulo, anoPublicacao);
        this.autor = autor;
    }

    @Override //anotação que sobrescrevi da superclasse
    public void descricao() 
    {
        System.out.println("Revista: " + getTitulo());
        System.out.println("Ano de Publicação: " + getAnoPublicacao());
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
