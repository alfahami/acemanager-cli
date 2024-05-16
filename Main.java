import static lib.Helpers.*;

import java.util.ArrayList;

import constants.FillTables;
import constants.Role;
import lib.Helpers;
import manager.Manager;
import manager.SuperUser;
import model.City;
import model.Faculty;
import model.Field;
import model.Member;

public class Main {

    public static void main(String[] args) {

        SuperUser root = new SuperUser();
        root.setSession_start();
        
        System.out.println("Root session start: " + root.getSession_start());
        ArrayList<Field> fields = FillTables.fillFieldsFs();
        ArrayList<Faculty> facs = FillTables.fillFaculties(fields);
        root.addCities(FillTables.fillCities(facs));
        ArrayList<Member> baseMembers = FillTables.fillMembers();
        root.addMembers(baseMembers);
        root.addCards(FillTables.fillCards());

        //printAnyList(baseMembers, root);
        root.addMembers(baseMembers);

        printAnyList(root.getMembers(), root);
        


    }
}