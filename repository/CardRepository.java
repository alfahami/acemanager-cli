package repository;

import java.util.HashMap;

import pojo.Card;

public class CardRepository {
    private HashMap<String, Card> datasource = new HashMap<>();

    public Card createCard(Card newCard) {
        return this.datasource.put(newCard.getCin(), new Card(newCard));
    }

    public Card retrieveCard(String cin) {
        return new Card(this.datasource.get(cin));
    }

    public void updateCard(Card newCard) {
        this.datasource.put(newCard.getCin(), new Card(newCard));
    }

    
}
