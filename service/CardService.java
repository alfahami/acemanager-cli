package service;

import java.util.List;

import pojo.Card;

public interface CardService {
    public void addCard(Card newCard);
    public void updateCard(Card newCard);
    public void deleteCard(String cin);
    public Card retrieveCard(String cin);
    public List<Card> getCardList();
    public int autoIncrementPK();

}
