import java.util.ArrayList;
import java.util.Date;

public class RunWalk extends Exercise{
    private double distance;
    public double getDistance(){
        return distance;
    }
    /**
     * it sets distance
     * if distance parameter is < 0 it sets it as 0
     * @param distance - distance of run
     */
    public void setDistance(double distance){
        if (distance < 0){
            this.distance = 0;
        }else{
            this.distance = distance;
        }
        
    }
    //its creates constructor if Date date is provided
    public RunWalk(String name, String comment, double duration, Date date, double distance){
        super(name,comment,duration,date);
        setDistance(distance);
    }
    //its creates constructor if String date is provided
    public RunWalk(String name, String comment, double duration, String date, double distance){
        super(name,comment,duration,date);
        setDistance(distance);
    }
    //its create default constructor
    public RunWalk() {
        this("", "", 0, "", 0);
    }

    /*
    @Override
    public String toString() {
        return String.format("%-20s", super.toString());
        //return String.format("%s\t%.1f", super.toString(), distance);
    }

     */

    /**
     * it override function which count amount of calories burned
     * @return calories - amount of calories burned
     */
    @Override
    public  double getCaloriesBurned(){
        double calories;
        double duration = getDuration();
        calories = (distance/duration)*9000;
        return calories;
    }
    public String getType(){
        return "run walk";
    }
    public static double getTotalCaloriesBurned(ArrayList<Exercise> exercise) {
        double totalCalories = 0;
        for (Exercise ex : exercise) {
            totalCalories = totalCalories + ex.getCaloriesBurned();
        }
        return totalCalories;
    }

}
