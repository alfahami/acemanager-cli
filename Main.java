import java.util.ArrayList;

import lib.FillTables;
import model.Card;
import model.Member;
import model.manager.Moderator;

public class Main {

    public static void main(String[] args) {

        Moderator modFes = new Moderator();
        modFes.setSession_start();
        System.out.println("Session start: " + modFes.getSession_start());
        modFes.addMembers(FillTables.fillMembers());
        modFes.addCards(FillTables.fillCards());

        System.out.println("\n\n" + modFes.getCards().toString());
        System.out.println("\n\n" + modFes.getMembers().toString());

        System.out.println("\n\n\nRetrieving the 1st Member" + modFes.getMember(0));
        System.out.println("\n\n\nRetrieving the 1st Card" + modFes.getCard(0));
        modFes.setSession_end();
        System.out.println("\n\nSession ends: " + modFes.getSession_end());

    }
}