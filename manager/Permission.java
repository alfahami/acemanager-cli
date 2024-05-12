package manager;

import java.util.ArrayList;

import model.Card;
import model.City;
import model.Member;

public interface Permission {

    public boolean addMember(Member newMember);
    public void addMembers(ArrayList<Member> members);
    public ArrayList<Member> getMembers();
    public Member removeMemeber(int index);
    public Member updateMemeber(int index, Member newMember);
    public Member findMember(String passport);
    public Member getMember(int index);

    public boolean addCard(Card card);
    public void addCards(ArrayList<Card> cards);
    public ArrayList<Card> getCards();
    public Card removeCard(int index);
    public Card updateCard(int index, Card newCard);
    public Card findCard(String cin);
    public Card getCard(int index);

    // Strictly for an andministrator
    public boolean addCity(City newCity);
    public void addCities(ArrayList<City> cities);
    public ArrayList<City> getCitiess();
    public City removeCity(int index);
    public City updateCity(int index, City newCity);
    public City findCity(String name);
    public City getCity(int index);
    public ArrayList<City> getCities();
    


}
