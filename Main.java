import model.Member;

public class Main {

    public static void main(String[] args) {
        Member admin = new Member(1, "TEST", "Shakur", "21/12/1992", "tupAC@gmail.com", null, 20111473, 1, 1, 1, 1, 1, true);

        System.out.println(admin.toString());
    }
}