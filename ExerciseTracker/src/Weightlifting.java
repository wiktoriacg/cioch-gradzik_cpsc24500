import java.util.Date;

public class Weightlifting extends Exercise{
    private double poundsLifted;
    public double getPoundsLifted(){
        return poundsLifted;
    }
    /**
     * it sets poundsLifted
     * if poundsLifted parameter are < 0 it sets it as 0
     * @param poundsLifted - amount of reps
     */
    public void setPoundsLifted(double poundsLifted){
        if(poundsLifted < 0){
            this.poundsLifted = 0;
        }else{
            this.poundsLifted = poundsLifted;
        }
    }
    //its creates constructor if Date date is provided
    public Weightlifting(String name, String comment, double duration, Date date, double poundsLifted){
        super(name,comment,duration,date);
        setPoundsLifted(poundsLifted);
    }
    //its creates constructor if String date is provided
    public Weightlifting(String name, String comment, double duration, String date, double poundsLifted){
        super(name,comment,duration,date);
        setPoundsLifted(poundsLifted);
    }
    //its create default constructor
    public Weightlifting(){
        this("","",0,"",0);
    }
    @Override
    public String toString() {
        return String.format("%s\t%.1f", super.toString(), poundsLifted);
    }
    /**
     * it overide function which count amount of calories burned
     * @return calories - amount of calories burned
     */
    @Override
    public double getCaloriesBurned(){
        double duration = getDuration();
        double calories;
        calories = (poundsLifted/duration)*50;
        return  calories;

    }
    public String getType(){
        return "weightlifting";
    }
}
