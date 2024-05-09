import model.City;
import model.Member;

public class Main {

    public static void main(String[] args) {
        City fes = new City(1, "FES", "FES-BOULEMANE");
        City fesCopy = new City(fes);

        City fesObj = fes;
        City fesNew = new City(1, "FES", "FES-BOULEMANE");

        System.out.println(fes.toString());
        System.out.println(fesCopy.equals(fes));
        System.out.println(fes==fesObj);
        System.out.println(fesObj.equals(fesNew));
    }
}