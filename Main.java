import model.Card;
import model.Field;
import model.Member;

public class Main {

    public static void main(String[] args) {
        
        Card fes = new Card(1, 1, 1, "C018507J", "WORK", "21/09/2023", "21/09/2026", 12346);
        Card fesCopy = new Card(fes);

        Card fesObj = fes;
        Card fesNew = new Card(1, 1, 1, "C018507J", "WORK", "21/09/2023", "21/09/2026", 1234);

        System.out.println(fes.toString());
        System.out.println(fesCopy.equals(fes));
        System.out.println(fes==fesObj);
        System.out.println(fesObj.equals(fesNew));
    }
}