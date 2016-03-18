package calculadora;

import java.io.IOException;

/**
 * Created by curinga on 18/03/16.
 */
public class CalculadoraCientificaImpl_stub extends Stub implements CalculadoraCientifica{

    @Override
    public double raiz(float r) throws IOException, ClassNotFoundException {
        return  CommunicationMode.calc(2, "raiz", new float[]{r});
    }
}
