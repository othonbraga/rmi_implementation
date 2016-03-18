package calculadora;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by curinga on 18/03/16.
 */
public interface CalculadoraCientificaInterface extends Serializable {

    public double raiz(float r) throws IOException, ClassNotFoundException;

}
