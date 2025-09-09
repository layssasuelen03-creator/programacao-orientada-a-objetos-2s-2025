public class Main 
{
    public static void main(String[] args) 
    {
        Computador pc = new Computador(16, 500, 4, 2.5f);
        SistemaOperacional sist_o = new SistemaOperacional(pc);

        Programa p1 = new Programa(8, 100, 2, 10000);   
        Programa p2 = new Programa(32, 100, 2, 20000);  
        Programa p3 = new Programa(4, 600, 1, 5000);   

        System.out.println("\n---- Teste Programa 1 ----");
        sist_o.executarPrograma(p1);

        System.out.println("\n---- Teste Programa 2 ----");
        sist_o.executarPrograma(p2);

        System.out.println("\n---- Teste Programa 3 ----");
        sist_o.executarPrograma(p3);
    }
}
