package repository;


import java.util.LinkedHashMap;

import pojo.Member;

public class MemberRepository {
    /*
     * This is the only class that will have acess to the datastores of our pojos, in a real-production world these would be on a server or cloud database
     */

    private LinkedHashMap<Integer, Member> mDatastore = new LinkedHashMap<>();    

    // CRUD ON MEMBERS

    public Member createMember(int id, Member member) {
        return this.mDatastore.put(member.getId(), new Member(member));
    }

    public Member retrievMember(int id) {
        if(this.mDatastore == null || id > this.mDatastore.size() || id < this.mDatastore.size()) throw new IllegalArgumentException("No member found");
        return new Member(this.mDatastore.get(id));
    }

    public Member updateMember(Member newMember) {
        return new Member(this.mDatastore.put(newMember.getId(), new Member(newMember)));
    }

    public Member deletMember(int id) {
        return this.mDatastore.remove(id);
    }
}
