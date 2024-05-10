package model.manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Member;

public class Moderator extends Member implements Acemanager {
    private String session_start;
    private String session_end;

    private ArrayList<Member> members;

    public Moderator() {
        super();
        this.members = new ArrayList<>();
    }

    public String getSession_start() {
        return this.session_start;
    }

    public void setSession_start() {
        this.session_start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy' at 'HH:mm:ss")).toString();
    }

    public String getSession_end() {
        return this.session_end;
    }

    public void setSession_end() {
        this.session_end = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy' at 'HH:mm:ss")).toString();
    }

    @Override
    public void addMember(Member newMember) {
        this.members.add(new Member(newMember));
    }

    @Override
    public void updateMemeber(int index, Member newMember) {
        if(index < 0 || index > this.members.size()) throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        this.members.set(index, new Member(newMember));
    }

    @Override
    public void removeMemeber(int index) {
        if(index < 0 || index > this.members.size()) throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        this.members.remove(index);
    }

    @Override
    public Member findMember(String passport) {
        if(passport == null || passport.isBlank()) throw new IllegalArgumentException("Passport number cannot be null or blank");
        //int count = 0;
        if(this.members == null) return null;
        else {
            for (Member member : this.members) {
                if(member.getPassport().equals(passport)) {
                    return member;
                }
            }   
        }
        //if(count == 0) return null;
        return null;
    }

    public Member getMember(int index) {
        if(index < 0 || index > this.members.size()) throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return new Member(this.members.get(index));
    }
}
