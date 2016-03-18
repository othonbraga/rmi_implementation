package calculadora;

import java.io.*;
import java.net.Socket;

/**
 * Created by otonbraga on 18/03/16.
 */
public class CommunicationMode {
    static public float calc(int serviceKey, String oparation, float[] attr) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 3121);
        System.out.println("stub inicializado");

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        out.writeObject(new Package(serviceKey, oparation, attr));

        Package result = (Package) in.readObject();

		socket.close();

        return result.result;
    }
}
