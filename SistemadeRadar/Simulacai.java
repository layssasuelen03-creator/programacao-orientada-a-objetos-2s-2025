
public class Simulacai 
{
    public static void main(String[] args)
    {
        Carro opala = new Carro();
        opala.velocidade = 0; //está parado
        opala.placa = "ACLR300";
        opala.modelo = "Comodoro";
        opala.ano = 76;

        Radar radar = new Radar();
        radar.modelo = "pardal";
        radar.limitedeVelocidade = 60;
        radar.localizacao = "Pistão Sul";

        opala.acelerar(); //5
        opala.acelerar(); //10
        opala.acelerar(); //15
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar();
        opala.acelerar(); //60

        radar.avaliarVelocidade(opala);

        opala.acelerar(); //60
        radar.avaliarVelocidade(opala);

        opala.frear(); //60
        radar.avaliarVelocidade(opala);
    }
}
