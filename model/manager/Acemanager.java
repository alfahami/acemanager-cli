package model.manager;

import java.util.ArrayList;

import model.Card;
import model.Member;

public interface Acemanager {

    public void addMember(Member newMember);
    public void addMembers(ArrayList<Member> members);
    public ArrayList<Member> getMembers();
    public void removeMemeber(int index);
    public void updateMemeber(int index, Member newMember);
    public Member findMember(String passport);
    public Member getMember(int index);

    public void addCard(Card card);
    public void addCards(ArrayList<Card> cards);
    public ArrayList<Card> getCards();
    public void removeCard(int index);
    public void updateCard(int index, Card newCard);
    public Card findCard(String cin);
    public Card getCard(int index);


}
