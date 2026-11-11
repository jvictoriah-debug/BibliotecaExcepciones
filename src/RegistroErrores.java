import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

// Clase que guarda los errores en el archivo errores.log (archivo incluido abajo en el menu),
//1. new FileWriter(ARCHIVO, true): Abre el archivo. El parámetro true indica que el texto se añadirá al final (append)
    // y no sobrescribirá lo que ya estaba escrito antes.
//2. SimpleDateFormat y Date: Obtiene la fecha y la hora actuales y las formatea de la forma dd/MM/yyyy HH:mm:ss
    // (por ejemplo: 10/11/2026 20:46:00).
//3. pw.println(...): Escribe una línea en el archivo con la estructura:[Fecha y hora] Nombre de la excepción -
    // Mensaje del error
//4. catch (IOException ex): Si ocurre un error al intentar escribir en el archivo (por ejemplo, si no tienes permisos
    // de escritura), atrapa la excepción y muestra un mensaje en la consola.
//5. finally: Se asegura de cerrar el PrintWriter (pw.close()) para liberar los recursos del sistema, sin importar
    // si el código se ejecutó con éxito o si ocurrió una excepción.
public class RegistroErrores {

    private static final String ARCHIVO = "errores.log";

    public static void registrar(Exception e) {
        PrintWriter pw = null;
        try {
            // el true es para que agregue al final y no borre lo anterior
            pw = new PrintWriter(new FileWriter(ARCHIVO, true));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fecha = formato.format(new Date());
            pw.println("[" + fecha + "] " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo escribir en el archivo de log: " + ex.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
