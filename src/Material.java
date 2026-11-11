// Clase padre de todos los materiales de la biblioteca
public abstract class Material {

    private String id;
    private String titulo;
    private boolean prestado;

    public Material(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.prestado = false; // al principio no esta prestado
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return id + " - " + titulo;
    }
}
