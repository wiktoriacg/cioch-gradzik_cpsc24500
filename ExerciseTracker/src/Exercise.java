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
    public Exercise(String name, String comment, double duration, Date date){
        setName(name);
        setComment(comment);
        setDuration(duration);
        setDate(date);
    }
    public Exercise(){
        this("","",0,null);
    }
    public abstract double calculateCalories();
    @Override
    public String toString() {
        return String.format("%s\t%s\t%.1f\t%s", name,comment,duration,date);
    }
    //@Override
    public int compareTo(Exercise other){
        return date.compareTo(other.date);
    }
}
