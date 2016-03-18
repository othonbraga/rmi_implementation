package calculadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by otonbraga on 18/03/16.
 */
public class CommunicationMode {
    static public float calc(String oparation, float num1, float num2) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3121);
        System.out.println("stub inicializado");

        BufferedReader in =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

        out.println("soma");
        out.println(num1);
        out.println(num2);
        String result = in.readLine();
		socket.close();

        return Float.parseFloat(result);
    }
}
