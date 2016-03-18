package calculadora;

import java.io.Serializable;

/**
 * Created by otonbraga on 18/03/16.
 */
public class Package implements Serializable {
    public int serviceKey;
    public String operation;
    public float[] attributs;
    public float result;

    public Package(int serviceKey, String operation, float[] attibuts) {
        this.serviceKey = serviceKey;
        this.operation = operation;
        this.attributs = attributs;
    }
}
