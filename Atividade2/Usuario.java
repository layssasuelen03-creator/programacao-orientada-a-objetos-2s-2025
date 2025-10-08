public class Usuario extends Pessoa 
{
    private Integer matricula;

    public Usuario(String nome, String email, Integer matricula) 
    {
        super(nome, email);
        this.matricula = matricula;
    }

    @Override // métados que sobreescrevi da superclasse 
    public void exibirInfo() 
    {
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Matrícula: " + matricula);
    }

    public Integer getMatricula() 
    {
        return matricula;
    }

    public void setMatricula(Integer matricula) 
    {
        this.matricula = matricula;
    }
}