package source;

import calculadora.*;

public class RemoteObjectRef implements Remote{
    String IP_adr;
    int Port;
    int Obj_Key;
    String Remote_Interface_Name;

    public RemoteObjectRef(String ip, int port, int obj_key, String riname) {
        IP_adr = ip;
        Port = port;
        Obj_Key = obj_key;
        Remote_Interface_Name = riname;
    }

    // this method is important, since it is a stub creator.
    // 
    public Object localise() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // Implement this as you like: essentially you should
        // create a new stub object and returns it.
        // Assume the stub class has the name e.g.
        //
        //       Remote_Interface_Name + "_stub".
        //
        // Then you can create a new stub as follows:
        //
        //       Class c = Class.forName(Remote_Interface_Name + "_stub");
        //       Object o = c.newinstance()
        //
        // For this to work, your stub should have a constructor without arguments.
        // You know what it does when it is called: it gives communication module
        // all what it got (use CM's static methods), including its method name,
        // arguments etc., in a marshalled form, and CM (source.yourRMI) sends it out to
        // another place.
        // Here let it return null.

        //-- meu codigo inicio

        Class c = Class.forName("calculadora."+ Remote_Interface_Name + "_stub");
        CalculadoraInterface_stub stub = (CalculadoraInterface_stub) c.newInstance();

        //-- meu codigo fim

        return stub;
    }
}
