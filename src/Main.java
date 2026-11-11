public class Main {

    public static void main(String[] args) {

        // 1. Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // 2. Registrar materiales (Libros y Revistas)
        System.out.println("=== Registrando materiales ===");
        biblioteca.registrarMaterial(new Libro("L001", "Cien anios de soledad", "Gabriel Garcia Marquez", "978-0307474728"));
        biblioteca.registrarMaterial(new Libro("L002", "El principito", "Antoine de Saint-Exupery", "978-0156012195"));
        biblioteca.registrarMaterial(new Libro("L003", "Java para principiantes", "Juan Perez", "978-1234567890"));
        biblioteca.registrarMaterial(new Libro("L004", "Rojo y Negro", "Stendhal", "978-2314567892"));
        biblioteca.registrarMaterial(new Revista("R001", "National Geographic", 245));
        biblioteca.registrarMaterial(new Revista("R002", "Muy Interesante", 112));
        biblioteca.registrarMaterial(new Revista("R003", "Horse & Hound", 1309));
        biblioteca.registrarMaterial(new Revista("R004", "Phrack Magazine", 1985));


        // 3. Registrar usuarios
        System.out.println();
        System.out.println("=== Registrando usuarios ===");
        biblioteca.registrarUsuario(new Usuario(1, "Ana"));
        biblioteca.registrarUsuario(new Usuario(2, "Carlos"));
        biblioteca.registrarUsuario(new Usuario(3, "Melania"));

        // 4. Prestamos
        System.out.println();
        System.out.println("=== Escenario 1: prestamo exitoso ===");
        try {
            biblioteca.prestarMaterial(1, "L001");
        } catch (BibliotecaException e) {
            System.out.println("ERROR: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.");
        }

        System.out.println();
        System.out.println("=== Escenario 2: material ya prestado ===");
        try {
            biblioteca.prestarMaterial(2, "L001"); // L001 ya lo tiene Ana
        } catch (BibliotecaException e) {
            System.out.println("ERROR: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.");
        }

        System.out.println();
        System.out.println("=== Escenario 3: material inexistente ===");
        try {
            biblioteca.prestarMaterial(1, "X999");
        } catch (BibliotecaException e) {
            System.out.println("ERROR: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.");
        }

        System.out.println();
        System.out.println("=== Escenario 4: usuario inexistente ===");
        try {
            biblioteca.prestarMaterial(50, "L002");
        } catch (BibliotecaException e) {
            System.out.println("ERROR: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.");
        }

        System.out.println();
        System.out.println("=== Escenario 5: superar el maximo de prestamos ===");
        // Ana ya tiene 1, le prestamos 2 mas para llegar a 3
        try {
            biblioteca.prestarMaterial(1, "L002");
            biblioteca.prestarMaterial(1, "R001");
            biblioteca.prestarMaterial(1, "R002"); // este seria el cuarto, tiene que fallar
        } catch (MaximoPrestamosException e) {
            // la atrapo aparte para mostrar que se puede capturar una en particular
            System.out.println("ERROR (maximo de prestamos): " + e.getMessage());
            RegistroErrores.registrar(e);
        } catch (BibliotecaException e) {
            System.out.println("ERROR: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.");
        }

        // 5. Devoluciones
        System.out.println();
        System.out.println("=== Devoluciones ===");
        try {
            biblioteca.devolverMaterial(1, "L001");
            // ahora que se devolvio, Carlos lo puede pedir
            biblioteca.prestarMaterial(2, "L001");
        } catch (BibliotecaException e) {
            System.out.println("ERROR: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.");
        }

        System.out.println();
        System.out.println("=== Devolver un material que el usuario no tiene ===");
        try {
            biblioteca.devolverMaterial(2, "L003");
        } catch (BibliotecaException e) {
            System.out.println("ERROR: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operacion finalizada.");
        }

        System.out.println();
        System.out.println("Fin del programa. Los errores se guardaron en errores.log");
    }
}
