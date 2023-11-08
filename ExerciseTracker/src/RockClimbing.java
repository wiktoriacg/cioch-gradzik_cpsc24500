import java.util.Date;

public class RockClimbing extends Exercise{
    private double wallHeight;
    private int reps;
    public double getWallHeight(){
        return wallHeight;
    }
    public void setWallHeight(double wallHeight){
        if(wallHeight < 0){
            this.wallHeight = 0;
        }else{
            this.wallHeight = wallHeight;
        }
    }
    public int getReps(){
        return reps;
    }
    public void setReps(int reps){
        if(reps < 0){
            this.reps = reps;
        }else{
            this.reps = reps;
        }
    }
    RockClimbing(String name, String comment, double duration, Date date, double wallHeight, int reps){
        super(name,comment,duration,date);
        setWallHeight(wallHeight);
        setReps(reps);
    }
    RockClimbing(){
        this("","",0,null,0,0);
    }
    @Override
    public String toString() {
        return String.format("%s\t%.1f%f", super.toString(), wallHeight,reps);
    }
    @Override
    public double calculateCalories(){
        double duration = getDuration();
        double calories;
        calories = (wallHeight*reps)/duration;
        return calories;
    }

}
