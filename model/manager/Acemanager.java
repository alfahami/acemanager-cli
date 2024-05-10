package model.manager;

import model.Card;
import model.Member;

public interface Acemanager {

    public void addMember(Member newMember);
    public void removeMemeber(int index);
    public void updateMemeber(int index, Member newMember);
    public Member findMember(String passport);
    public Member getMember(int index);

    public void addCard(Card card);
    public void removeCard(int index);
    public void updateCard(int index, Card newCard);
    public void findCard(String cin);
    public Card getCard(int index);


}
