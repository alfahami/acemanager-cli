import model.Member;

public class Main {

    public static void main(String[] args) {
        Member admin = new Member(1, "TEST", "Shakur", "21/12/19929", "tupac@gmail.com", "NBE388507", 20111473, 1, 1, 1, 1, 1, true);

        Member shakur = new Member(1, "TEST", "Shakur", "21/12/1992", "tupac@gmail.com", "NBE388507", 20111473, 1, 1, 1, 1, 1, true);


        Member moderator = admin;
        Member amed = new Member(moderator);
        System.out.println(amed);
        System.out.println(moderator==admin);
        System.out.println(admin==shakur);
        System.out.println(admin.toString());
        System.out.println(moderator.toString());
    }
}