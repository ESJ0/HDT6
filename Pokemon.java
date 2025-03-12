/**
 * Clase Pokemon que se encarga de tener todos sus atributos
 */
public class Pokemon {
    String name;
    String type1;
    String type2;
    int pokedexNumber;
    String classification;
    double height;
    double weight;
    String abilities;
    int generation;
    String legendaryStatus;

    /**
     * Metodo constructor de la clase Pokemon
     * @param name
     * @param type1
     * @param type2
     * @param pokedexNumber
     * @param classification
     * @param height
     * @param weight
     * @param abilities
     * @param generation
     * @param legendaryStatus
     */
    public Pokemon(String name, String type1, String type2, int pokedexNumber, String classification, double height, double weight, String abilities, int generation, String legendaryStatus) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.pokedexNumber = pokedexNumber;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }
    
    /**
     * Metodo toString de la clase Pokemon
     */
    public String toString() {
        return "Name: " + name + ", Type1: " + type1 + ", Type2: " + type2 + ", Classification: " + classification + ", Height: " + height + "m, Weight: " + weight + "kg, Abilities: " + abilities + ", Generation: " + generation + ", Legendary: " + legendaryStatus;
    }
}