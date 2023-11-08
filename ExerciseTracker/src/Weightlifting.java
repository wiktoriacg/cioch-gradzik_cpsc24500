import java.util.Date;

public class Weightlifting extends Exercise{
    private double poundsLifted;
    public double getPoundsLifted(){
        return poundsLifted;
    }
    public void setPoundsLifted(double poundsLifted){
        if(poundsLifted < 0){
            this.poundsLifted = 0;
        }else{
            this.poundsLifted = poundsLifted;
        }
    }
    public Weightlifting(String name, String comment, double duration, Date date, double poundsLifted){
        super(name,comment,duration,date);
        setPoundsLifted(poundsLifted);
    }
    public Weightlifting(){
        this("","",0,null,0);
    }
    @Override
    public String toString() {
        return String.format("%s\t%.1f", super.toString(), poundsLifted);
    }
    @Override
    public double calculateCalories(){
        double duration = getDuration();
        double calories;
        calories = (poundsLifted/duration)*50;
        return  calories;

    }
}
