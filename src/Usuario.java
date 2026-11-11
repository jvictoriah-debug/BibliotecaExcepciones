import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int id;
    private String nombre;
    private List<Material> prestamos;

    // maximo de prestamos que puede tener un usuario (Maximo 3 prestamos activos)
    private static final int MAX_PRESTAMOS = 3;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void prestarMaterial(Material material) throws MaximoPrestamosException, MaterialNoDisponibleException {
        if (prestamos.size() >= MAX_PRESTAMOS) {
            throw new MaximoPrestamosException("El usuario: " + nombre + ", ya tiene " + MAX_PRESTAMOS + " prestamos activos.");
        }
        // Libro y Revista implementan Prestable
        Prestable p = (Prestable) material;
        p.prestar(); // si ya esta prestado tira la excepcion
        prestamos.add(material);
    }

    public void devolverMaterial(Material material) throws MaterialNoEncontradoException {
        if (!prestamos.contains(material)) {
            throw new MaterialNoEncontradoException("El usuario: " + nombre + ", no tiene prestado el material " + material.getId());
        }
        Prestable p = (Prestable) material;
        p.devolver();
        prestamos.remove(material);
    }

    public int cantidadPrestamos() {
        return prestamos.size();
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (prestamos: " + prestamos.size() + ")";
    }
}
