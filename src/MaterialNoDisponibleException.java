// Se lanza cuando el material ya esta prestado. Nota personal: "crea el error" que se devuelve cuando el material
//no esta disponible. Es una herencia de "biblioteca Exception"

public class MaterialNoDisponibleException extends BibliotecaException {

    //Constructor de la clase donde detalla que el material no esta disponible,
    //el "Super" pasa el texto de error a la clase madre (bibliotecaException) en caso de falla
    public MaterialNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
