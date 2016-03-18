package calculadora;
/**
 * Created by curinga on 18/03/16.
 */
public class CalculadoraCientifica implements CalculadoraCientificaInterface {

    @Override
    public double raiz(float r) {
        System.out.println("raizou");
        return Math.sqrt(r);
    }
}
