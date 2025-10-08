public class Revista extends Material 
{
    private Integer edicao;

    public Revista(String titulo, Integer anoPublicacao, Integer edicao) 
    {
        super(titulo, anoPublicacao);
        this.edicao = edicao;
    }

    @Override // métados que sobrescrevi da superclasse 
    public void descricao() 
    {
        System.out.println("Título: " + getTitulo());
        System.out.println("Publicação: " + getAnoPublicacao());
        System.out.println("Edição: " + edicao);
    }

    public Integer getEdicao() 
    {
        return edicao;
    }

    public void setEdicao(Integer edicao) 
    {
        this.edicao = edicao;
    }
}