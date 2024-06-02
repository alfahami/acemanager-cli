import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import constants.Role;
import pojo.Card;
import pojo.City;
import pojo.Faculty;
import pojo.Field;
import pojo.Member;
import repository.CardRepository;
import repository.CityRepository;
import repository.FacultyRepository;
import repository.FieldRepository;
import repository.MemberRepository;
import service.CardService;
import service.CardServiceImpl;
import service.CityService;
import service.CityServiceImpl;
import service.FacultyService;
import service.FacultyServiceImpl;
import service.FieldService;
import service.FieldServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

public class Main {

    static Path[] paths = new Path[] { Paths.get("data/fields.txt"), Paths.get("data/faculties.txt"),
            Paths.get("data/cities.txt"), Paths.get("data/members.txt"), Paths.get("data/cards.txt") };

    static MemberRepository memberRepository = new MemberRepository();
    static MemberService memberService = new MemberServiceImpl(memberRepository);

    static FieldRepository fieldRepository = new FieldRepository();
    static FieldService fieldService = new FieldServiceImpl(fieldRepository);

    static FacultyRepository facultyRepository = new FacultyRepository();
    static FacultyService facultyService = new FacultyServiceImpl(facultyRepository);

    static CityRepository cityRepository = new CityRepository();
    static CityService cityService = new CityServiceImpl(cityRepository);

    static CardRepository cardRepository = new CardRepository();
    static CardService cardService = new CardServiceImpl(cardRepository);

    public static void main(String[] args) {

        // loading our datasources with existing members
        try {
            loadFields();
            loadFaculties();
            loadCities();
            loadMembers();
            loadCards();


            //moderator.addMember();
            

            
        
        
           
            System.out.println();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void loadFields() throws IOException {
        Files.lines(paths[0]).forEach(line -> {
            String[] words = line.split(",");
            fieldService.addField(
                    new Field(Integer.valueOf(words[0]), words[1], words[2], words[3], Integer.valueOf(words[4])));

        });
    }

    public static void loadFaculties() throws IOException {
        Files.lines(paths[1]).forEach(line -> {
            String[] words = line.split(",");
            facultyService.addFaculty(new Faculty(Integer.valueOf(words[0]), words[1], words[2],
                    (ArrayList<Field>) fieldService.getAllFields()));
        });
    }

    public static void loadCities() throws IOException {
        Files.lines(paths[2]).forEach(line -> {
            String[] words = line.split(",");
            cityService.addCity(new City(Integer.valueOf(words[0]), words[1], words[2],
                    (ArrayList<Faculty>) facultyService.getFacultyList()));
        });
    }

    public static void loadMembers() throws IOException {
        Files.lines(paths[3]).forEach(line -> {
            String[] words = line.split(",");
            memberService.addMember(new Member(Integer.valueOf(words[0]), words[1], words[2], words[3], words[4],
                    words[5], Integer.valueOf(words[6]), Integer.valueOf(words[7]), Integer.valueOf(words[8]),
                    Integer.valueOf(words[9]), Integer.valueOf(words[10]), Boolean.valueOf(words[11])));
        });
    }

    public static void loadCards() throws IOException {
        Files.lines(paths[4]).forEach(line -> {
            String[] words = line.split(",");
            cardService.addCard(new Card(Integer.valueOf(words[0]), Integer.valueOf(words[1]), Integer.valueOf(words[2]), words[3], words[4], words[5], words[6], words[7]));

        });
    }
}
