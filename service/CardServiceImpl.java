package service;

import java.util.List;

import pojo.Card;
import repository.CardRepository;

public class CardServiceImpl implements CardService {

    CardRepository repository = new CardRepository();

    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addCard(Card newCard) {
        this.repository.createCard(newCard);
    }

    @Override
    public void updateCard(Card newCard) {
        this.repository.updateCard(newCard);
    }

    @Override
    public void deleteCard(String cin) {
        this.repository.removeCard(cin);
    }

    @Override
    public Card retrieveCard(String cin) {
       return this.repository.retrieveCard(cin);
    }

    @Override
    public List<Card> getCardList() {
        return this.repository.getCardList();
    }

    @Override
    public int autoIncrementPK() {
        if(this.repository.getCardList() != null && this.repository.getCardList().size() > 0) return this.repository.getCardList().size() + 1;
        else return 1;
    }
    
}
