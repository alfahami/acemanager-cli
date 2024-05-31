package service;

import java.util.List;

import constants.Role;
import pojo.Member;
import repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private MemberRepository repository = new MemberRepository();


    public MemberServiceImpl() {
        
    }

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addMember(Member newMember) {
        newMember.setId(this.autoIncrementPK());
        this.repository.createMember(new Member(newMember));
    }

    @Override
    public void updateMember(Member newMember) {
        this.repository.updateMember(new Member(newMember));
    }

    @Override
    public void deleteMember(String passport) {
        this.repository.deletMember(passport);
    }

    @Override
    public Member retrieveMember(String passport) {
        return this.repository.retrievMember(passport);
    }

    @Override
    public List<Member> getMembersArrays() {
        return this.repository.getMembersArrays();
    }

    @Override
    public int autoIncrementPK() {
        // get the sorted list of the current repo
        if (this.repository.getMembersArrays() != null && this.repository.getMembersArrays().size() > 0)
            // return it size the next ID
            return this.repository.getMembersArrays().size() + 1;
        else
            return 1;
    }

}
