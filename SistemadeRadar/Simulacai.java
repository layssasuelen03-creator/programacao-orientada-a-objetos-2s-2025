public class Simulacai 
{
    public static void main(String[] args)
    {
        Carro opala = new Carro( "ACLR300",  0, 76, "Comodoro");
        
        Radar radar = new Radar( "Pistão Sul", 60);
       
        radar.avaliarVelocidade(opala);

        opala.acelerar(); //5
        opala.acelerar(); //10
        opala.acelerar(); //15
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar(); //60
        opala.setVelocidade(-60);

        radar.avaliarVelocidade(opala);

        opala.acelerar(); //60
        radar.avaliarVelocidade(opala);

        opala.frear(); //60
        radar.avaliarVelocidade(opala);

        
    }
}