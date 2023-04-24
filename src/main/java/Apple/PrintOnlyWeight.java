package Apple;

public class PrintOnlyWeight implements PrettyPrintPredicate {

    @Override
    public String prettyPrint(Apple apple) {
        return  apple.getWeight() > 150 ? apple.getColor() + " heavy apple = " + apple.getWeight() + "g"
                : "This apple < 150g";
    }
}
