package Sistema_iptu;

public class SecretariaFazenda 
{
    public static void main(String[] args) 
    {
        Municipio brasilia = new Municipio("Brasilia","DF",65.5);

        Apartamento apt = new Apartamento(brasilia, 52.0, 1,true);

        System.out.println("IPTU R$ " + apt.CalcularIPTU());
    }
}
