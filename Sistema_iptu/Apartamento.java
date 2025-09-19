package Sistema_iptu;

public class Apartamento extends Imovel 
{
    private Boolean possuiElevador;

    // Construtor
    public Apartamento(Municipio municipio, Double areaM2, Integer vagas, Boolean possuiElevador) 
    {
        super(municipio, areaM2, vagas);
        this.possuiElevador = possuiElevador;
    }

    // Getter
    public Boolean getPossuiElevador() 
    {
        return this.possuiElevador;
    }

    // Setter
    public void setPossuiElevador(Boolean possuiElevador) 
    {
        this.possuiElevador = possuiElevador;
    }

    // Sobrescrevendo calcularIPTU (se quiser um cálculo específico para apartamento)
    @Override
    public Double CalcularIPTU() 
    {
        double valor = super.CalcularIPTU();
        if (this.possuiElevador != null && this.possuiElevador) 
        {
            valor += 500.0; // exemplo: taxa extra por elevador
        }
        return valor;
    }
}
