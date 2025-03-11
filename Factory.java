import java.util.*;

public class Factory {

    public static Map<String, Pokemon> getMap(int eleccion) {
        return switch (eleccion) {
            case 1 -> new HashMap<>();
            case 2 -> new TreeMap<>();
            case 3 -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Opción inválida");
        };
    }
}
