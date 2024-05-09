import model.City;
import model.Faculty;

public class Main {

    public static void main(String[] args) {
        Faculty fes = new Faculty(1, " ");
        Faculty fesCopy = new Faculty(fes);

        Faculty fesObj = fes;
        Faculty fesNew = new Faculty(1, "FSDM");

        System.out.println(fes.toString());
        System.out.println(fesCopy.equals(fes));
        System.out.println(fes==fesNew);
        System.out.println(fesObj.equals(fesNew));
    }
}