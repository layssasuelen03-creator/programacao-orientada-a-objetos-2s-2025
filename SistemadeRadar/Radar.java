//Radar.java
public class Radar 
{

    public Integer limitedeVelocidade;
    public String modelo;
    public String localizacao;

    public Radar(String localizacao, Integer limitedeVelocidade)
    {
        this.localizacao = localizacao;
        this.limitedeVelocidade = limitedeVelocidade;
    }

    public Radar(Integer limitedeVelocidade)
    {
        this.limitedeVelocidade = limitedeVelocidade;
    }

    //comportamento do objeto
    public void emitirNotificacao(String placa, Integer velocidadeAvaliada)
    {
        System.out.println("Limite de velocidade: "+ this.limitedeVelocidade);
        System.out.println("Velocidade avaliada: "+ velocidadeAvaliada);
        System.out.println("Placa: "+placa);
    }

     public void avaliarVelocidade(Carro c)
     {
       if(c. getVelocidade() > this.limitedeVelocidade)
       {
           emitirNotificacao(c.getPlaca(), c.getVelocidade());
       }
     }

}