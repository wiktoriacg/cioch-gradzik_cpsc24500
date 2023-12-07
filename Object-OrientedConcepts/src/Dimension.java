public class Dimension {
    private double height;
    private double width;
    private double length;
}
abstract class Toy {
    private Dimension dimensions;
    private double weight;
    private String getType(){
        return"Toy";
    }
    public abstract void play();
}
