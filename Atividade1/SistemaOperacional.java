
public class SistemaOperacional 
{
    private Computador computador;

    public SistemaOperacional(Computador computador) 
    {
        this.computador = computador;
    }

    public boolean executarPrograma(Programa prog) 
    {
        if (prog.getSSDOcupado() > computador.getSSD()) 
        {
            System.out.println("Erro na instalação do programa: SSD ocupado maior que o disponí+vel.");
            return false;
        }

        if (prog.getMemoriaRAMAlocada() > computador.getMemoriaRAM()) 
        {
            System.out.println("Erro na execução do programa: Memória RAM maior que o disponível.");
            return false;
        }

        System.out.println("Programa executado com sucesso!");

        double tempoExecucao = (double) prog.getQuantidadeOperacoes() / (computador.getOperacoesPorSegundo() * computador.getNucleos());

        System.out.printf("Tempo de execução eh de: %.2f segundos.%n", tempoExecucao);
        
        return true;
    }

    public Computador getComputador() 
    {
        return computador;
    }

    public void setComputador(Computador computador) 
    {
        this.computador = computador;
    }
}