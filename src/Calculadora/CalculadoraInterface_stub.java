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
    public float soma(float num1, float num2) throws IOException {

//        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
//
//        out.writeObject();

        return CommunicationMode.calc("soma", num1, num2);
    }

    @Override
    public float subtrai(float num1, float num2) throws IOException {
        return CommunicationMode.calc("subtrai", num1, num2);
    }

    @Override
    public float multiplica(float num1, float num2) throws IOException {
        return CommunicationMode.calc("multiplica", num1, num2);
    }

    @Override
    public float divide(float num1, float num2) throws IOException {
        return CommunicationMode.calc("divide", num1, num2);
    }
}
