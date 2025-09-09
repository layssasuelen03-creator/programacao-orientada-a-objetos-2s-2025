
public class Programa 
{
    private Integer memoriaRAMAlocada;
    private Integer SSDOcupado;
    private Integer nucleos;
    private Integer quantidadeOperacoes;

    public Programa(Integer memoriaRAMAlocada, Integer SSDOcupado,  Integer nucleos, Integer quantidadeOperacoes) 
    {
        this.memoriaRAMAlocada = memoriaRAMAlocada;
        this.SSDOcupado = SSDOcupado;
        this.nucleos = nucleos;
        this.quantidadeOperacoes = quantidadeOperacoes;
    }

    public int getMemoriaRAMAlocada() 
    {
        return memoriaRAMAlocada;
    }

    public void setMemoriaRAMAlocada(Integer memoriaRAMAlocada) 
    {
        this.memoriaRAMAlocada = memoriaRAMAlocada;
    }

    public int getSSDOcupado() 
    {
        return SSDOcupado;
    }

    public void setSSDOcupado(Integer SSDOcupado) 
    {
        this.SSDOcupado = SSDOcupado;
    }

    public int getNucleos() 
    {
        return nucleos;
    }

    public void setNucleos(Integer nucleos) 
    {
        this.nucleos = nucleos;
    }

    public int getQuantidadeOperacoes() 
    {
        return quantidadeOperacoes;
    }

    public void setQuantidadeOperacoes(Integer quantidadeOperacoes) 
    {
        this.quantidadeOperacoes = quantidadeOperacoes;
    }
}