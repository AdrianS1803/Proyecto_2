package Logica;

import java.io.Serializable;

public class Mensaje implements Serializable {
    private String mensaje;
    private String mensaje2;
    public Mensaje(String mensaje, String mensaje2){
        this.mensaje = mensaje;
        this.mensaje2 = mensaje2;
    }
    public String getMensaje(){return this.mensaje;}
    public String getMensaje2(){return this.mensaje2;}
    public void setMensaje(String mensaje){this.mensaje = mensaje;}
    public void setMensaje2(String mensaje2){this.mensaje2 = mensaje2;}
}
