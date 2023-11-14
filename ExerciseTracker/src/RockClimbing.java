import java.util.Date;

public class RockClimbing extends Exercise{
    private double wallHeight;
    private int reps;
    public double getWallHeight(){
        return wallHeight;
    }

    /**
     * it sets high of wall
     * if high wall parameter is < 0 it sets it as 0
     * @param wallHeight - heigh of wall
     */
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
    /**
     * it sets reps
     * if reps parameter are < 0 it sets it as 0
     * @param reps - amount of reps
     */
    public void setReps(int reps){
        if(reps < 0){
            this.reps = reps;
        }else{
            this.reps = reps;
        }
    }
    //its creates constructor if Date date is provided
    RockClimbing(String name, String comment, double duration, Date date, double wallHeight, int reps){
        super(name,comment,duration,date);
        setWallHeight(wallHeight);
        setReps(reps);
    }
    //its creates constructor if String date is provided
    RockClimbing(String name, String comment, double duration, String date, double wallHeight, int reps){
        super(name,comment,duration,date);
        setWallHeight(wallHeight);
        setReps(reps);
    }
    //its create default constructor
    RockClimbing(){
        this("","",0,"",0,0);
    }
    @Override
    public String toString() {
        return String.format("%s\t%.1f\t%s", super.toString(), wallHeight,Integer.toString(reps));
    }

    /**
     * it overide function which count amount of calories burned
     * @return calories*100 - amount of calories burned
     */
    @Override
    public double getCaloriesBurned(){
        double duration = getDuration();
        double calories;
        calories = (wallHeight*reps)/duration;
        return calories*100;
    }
    public String getType(){
        return "rock climbing";
    }

}
