import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Base
        Base base = new Base(1, "Base Norte", "activo", "México");
        System.out.println(base.ejecutarDiagnostico());

        // Biomas
        Selva selva = new Selva(1, "Selva", 27, 21, 80, 1000);
        Desierto desierto = new Desierto(2, "Desierto", 40, 18, 55, 2000);

        System.out.println(selva.agregarBioma());
        System.out.println(desierto.agregarBioma());

        // Equipos
        Sensores sensor = new Sensores(
                "S1", "SensorTemp", "activo",
                "Temperatura", "°C", 30,
                new ArrayList<>()
        );

        Actuadores actuador = new Actuadores(
                "A1", "Ventilador", "operativo",
                1200, "Ventilación"
        );

        System.out.println(sensor.obtenerUltimoValor());
        System.out.println(actuador.ejecutarDiagnostico());
    }
}
