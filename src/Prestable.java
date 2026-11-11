// Interfaz para los materiales que se pueden prestar. Nota personal: La interfaz define que metodos debe tener
// una clase, pero sin escribir el codigo dentro de ellos (metodos abstractos).

public interface Prestable {

    void prestar() throws MaterialNoDisponibleException;

    void devolver();

    boolean estaPrestado();
}
