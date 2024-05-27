import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import pojo.Faculty;
import pojo.Field;
import pojo.Member;
import repository.FieldRepository;
import repository.MemberRepository;
import service.FieldService;
import service.FieldServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

public class Main {

    static Path[] paths = new Path[] { Paths.get("data/fields.txt"), Paths.get("data/faculties.txt"),
            Paths.get("data/cities.txt"), Paths.get("data/members.txt"), Paths.get("data/cards.txt") };

    static MemberRepository memberRepository = new MemberRepository();
    static MemberService memberService = new MemberServiceImpl(memberRepository);

    public static void main(String[] args) {

        try {
            loadMembers();
            ArrayList<Member> members = (ArrayList<Member>) memberService.getMembersArrays();
            System.out.println(members.toString());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void loadMembers() throws IOException {
        Files.lines(paths[3]).forEach(line -> {
            String[] words = line.split(",");
            memberService.addMember(new Member(Integer.valueOf(words[0]), words[1], words[2], words[3], words[4],
                    words[5], Integer.valueOf(words[6]), Integer.valueOf(words[7]), Integer.valueOf(words[8]),
                    Integer.valueOf(words[9]), Integer.valueOf(words[10]), Boolean.valueOf(words[11])));
        });
    }
}
