package calculadora;

import java.io.IOException;

/**
 * Created by otonbraga on 13/03/16.
 */
public interface CalculadoraInterface extends Remote {
    public float soma (float num1, float num2) throws IOException, ClassNotFoundException;
    public float subtrai (float num1, float num2) throws IOException, ClassNotFoundException;
    public float multiplica (float num1, float num2) throws IOException, ClassNotFoundException;
    public float divide (float num1, float num2) throws IOException, ClassNotFoundException;
}
