public class Main {

    public static void main(String[] args) {

        // 6. Creación y Almacenamiento de Usuarios
        Usuario u1 = new Usuario("Carlos", "Sanchez", 28015, "Calle A", "carlos@mail.com", "pass123");
        Usuario u2 = new Usuario("Laura", "Gomez", 45012, "Calle B", "laura@mail.com", "abcdef");
        Usuario u3 = new Usuario("Mario", "Lopez", 28900, "Calle C", "mario@mail.com", "clave99");

        Usuario[] usuarios = {u1, u2, u3};

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }

        // Validación del Registro
        validarRegistro(usuarios);

        // Simulación de Inicio de Sesión

        // Intento 1 (Éxito)
        System.out.println("\nIntento de inicio de sesión 1:");
        if (u1.checkUsuario("carlos@mail.com", "pass123")) {
            System.out.println("Acceso concedido a " + u1.getNombre());
        } else {
            System.out.println("ERROR:Su acceso fue denegado.");
        }

        // Intento 2 (Fallo)
        System.out.println("\nIntento de inicio de sesión 2:");
        boolean acceso2 = u2.checkUsuario("laura@mail.com", "incorrecto");
        if (!acceso2) {
            System.out.println("ERROR-> Contraseña incorrecta para " + u2.getEmail() + ". Acceso denegado.");
        } else {
            System.out.println("Se le concedido su acceso  " + u2.getNombre());
        }
    }

    // 7. validarRegistro()
    public static void validarRegistro(Usuario[] usuarios) {
        System.out.println("\nValidación de Registro de Usuarios:");

        for (Usuario u : usuarios) {

            // Convertir CP a String correctamente
            String cp = String.valueOf(u.getCodigoPostal());

            // Validación: el CP debe empezar por "28"
            if (cp.startsWith("28")) {
                System.out.println("✔ " + u.getNombre() + "fue registrado correctamente (CP válido: " + cp + ")");
            } else {
                System.out.println("X ERROR: " + u.getNombre() + " tiene un código postal no válido (" + cp + ")");
            }
        }
    }
}

