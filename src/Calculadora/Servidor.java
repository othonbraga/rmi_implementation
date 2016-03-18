package calculadora;

import source.RORtbl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by otonbraga on 26/03/16.
 */
public class Servidor {
    static String host;
    static int port;

    public static void main (String args[]) throws Exception{
        String InitialClassName = "Calculadora";
        String registryHost = "127.0.0.1";
        int registryPort = Integer.parseInt("3021");
        String serviceName = "calculadora";

        host = (InetAddress.getLocalHost()).getHostName();
        port = 3121;

        Class initialclass = Class.forName("calculadora." + InitialClassName);
        //Class initialskeleton = Class.forName(InitialClassName + "_skel");

        // you should also create a remote object table here.
        // it is a table of a ROR and a skeleton.
        // as a hint, I give such a table's interface as source.RORtbl.java.
        RORtbl tbl = new RORtbl();

        // after that, you create one remote object of initialclass.
        Calculadora calculadora = (Calculadora) initialclass.newInstance();

        // then register it into the table.
        tbl.addObj(host, port, calculadora);

        // create a socket.
        ServerSocket serverSoc = new ServerSocket(port);

        // Now we go into a loop.
        // Look at rmiregistry.java for a simple server programming.
        // The code is far from optimal but in any way you can get basics.
        // Actually you should use multiple threads, or this easily
        // deadlocks. But for your implementation I do not ask it.
        // For design, consider well.
        while (true) {
            // (1) receives an invocation request.
            // (2) creates a socket and input/output streams.
            // (3) gets the invocation, in martiallled form.
            // (4) gets the real object reference from tbl.
            // (5) Either:
            //      -- using the interface name, asks the skeleton,
            //         together with the object reference, to unmartial
            //         and invoke the real object.
            //      -- or do unmarshalling directly and involkes that
            //         object directly.
            // (6) receives the return value, which (if not marshalled
            //     you should marshal it here) and send it out to the
            //     the source of the invoker.
            // (7) closes the socket.

            Socket cliente = serverSoc.accept();

            System.out.println("novo pedido");

//          ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
//			ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());

            BufferedReader in =
                new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter out =
                new PrintWriter(cliente.getOutputStream(), true);

            String method = in.readLine();
            float result = 0.0f;

            // isso deveria ser feito pelo despachante

            //Method m = Calculadora.class.getInterfaces()[0].getDeclaredMethod(""); // le a primeira linha e procura o método

            if (method.equals("soma")) {
                result = calculadora.soma(Float.parseFloat(in.readLine()), Float.parseFloat(in.readLine()));
            } else if (method.equals("subtrai")) {
                result = calculadora.subtrai(Float.parseFloat(in.readLine()), Float.parseFloat(in.readLine()));
            } else if (method.equals("divide")) {
                result = calculadora.divide(Float.parseFloat(in.readLine()), Float.parseFloat(in.readLine()));
            }else if (method.equals("multiplica")) {
                result = calculadora.multiplica(Float.parseFloat(in.readLine()), Float.parseFloat(in.readLine()));
            }else{
                System.out.println("metodo inexistente");
            }

            out.println(result);
            cliente.close();
        }
    }
}
