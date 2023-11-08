import java.util.Comparator;

public class ExerciseCompareByCalories implements Comparator<Exercise> {
    @Override
    public  int compare(Exercise one, Exercise two){
        double cal1 = one.calculateCalories();
        double cal2 = two.calculateCalories();
        if(cal1 < cal2){
            return -1;
        }else if(cal1 == cal2){
            return 0;
        }else {
            return 1;
        }
    }
}
