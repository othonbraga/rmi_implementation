import java.io.Serializable;

/**
 * Created by otonbraga on 13/03/16.
 */
public interface CalculadoraInterface extends Serializable {

    public float soma (float num1, float num2);
    public float subtrai (float num1, float num2);
    public float multiplica (float num1, float num2);
    public float divide (float num1, float num2);
}
