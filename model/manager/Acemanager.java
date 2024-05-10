package model.manager;

import model.Member;

public interface Acemanager {

    public void addMember(Member newMember);
    public void removeMemeber(int index, Member member);
    public void updateMemeber(int index, Member newMember);
    public Member findMember(String passport);
    
}
