package calculadora;

import java.io.IOException;

/**
 * Created by curinga on 18/03/16.
 */
public class CalculadoraCientificaInterface_stub extends Stub implements CalculadoraCientificaInterface {

    @Override
    public double raiz(float r) throws IOException, ClassNotFoundException {
        return  (double) CommunicationMode.calc(2, "raiz", new float[]{r});
    }
}
