public class Emprestimo 
{
    private TomadordeEmprestimo tomadordeEmprestimo;
    private ItemEmprestavel itemEmprestavel;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(TomadordeEmprestimo tomadordeEmprestimo, ItemEmprestavel itemEmprestavel, String dataEmprestimo, String dataDevolucao) 
    {
        this.tomadordeEmprestimo = tomadordeEmprestimo;
        this.itemEmprestavel = itemEmprestavel;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public TomadordeEmprestimo getTomadorEmprestimo() 
    {
        return this.tomadordeEmprestimo;
    }

    public void setTomadorEmprestimo(TomadordeEmprestimo tomadordeEmprestimo) 
    {
        this.tomadordeEmprestimo = tomadordeEmprestimo;
    }

    public ItemEmprestavel getItemEmprestavel() 
    {
        return this.itemEmprestavel;
    }

    public void setItemEmprestavel(ItemEmprestavel itemEmprestavel) 
    {
        this.itemEmprestavel = itemEmprestavel;
    }

    public String getDataEmprestimo() 
    {
        return this.dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) 
    {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() 
    {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) 
    {
        this.dataDevolucao = dataDevolucao;
    }

    public void exibirDetalhes()
    {
        System.out.println("Data do empréstimo: " + this.dataEmprestimo);
        System.out.println("Data da devolução: " + this.dataDevolucao);
        System.out.println("TomadorEmprestimo vinculada");
        this.tomadordeEmprestimo.exibirInfo();
        System.out.println("ItemEmprestavel vinculada");
        this.itemEmprestavel.descricao();
    }
}