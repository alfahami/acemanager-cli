import constants.FillTables;
import constants.Role;

import manager.Manager;
import model.City;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.setSession_start();

        System.out.println("\n\nAdmin Session start: " + manager.getSession_start());
        
        manager.setRole(Role.ADMINISTRATOR);

        manager.addCities(FillTables.fillCities());

        System.out.println(manager.getCities().toString());
        System.out.println("\n\n\n");
        System.out.println(manager.updateCity(3, manager.getCity(5)));
        System.out.println("\n\n");
        System.out.println(manager.getCities().toString());
        Manager manager2 = new Manager();
        manager2.setSession_start();
        manager2.setRole(Role.MODERATOR);
        manager2.addCities(FillTables.fillCities());


    }
}