import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Clase PokemonConfi que se encarga de toda la logica que lleva la Pokedex
 * del usuario como la del sistema
 */
public class PokemonConfi {
    private Map<String, Pokemon> pokedex;
    public Map<String, Pokemon> userCollection = new LinkedHashMap<>();
    
    /**
     * Metodo constructor de la clase PokemonConfi
     */
    public PokemonConfi(int mapChoice) {
        this.pokedex = Factory.getMap(mapChoice);
    }

    /**
     * Metodo parseCSVLine que maneja la extraccion de los datos del CSV
     * @param line
     * @return El resultado en un array
     */
    private String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        boolean insideQuotes = false;
        StringBuilder current = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                insideQuotes = !insideQuotes;
            } else if (c == ',' && !insideQuotes) {
                result.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        result.add(current.toString().trim());
        return result.toArray(new String[0]);
    }
    
    /**
     * Metodo cargarPokemons que se encarga de reunir los datos de los pokemons
     * @param filePath
     * @throws IOException
     */
    public void cargarPokemons(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines.subList(1, lines.size())) {
            String[] data = parseCSVLine(line);
            if (data.length > 9) {
                String name = data[0];
                int pokedexNumber = Integer.parseInt(data[1]);
                String type1 = data[2];
                String type2 = data[3];
                String classification = data[4];
                double height = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
                String abilities = data[7];
                int generation = Integer.parseInt(data[8]);
                String legendaryStatus = data[9];
                
                Pokemon SomePikachuAYIYIYIYI = new Pokemon(name, type1, type2, pokedexNumber, classification, height, weight, abilities, generation, legendaryStatus);
                pokedex.put(name, SomePikachuAYIYIYIYI);
            }
        }
    }

    /**
     * Metodo addPokemon que se encarga de anadir un pokemon a la pokedex del usuario
     * @param name
     */
    public void addPokemon(String name) {
        if (!pokedex.containsKey(name)) {
            System.out.println("404 eror: Pokemon no encontrado.");
        } else if (userCollection.containsKey(name)) {
            System.out.println("404 eror: Pokemon ya en la coleccin.");
        } else {
            userCollection.put(name, pokedex.get(name));
            System.out.println(name + " agregado a la coleccion.");
        }
    }
    
    /**
     * Metodo mostrarPokemons que se encarga de mostrar los pokemons de la pokedex del usuario
     * @param name
     */
    public void mostrarPokemons(String name) {
        System.out.println(pokedex.getOrDefault(name, new Pokemon("Desconocido", "N/A","N/A", 0, "N/A", 0, 0, "N/A", 0, "N/A")));
    }
    
    /**
     * Metodo mostrarUserPokemonsByType que se encarga de mostrar todos los pokemons by type del usuario
     */
    public void mostrarUserPokemonsByType() {
        userCollection.values().stream()
            .sorted(Comparator.comparing(messi -> messi.type1))
            .forEach(messi -> System.out.println("Name: " + messi.name + ", Type1: " + messi.type1));
    }
    
    /**
     * Metodo mostrarAllPokemonsByType que se encarga de mostrar todos los pokemons by type del sistema
     */
    public void mostrarAllPokemonsByType() {
        pokedex.values().stream()
            .sorted(Comparator.comparing(messi -> messi.type1))
            .forEach(messi -> System.out.println("Name: " + messi.name + ", Type1: " + messi.type1));
    }
    
    /**
     * Muestra a todos los pokemons del sistema segun su abilidad
     * @param ability
     */
    public void mostrarPokemonsByAbility(String ability) {
        pokedex.values().stream()
            .filter(messi -> messi.abilities.contains(ability))
            .forEach(System.out::println);
    }
}