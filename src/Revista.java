public class Revista extends Material implements Prestable {

    private int numero;

    public Revista(String id, String titulo, int numero) {
        super(id, titulo);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void prestar() throws MaterialNoDisponibleException {
        if (estaPrestado()) {
            throw new MaterialNoDisponibleException("La revista: " + getTitulo() + ", ya esta prestada.");
        }
        setPrestado(true);
    }

    @Override
    public void devolver() {
        setPrestado(false);
    }

    @Override
    public String toString() {
        return "Revista: " + super.toString() + " (numero " + numero + ")";
    }
}
