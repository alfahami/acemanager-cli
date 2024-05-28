package repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    public void removeCard(String cin) {
        this.datasource.remove(cin);
    }

    public List<Card> getCardList() {
        return this.datasource.values().stream()
                    .sorted((card1, card2) -> Integer.compare(card1.getId(), card2.getId()) ).collect(Collectors.toList())
                    ;
    }
    
}
