package tests;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Test;

import pojo.Member;
import repository.Repository;

public class RepositoryTest { 
    private Member mbr1 = new Member(1, "AMED", "ALI SAID", "12/09/1989", "amed@gmail.com", "nbe388409", 20212345, 1,  1, 1, 1, true);

    Repository repo = new Repository();

    private LinkedHashMap<Integer, Member> mDatastore = new LinkedHashMap<>();

    @Test
    public void testMemberCrud() {
        assertEquals(mDatastore.put(1, mbr1), repo.createMember(1, new Member(1, "AMED", "ALI SAID", "12/09/1989", "amed@gmail.com", "nbe388409", 20212345, 1,  1, 1, 1, true)));
    }
}
