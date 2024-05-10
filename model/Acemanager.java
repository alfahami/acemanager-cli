package model;

import java.util.ArrayList;

public abstract class Acemanager {
    private String session_start;
    private String session_end;
    private ArrayList<Member> members;

    public void addMember(Member newMember) {}
    public void removeMemeber(int index, Member member) {}
    public void updateMemeber(int index, Member newMember) {}
    public Member findMember(String passport) { return null; }
    
}
