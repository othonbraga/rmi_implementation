package calculadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by otonbraga on 18/03/16.
 */
public class CommunicationModeServer {

    static public Object read(Socket socket) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out =
            new PrintWriter(socket.getOutputStream(), true);
        return null;
    }
}
