package repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import pojo.Member;

public class MemberRepository {
    /*
     * This is the only class that will have acess to the datastores of our pojos, in a real-production world these would be the member table on a server or cloud database
     */

    private LinkedHashMap<String, Member> mDatastore = new LinkedHashMap<>();    

    // CRUD ON MEMBERS

    public Member createMember(Member newMember) {
        return this.mDatastore.put(newMember.getPassport(), newMember);
    }

    public Member retrievMember(String passport) {
        return new Member(this.mDatastore.get(passport));
    }

    public Member updateMember(Member newMember) {
        return new Member(this.mDatastore.put(newMember.getPassport(), newMember));
    }

    public Member deletMember(String passport) {
        return this.mDatastore.remove(passport);
    }

    public List<Member> getMembersArrays() {
        return this.mDatastore.values().stream().sorted((mbr1, mbr2) -> Integer.compare(mbr1.getId(), mbr2.getId()))
                            .collect(Collectors.toList());
    }
}
