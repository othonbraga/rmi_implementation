package calculadora;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by otonbraga on 27/03/16.
 */
public class CalculadoraInterface_stub extends Stub implements CalculadoraInterface {

    Socket socket;

    public CalculadoraInterface_stub() {}

    @Override
    public float soma(float num1, float num2) throws IOException, ClassNotFoundException {
        return CommunicationMode.calc(1, "soma", new float[]{num1, num2});
    }

    @Override
    public float subtrai(float num1, float num2) throws IOException, ClassNotFoundException {
        return CommunicationMode.calc(1, "subtrai", new float[]{num1, num2});
    }

    @Override
    public float multiplica(float num1, float num2) throws IOException, ClassNotFoundException {
        return CommunicationMode.calc(1, "multiplica", new float[]{num1, num2});
    }

    @Override
    public float divide(float num1, float num2) throws IOException, ClassNotFoundException {
        return CommunicationMode.calc(1, "divide", new float[]{num1, num2});
    }
}
