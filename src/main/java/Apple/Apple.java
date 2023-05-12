package Apple;

public class Apple {

    private int weight;
    private Color color;

    private String name;

    public Apple(int weight, Color color, String name) {
        this.weight = weight;
        this.color = color;
        this.name = name;
    }
    public Apple(){}

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Apple: " +
                "weight=" + weight +
                ", name='" + name + '\'';
    }
}
