package Sistema_iptu;

public class Municipio 
{
    private String Nome;
    private String Estado;
    private Double PrecoM2;

    public Municipio(String Nome, String Estado, Double PrecoM2) {
        this.Nome = Nome;
        this.Estado = Estado;
        this.PrecoM2 = PrecoM2;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEstado() {
        return this.Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Double getPrecoM2() {
        return this.PrecoM2;
    }

    public void setPrecoM2(Double precoM2) {
        this.PrecoM2 = precoM2;
    }
}

