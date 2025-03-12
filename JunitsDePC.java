import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

/**
 * Clase JunitsDePC que se encarga de dos de pruebas unitarias de la clase PokemonConfi
 */
public class JunitsDePC {
    private PokemonConfi manager;

    @BeforeEach
    void setUp() {
        manager = new PokemonConfi(2); 
        try {
            manager.cargarPokemons("pokemon_data_pokeapi.csv"); 
        } catch (IOException e) {
            fail("No se pudo cargar el archivo CSV.");
        }
    }

    @Test
    void testAddUserPokemon() {
        manager.addPokemon("Pikachu");
        assertTrue(manager.userCollection.containsKey("Pikachu"), "Pikachi agregado a tu Pokedez papa, felicidades.");
    }

    @Test
    void testAddPokemonDuplicado() {
        manager.addPokemon("Pikachu");
        manager.addPokemon("Pikachu");
        assertEquals(1, manager.userCollection.size(), "No se puede agregar a un Pokemon duplicado.");
    }
}
