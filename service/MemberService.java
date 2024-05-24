package service;

import java.util.List;

import pojo.Member;

public interface MemberService {

    public void addMember(Member newMember);
    public void updateMember(Member newMember);
    public void deleteMember(String passport);
    public Member retrievMember(String passport);
    public List<Member> getMembersArrays();
} 
