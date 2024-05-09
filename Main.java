import model.Field;
import model.Member;

public class Main {

    public static void main(String[] args) {
        Member admin = new Member(1, "TEST", "Shakur", "", "tupac@gmail.com", "NBE388507", 20111473, 1, 1, 1, 1, 1, true);
        Field fes = new Field(0, 1, "SMI", "LF", 3);
        Field fesCopy = new Field(fes);

        Field fesObj = fes;
        Field fesNew = new Field(1, 1, "SMI", "LF", 3);

        System.out.println(fes.toString());
        System.out.println(fesCopy.equals(fes));
        System.out.println(fes==fesObj);
        System.out.println(fesObj.equals(fesNew));
    }
}