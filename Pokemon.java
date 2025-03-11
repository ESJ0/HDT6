class Pokemon {
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
    
    public String toString() {
        return "Name: " + name + ", Type1: " + type1 + ", Type2: " + type2 + ", Classification: " + classification + ", Height: " + height + "m, Weight: " + weight + "kg, Abilities: " + abilities + ", Generation: " + generation + ", Legendary: " + legendaryStatus;
    }
}