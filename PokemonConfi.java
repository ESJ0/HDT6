import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PokemonConfi {
    private Map<String, Pokemon> pokedex;
    private Map<String, Pokemon> userCollection = new LinkedHashMap<>();
    
    public PokemonConfi(int mapChoice) {
        this.pokedex = Factory.getMap(mapChoice);
    }

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
    
    public void MostrarPokemons(String name) {
        System.out.println(pokedex.getOrDefault(name, new Pokemon("Desconocido", "N/A","N/A", 0, "N/A", 0, 0, "N/A", 0, "N/A")));
    }
    
    public void mostrarUserPokemonsByType() {
        userCollection.values().stream()
            .sorted(Comparator.comparing(messi -> messi.type1))
            .forEach(messi -> System.out.println("Name: " + messi.name + ", Type1: " + messi.type1));
    }
    
    public void mostrarAllPokemonsByType() {
        pokedex.values().stream()
            .sorted(Comparator.comparing(messi -> messi.type1))
            .forEach(messi -> System.out.println("Name: " + messi.name + ", Type1: " + messi.type1));
    }
    
    public void mostrarPokemonsByAbility(String ability) {
        pokedex.values().stream()
            .filter(messi -> messi.abilities.contains(ability))
            .forEach(System.out::println);
    }
}