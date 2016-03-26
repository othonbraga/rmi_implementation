import source.RORtbl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        port = 12345;

        Class initialclass = Class.forName(InitialClassName);
        //Class initialskeleton = Class.forName(InitialClassName + "_skel");

        // you should also create a remote object table here.
        // it is a table of a ROR and a skeleton.
        // as a hint, I give such a table's interface as source.RORtbl.java.
        RORtbl tbl = new RORtbl();

        // after that, you create one remote object of initialclass.
        Object o = initialclass.newInstance();

        // then register it into the table.
        tbl.addObj(host, port, o);

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

            InputStream in = new InputStream() {
                @Override
                public int read() throws IOException {
                    System.out.print("entrou aqui!");
                    return 1;
                }
            };
            OutputStream out = new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    System.out.print("I am a simple registry.");
                }
            };

            //Object invocation = tbl.findObj((RemoteObjectRef) in.readObject()); // nao tenho certeza disso
        }
    }
}
