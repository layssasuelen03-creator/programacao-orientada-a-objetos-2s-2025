public class Radar 
{
    public Integer limitedeVelocidade;
    public String modelo;
    public String localizacao;

    //comportamento do objeto
    public void emitirNotificacao(String placa, Integer velocidadeAvaliada)
    {
        System.out.println("Limite de velocidade: "+ this.limitedeVelocidade);
        System.out.println("Velocidade avaliada: "+ velocidadeAvaliada);
        System.out.println("Placa: "+placa);
    }

     public void avaliarVelocidade(Carro c)
     {
       if(c. velocidade > this.limitedeVelocidade)
       {
           emitirNotificacao(c. placa, c. velocidade);
       }
     }

}