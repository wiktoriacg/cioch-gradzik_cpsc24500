import java.util.Comparator;

public class ExerciseCompareByCalories implements Comparator<Exercise> {
    /**
     * its override compare function, which is setting order by burned calories
     * @param one the first Exercise object to be compared.-
     * @param two the second Exercise object to be compared.
     * @return int -1 if object c1 < c2
     *              0 if object c1= c2
     *              1 if object c1 > c2
     */
    @Override
    public  int compare(Exercise one, Exercise two){
        double cal1 = one.getCaloriesBurned();
        double cal2 = two.getCaloriesBurned();
        if(cal1 < cal2){
            return -1;
        }else if(cal1 == cal2){
            return 0;
        }else {
            return 1;
        }
    }
}
