package Apple;

public class Apple {

    private int weight;
    private int weight2;
    private int weight3;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }
    public Apple(int weight, int weight2, int weight3){
        this.weight = weight;
        this.weight2 = weight2;
        this.weight3 = weight3;
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


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }

}
