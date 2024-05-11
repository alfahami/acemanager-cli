package model.manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import model.Card;
import model.Member;

public class Moderator extends Member implements Acemanager {
    private String session_start;
    private String session_end;

    private ArrayList<Member> members;
    private ArrayList<Card> cards;

    public Moderator() {
        super();
        this.members = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    public Moderator(Moderator source) {
        super();
        this.members = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.addMembers(source.getMembers());
        this.addCards(source.getCards());
    }

    public String getSession_start() {
        return this.session_start;
    }

    public void setSession_start() {
        this.session_start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy' at 'HH:mm:ss"))
                .toString();
    }

    public String getSession_end() {
        return this.session_end;
    }

    public void setSession_end() {
        this.session_end = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy' at 'HH:mm:ss"))
                .toString();
    }

    @Override
    public boolean addMember(Member newMember) {
        return this.members.add(new Member(newMember));
    }

    @Override
    public void addMembers(ArrayList<Member> members) {
        if(members.isEmpty()) throw new IllegalArgumentException("New Member List cannot be null");
        //this.members = new ArrayList<>();
        for (Member member : members) {
            this.members.add(new Member(member));
        }
    }

    @Override
    public Member updateMemeber(int index, Member newMember) {
        if (index < 0 || index > this.members.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return this.members.set(index, new Member(newMember));
    }

    @Override
    public Member removeMemeber(int index) {
        if (index < 0 || index > this.members.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return this.members.remove(index);
    }

    @Override
    public Member findMember(String passport) {
        if (passport == null || passport.isBlank())
            throw new IllegalArgumentException("Passport number cannot be null or blank");
        // // int count = 0;
        // if (this.members.isEmpty())
        // throw new NullPointerException("No member exist in our DB table yet.");
        for (Member member : this.members) {
            if (member.getPassport().equals(passport)) {
                return member;
            }
        }
        // if(count == 0) return null;
        throw new IllegalArgumentException("Passport Num: " + passport + " doesn't belong to any member yet.");
    }

    @Override
    public ArrayList<Member> getMembers() {
        if(this.members.isEmpty()) throw new IllegalArgumentException("No member found in the DB, add some");
        ArrayList<Member> copyMembers = new ArrayList<>();
        for (Member member : this.members) {
            copyMembers.add(new Member(member));
        }
        return copyMembers; 
    }

    public Member getMember(int index) {
        if (index < 0 || index > this.members.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return new Member(this.members.get(index));
    }

    @Override
    public boolean addCard(Card card) {
        return this.cards.add(new Card(card));
    }

    @Override
    public void addCards(ArrayList<Card> cards) {
        if(cards.isEmpty()) throw new IllegalArgumentException("New Card List cannot be null");
        // this.cards = new ArrayList<>();
        for (Card card : cards) {
            this.cards.add(new Card(card));
        }
    }

    @Override
    public Card updateCard(int index, Card newCard) {
        if (index < 0 || index > this.cards.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return this.cards.set(index, new Card(newCard));
    }

    @Override
    public Card removeCard(int index) {
        if (index < 0 || index > this.cards.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return this.cards.remove(index);
    }

    @Override
    public Card getCard(int index) {
        if (index < 0 || index > this.cards.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return new Card(this.cards.get(index));
    }

    @Override
    public ArrayList<Card> getCards() {
        if(this.cards.isEmpty()) throw new IllegalArgumentException("No Card found in the DB, please add some");
        ArrayList<Card> copyCards = new ArrayList<>();
        for (Card card : this.cards) {
            copyCards.add(new Card(card));
        }
        return copyCards;
    }

    @Override
    public Card findCard(String cin) {
        if (cin == null || cin.isBlank())
            throw new IllegalArgumentException("CIN number cannot be null or blank");
        // int count = 0;
        // if (this.cards.isEmpty())
        // throw new NullPointerException("No card exist in our DB table yet.");
        for (Card card : this.cards) {
            if (card.getCin().equals(cin)) {
                return card;
            }
        }

        throw new IllegalArgumentException("Card Num: " + cin + " doesn't belong to any member yet.");
    }

    @Override
    public String toString() {
        return "{" +
                " session start='" + getSession_start() + "'" +
                ", session end='" + getSession_end() + "'" +
                ", cards='" + cards.toString() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Moderator)) {
            return false;
        }
        Moderator moderator = (Moderator) o;
        return Objects.equals(session_start, moderator.session_start)
                && Objects.equals(session_end, moderator.session_end) && Objects.equals(members, moderator.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session_start, session_end, members);
    }

}
