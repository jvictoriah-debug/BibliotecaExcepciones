import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Material> materiales;
    private List<Usuario> usuarios;

    public Biblioteca() {
        materiales = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void registrarMaterial(Material material) {
        materiales.add(material);
        System.out.println("Material registrado: " + material);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public Material buscarMaterial(String id) throws MaterialNoEncontradoException {
        for (Material m : materiales) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        throw new MaterialNoEncontradoException("No existe el material con id: " + id);
    }

    public Usuario buscarUsuario(int id) throws UsuarioNoEncontradoException {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        throw new UsuarioNoEncontradoException("No existe el usuario con id: " + id);
    }

    public void prestarMaterial(int usuarioId, String materialId)
            throws UsuarioNoEncontradoException,
                   MaterialNoEncontradoException,
                   MaterialNoDisponibleException,
                   MaximoPrestamosException {

        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);

        if (material.estaPrestado()) {
            throw new MaterialNoDisponibleException("El material ya esta prestado.");
        }

        usuario.prestarMaterial(material);
        System.out.println("Prestamo realizado: " + material.getTitulo() + " -> " + usuario.getNombre());
    }

    public void devolverMaterial(int usuarioId, String materialId)
            throws UsuarioNoEncontradoException, MaterialNoEncontradoException {

        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);

        usuario.devolverMaterial(material);
        System.out.println("Devolucion realizada: " + material.getTitulo() + " <- " + usuario.getNombre());
    }
}
