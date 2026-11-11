// Se lanza cuando el usuario ya tiene 3 prestamos
public class MaximoPrestamosException extends BibliotecaException {

    public MaximoPrestamosException(String mensaje) {
        super(mensaje);
    }
}
