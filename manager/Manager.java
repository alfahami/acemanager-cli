package manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import constants.Role;
import model.Card;
import model.City;
import model.Member;

public class Manager extends Member implements Permission {
    private int id;
    private String session_start;
    private String session_end;
    protected Role role;

    private ArrayList<Member> members;
    private ArrayList<Card> cards;
    private ArrayList<City> cities;

    public Manager() {
        this.members = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.cities = new ArrayList<>();
    }

    public Manager(Member member) {
        super(member);
        this.members = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.cities = new ArrayList<>();
    }

    public Manager(Manager source) {
        super();
        this.members = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.cities = new ArrayList<>();
        this.addMembers(source.getMembers());
        this.addCards(source.getCards());
        // Moderator doesn't have cities
        if (this.role.name().equals("ADMINISTRATOR") && source.getCities() != null && !source.getCities().isEmpty()) {
            this.addCities(source.getCities());
        } else {

        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Role getRole() {
        return this.role;
    }

    // public void setRole(Role role) {
    // if (role == null)
    // throw new IllegalArgumentException("Role cannot be null");
    // this.role = role;
    // }

    @Override
    public boolean addMember(Member newMember) {
        newMember.setId(this.members.size() + 1);
        return this.members.add(new Member(newMember));
    }

    @Override
    public void addMembers(ArrayList<Member> members) {
        if (this.members == null)
            this.members = new ArrayList<>();
        if (members.isEmpty())
            throw new IllegalArgumentException("New Member List cannot be null");
        // this.members = new ArrayList<>();
        for (Member member : members) {
            // prefer using the length of members array, in case it's already have data
            member.setId(this.members.size() + 1);
            this.members.add(new Member(member));

        }
    }

    @Override
    public Member updateMemeber(int index, Member newMember) {
        if (index < 0 || index > this.members.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        newMember.setId(index + 1);
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
        if (this.members.isEmpty())
            throw new IllegalArgumentException("No member found in the DB, add some");
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
        card.setId(this.cards.size() + 1);
        return this.cards.add(new Card(card));
    }

    @Override
    public void addCards(ArrayList<Card> cards) {
        if (this.cards == null)
            this.cards = new ArrayList<>();
        if (cards.isEmpty())
            throw new IllegalArgumentException("New Card List cannot be null");
        // this.cards = new ArrayList<>();
        for (Card card : cards) {
            card.setId(this.cards.size() + 1);
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
            throw new IllegalArgumentException("Error: index " + index + " out of bounds");
        return new Card(this.cards.get(index));
    }

    @Override
    public ArrayList<Card> getCards() {
        if (this.cards.isEmpty())
            throw new IllegalArgumentException("No Card found in the DB, please add some");
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

    // ADMIN OPERATIONS

    @Override
    public ArrayList<City> getCities() {
        if (this.role.name().equals("ADMINISTRATOR")) {
            if (this.cities.isEmpty())
                throw new IllegalArgumentException("No city found in cities table, add some");
            ArrayList<City> copyCities = new ArrayList<>();
            for (City city : this.cities) {
                copyCities.add(new City(city));
            }
            return copyCities;
        } else {
            throw new RuntimeException("Rights not guaranted for this user");
        }
    }

    @Override
    public City getCity(int index) {
        if (this.role.name().equals("ADMINISTRATOR")) {
            if (index < 0 || index > this.cities.size())
                throw new IllegalArgumentException("Error: index " + index + "out of bounds");
            return new City(this.cities.get(index));
        } else {
            throw new RuntimeException("Rights not guaranted for this user");
        }
    }

    @Override
    public boolean addCity(City city) {
        if (this.role.name().equals("ADMINISTRATOR")) {
            if (city == null)
                throw new IllegalArgumentException("City cannot be null");
            city.setId(this.cities.size() + 1);
            return this.cities.add(new City(city));
        } else {
            throw new RuntimeException("Rights not guaranted for this user");
        }

    }

    @Override
    public void addCities(ArrayList<City> cities) {
        if (this.role.name().equals("ADMINISTRATOR")) {
            if (this.cards == null)
                this.cards = new ArrayList<>();
            if (cities.isEmpty())
                throw new IllegalArgumentException("New city list cannot be empty");
            for (City city : cities) {
                city.setId(this.cities.size() + 1);
                this.cities.add(new City(city));
            }
        } else {
            throw new RuntimeException("Rights not guaranted for this user");
        }

    }

    @Override
    public City updateCity(int index, City newCity) {
        if (this.role.name().equals("ADMINISTRATOR")) {
            if (index < 0 || index > this.cities.size())
                throw new IllegalArgumentException("Error: index " + index + "out of bounds");
            newCity.setId(index + 1);
            return this.cities.set(index, new City(newCity));
        } else {
            throw new RuntimeException("Rights not guaranted for this user");
        }

    }

    @Override
    public City removeCity(int index) {
        if (this.role.name().equals("ADMINISTRATOR")) {
            if (index < 0 || index > this.cities.size())
                throw new IllegalArgumentException("Error: index " + index + "out of bounds");
            return this.cities.remove(index);
        } else {
            throw new RuntimeException("Rights not guaranted for this user");
        }

    }

    @Override
    public City findCity(String name) {
        if (this.role.name().equals("ADMINISTRATOR")) {
            if (name == null || name.isBlank())
                throw new IllegalArgumentException("City name cannot be null or blank");
            for (City city : this.cities) {
                if (city.getName().equals(name))
                    return city;
            }
            throw new IllegalArgumentException("City not found, add some");
        } else {
            throw new RuntimeException("Rights not guaranted for this user");
        }
    }

    @Override
    public String toString() {
        return "{" +
                " ID='" + getId() +
                " Full name=" + getFirstName() + " " + getLastName() +
                " session start='" + getSession_start() + "'" +
                ", session end='" + getSession_end() + "'" +
                ", cities='" + cities.toString() + "'" +

                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Manager)) {
            return false;
        }
        Manager moderator = (Manager) o;
        return Objects.equals(session_start, moderator.session_start)
                && Objects.equals(session_end, moderator.session_end) && Objects.equals(members, moderator.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session_start, session_end, members);
    }

}
