import java.io.IOException;
import java.util.Scanner;

/**
 * Clase main que se encarga de la ejecucion del programa
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Seleccione la implementacion de Map (1: HashMap, 2: TreeMap, 3: LinkedHashMap):");
            int choice = scanner.nextInt();
            PokemonConfi manager = new PokemonConfi(choice);
            manager.cargarPokemons("pokemon_data_pokeapi.csv"); 
            
            int option;
            do {
                System.out.println("1. Agregar Pokemon\n2. Mostrar Pokemon\n3. Mostrar coleccion ordenada por tipo\n4. Mostrar todos ordenados por tipo\n5. Buscar por habilidad\n6. Salir");
                option = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (option) {
                    case 1 -> {
                        System.out.println("Ingrese el nombre del Pokémon: ");
                        manager.addPokemon(scanner.nextLine());
                    }
                    case 2 -> {
                        System.out.println("Ingrese el nombre del Pokémon: ");
                        manager.mostrarPokemons(scanner.nextLine());
                    }
                    case 3 -> manager.mostrarUserPokemonsByType();
                    case 4 -> manager.mostrarAllPokemonsByType();
                    case 5 -> {
                        System.out.println("Ingrese la habilidad: ");
                        manager.mostrarPokemonsByAbility(scanner.nextLine());
                    }
                }
            } while (option != 6);
        }
    }
}
