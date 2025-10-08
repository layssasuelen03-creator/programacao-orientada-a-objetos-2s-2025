public class Emprestimo 
{
    private Pessoa pessoa;
    private Material material;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(Pessoa pessoa, Material material, String dataEmprestimo, String dataDevolucao) {
        this.pessoa = pessoa;
        this.material = material;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public void exibirDetalhes() 
    {
        System.out.println("Data do empréstimo: " + dataEmprestimo);
        System.out.println("Data de devolução: " + dataDevolucao);
        System.out.println("--- Pessoa ---");
        pessoa.exibirInfo();
        System.out.println("--- Material ---");
        material.descricao();
    }

    public Pessoa getPessoa() 
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) 
    {
        this.pessoa = pessoa;
    }

    public Material getMaterial() 
    {
        return material;
    }

    public void setMaterial(Material material) 
    {
        this.material = material;
    }

    public String getDataEmprestimo() 
    {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) 
    {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() 
    {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) 
    {
        this.dataDevolucao = dataDevolucao;
    }
}