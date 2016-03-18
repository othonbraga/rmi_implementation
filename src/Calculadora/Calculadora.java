package calculadora;

/**
 * Created by otonbraga on 13/03/16.
 */
public class Calculadora implements CalculadoraInterface{

    public Calculadora(){
        System.out.print("Novo calculadora.Servidor instanciado...");
    }

    public float soma (float num1, float num2) {
        System.out.println("somou");
        return num1 + num2;
    }
    public float subtrai (float num1, float num2) {
        System.out.println("subtaiu");
        return num1 - num2;
    }
    public float multiplica (float num1, float num2) {
        System.out.println("mutiplicou");
        return num1 * num2;
    }
    public float divide (float num1, float num2) {
        System.out.println("dividiu");
        return  num1 / num2;
    }
}
