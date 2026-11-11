// Se lanza cuando no se encuentra el material. Nota personal: "crea el error" que se devuelve cuando el material
//no ha sido encontrado. Es una herencia de "biblioteca Exception"
public class MaterialNoEncontradoException extends BibliotecaException {

    //Constructor de la clase donde detalla que el material no ha sido encontrad,
    //el "Super" pasa el texto de error a la clase madre (bibliotecaException) en caso de falla
    public MaterialNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
