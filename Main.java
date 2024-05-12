import constants.FillTables;
import manager.Admin;
import manager.Manager;
import model.City;

public class Main {

    public static void main(String[] args) {

        Admin admin = new Admin();
        admin.setSession_start();
        System.out.println("Admin session start: " + admin.getSession_start());
        admin.addCities(FillTables.fillCities());

        System.out.println("\n\n" + admin.toString());
        System.out.println("Retrieving the city at 3rd position: " + admin.getCity(2).toString());
        
        admin.removeCity(0);
        System.out.println("\n\nDeleting the 1st city, it shouldn't appear in the display below: \n\n" + admin.toString());
        
        City retrievedCity = admin.getCity(4);
        retrievedCity.setName("Marrakech");
        admin.updateCity(4, retrievedCity);
        System.out.println("\n\nWe changed the 4th city to Marrakech , below's confirmation: \n\n" + admin.toString());        

        admin.setSession_end();
        System.out.println("\n\nAdmin session end: " + admin.getSession_end());
        Manager modFes = new Manager();
        modFes.setSession_start();
        System.out.println("\n\nModerator Session start: " + modFes.getSession_start());
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