import calculadora.Calculadora;

public class Execultarcalculadora 
{
    public static void main(String[] agrs)
    {
        Calculadora calc1 = new Calculadora();
        Calculadora calc2 = new Calculadora();
        Calculadora calc3 = new Calculadora();
        Calculadora calc4 = new Calculadora();
        Calculadora calc5 = new Calculadora();
        
        calc1.numeroA = 2.0; 
        calc1.numeroB = 2.0;

        calc2.numeroA = 4.0;
        calc2.numeroB = 5.0;

        calc3.numeroA = 6.0;
        calc3.numeroB = 5.0;
       
        calc4.numeroA = 5.0;
        calc4.numeroB = 5.0;

        calc5.numeroA = 9.0;
        calc5.numeroB = 3.0;

        calc1.somar();
        calc2.somar();
        calc3.subtrair();
        calc4.multiplicar();
        calc5.dividir();
        
    }
}
