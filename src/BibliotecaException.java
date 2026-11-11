// Excepcion general de la biblioteca, las demas heredan de esta.
//Herencia de la clase base "exception" (clase veirificada check) que es la que obliga a usar el throw y el catch
public class BibliotecaException extends Exception {


    //Constructor (describe la causa del error)
    public BibliotecaException(String mensaje) {
        super(mensaje);
    }
}
