package Logica;

import java.io.Serializable;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
public class Mensaje implements Serializable {
    private String mensaje;
    private String mensaje2;

    /**
     * Constructor del objeto mensaje.
     * @param mensaje String es el mensaje dedicado a la busqueda de en los árboles.
     * @param mensaje2 String es el mensaje dedicado a la indización u ordenamiento con los algoritmos.
     */
    public Mensaje(String mensaje, String mensaje2){
        this.mensaje = mensaje;
        this.mensaje2 = mensaje2;
    }

    /**
     * Retorna la información de mensaje.
     * @return String es el mensaje para la busqueda en los árboles.
     */
    public String getMensaje(){return this.mensaje;}

    /**
     * Retorna el mensaje para la indización o algoritmos.
     * @return String es el mensaje para la indización o algoritmos
     */
    public String getMensaje2(){return this.mensaje2;}

    /**
     * Setea mensaje.
     * @param mensaje String es el nuevo valor de mensaje.
     */
    public void setMensaje(String mensaje){this.mensaje = mensaje;}

    /**
     * Setea mensaje2.
     * @param mensaje2 String es el nuevo valor de mensaje2.
     */
    public void setMensaje2(String mensaje2){this.mensaje2 = mensaje2;}
}
