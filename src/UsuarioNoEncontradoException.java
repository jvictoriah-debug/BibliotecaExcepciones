// Se lanza cuando no existe el usuario
public class UsuarioNoEncontradoException extends BibliotecaException {

    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
