package calculadora;

public class Calculadora 
{
    public Double numeroA;
    public Double numeroB;

    public void somar()
    {
        Double resultadoSoma = this.numeroA + this.numeroB;
        System.out.println(this.numeroA + "+"  + this.numeroB +  "=" + resultadoSoma);

    }

    public void subtrair()
    {
        Double resultadoSubtracao = this.numeroA - this.numeroB;
        System.out.println(this.numeroA + "-" + this.numeroB +  "=" + resultadoSubtracao);
    }

    public void multiplicar()
    {
        Double resultadoMultiplicacao = this.numeroA * this.numeroB;
        System.out.println(this.numeroA + "*" + this.numeroB + "=" + resultadoMultiplicacao);
    }

    public void dividir()
    {
        Double resultadoDivisao = this.numeroA / this.numeroB;
        System.out.println(this.numeroA + "/" + this.numeroB + "=" + resultadoDivisao);
    }
}
