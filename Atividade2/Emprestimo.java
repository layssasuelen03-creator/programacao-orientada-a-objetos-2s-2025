
public class Emprestimo 
{
    private Pessoa pessoa;
    private Material material;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(Pessoa pessoa, Material material, String dataEmprestimo, String dataDevolucao) 
    {
        this.pessoa = pessoa;
        this.material = material;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public void exibirDetalhes() 
    {
        System.out.println("===== Detalhes do Empréstimo =====");
        System.out.println("Data de Empréstimo: " + dataEmprestimo);
        System.out.println("Data de Devolução: " + dataDevolucao);
        System.out.println();

        System.out.println("\n--- Pessoa ---");
        pessoa.exibirInfo();
        System.out.println();
        
        System.out.println("\n--- Material ---");
        material.descricao();
        System.out.println("==============================\n");
    }

    public Pessoa getPessoa() 
    {
        return pessoa;
    }

    public Material getMaterial() 
    {
        return material;
    }

    public String getDataEmprestimo() 
    {
        return dataEmprestimo;
    }

    public String getDataDevolucao() 
    {
        return dataDevolucao;
    }
}
