package Sistema_iptu;

public class Chacara extends Imovel 
{
    private Boolean temPocoArtesiano;

    public Chacara(Municipio municipio, Double areaM2, Integer vagas, Boolean temPocoArtesiano) 
    {
        super(municipio, areaM2, vagas);
        this.temPocoArtesiano = temPocoArtesiano;
    }

    public Boolean getTemPocoArtesiano() 
    {
        return this.temPocoArtesiano;
    }

    public void setTemPocoArtesiano(Boolean temPocoArtesiano) 
    {
        this.temPocoArtesiano = temPocoArtesiano;
    }
}
