import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Exercise {

    private String name;
    private String comment;
    private double duration;
    private Date date;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getDuration() {
        return duration;
    }

    /**
     * Its setting variable duration as user privide
     * if duration is less than 0 than set it to 0
     * @param duration - double time of exercise
     */
    public void setDuration(double duration) {
        if (duration < 0) {
            this.duration = 0;
        } else {
            this.duration = duration;
        }
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * It changes String date to do Date date format
     * @param date - date of exercise
     */
    public void setDate(String date){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            this.date = df.parse(date);
        }catch(Exception ex){
            //this.date = new Date();
        }
    }
    //its creates constructor if Date date is provided
    public Exercise(String name, String comment, double duration, Date date){
        setName(name);
        setComment(comment);
        setDuration(duration);
        setDate(date);
    }
    //its creates constructor if String date is provided
    public Exercise(String name, String comment, double duration, String date){
        setName(name);
        setComment(comment);
        setDuration(duration);
        setDate(date);
    }
    //its create default constructor
    public Exercise(){
        this("","",0,"");
    }

    /**
     *create abstract class counting how many calories have been burned
     */
    public abstract double getCaloriesBurned();
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return String.format("%-25s%-20s%-25s%-20.2f",name,getType(), df.format(date),duration);
        //return String.format("%s\t%s\t%.1f\t%s",name,comment,duration,df.format(date));
    }
    /*
    @Override
    public int compareTo(Exercise other){
        return date.compareTo(other.date);
    }

     */


    /**
     *create abstract class counting what type of exercise is that
     */
    public abstract String getType();
}
