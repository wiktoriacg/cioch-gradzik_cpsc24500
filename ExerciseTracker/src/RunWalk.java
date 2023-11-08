import java.util.Date;

public class RunWalk extends Exercise{
    private double distance;
    public double getDistance(){
        return distance;
    }
    public void setDistance(double distance){
        if (distance < 0){
            this.distance = 0;
        }else{
            this.distance = distance;
        }
    }
    public RunWalk(String name, String comment, double duration, Date date, double distance){
        super(name,comment,duration,date);
        setDistance(distance);
    }
    public RunWalk(){
        this("","",0,null,0);
    }
    @Override
    public String toString() {
        return String.format("%s\t%.1f", super.toString(), distance);
    }
    @Override
    public  double calculateCalories (){
        double calories;
        double duration = getDuration();
        calories = (distance/duration)*9000;
        return calories;
    }

}
