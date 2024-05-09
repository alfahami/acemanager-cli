package model;

import static lib.Helpers.*;

import java.util.Objects;

public class Card {
    private int id;
    private int idMember;
    private int idCity;
    private String cin;
    private String reason;
    private String obtentionDate;
    private String expirationDate;
    private int pin; // used for numerical identity more info:
                     // https://www.identitenumerique.ma/about.html

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be greater than 0");
        this.id = id;
    }

    public int getIdMember() {
        return this.idMember;
    }

    public void setIdMember(int idMember) {
        if (idMember <= 0)
            throw new IllegalArgumentException("Member ID must be greater than 0");
        this.idMember = idMember;
    }

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        if (idCity <= 0)
            throw new IllegalArgumentException("City ID must be greater than 0");
        this.idCity = idCity;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        if (cin == null || cin.isBlank() || cin.length() != 8)
            throw new IllegalArgumentException("CIN must have 8 caracters");
        this.cin = cin;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        if (reason == null || reason.isBlank())
            throw new IllegalArgumentException("Reason cannot be null or blank");
        this.reason = reason;
    }

    public String getObtentionDate() {
        return this.obtentionDate;
    }

    public void setObtentionDate(String obtentionDate) {
        if(obtentionDate == null || obtentionDate.isBlank()) throw new IllegalArgumentException("Obtention date cannot be blank or null");
        if(isValidDateFormat(obtentionDate, obtentionDate)) this.obtentionDate = obtentionDate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        if(expirationDate == null || expirationDate.isBlank()) throw new IllegalArgumentException("Excpiration date cannot be null or blank");
        if(isValidDateFormat(expirationDate, expirationDate)) this.expirationDate = expirationDate;
    }

    public int getPin() {
        return this.pin;
    }

    public void setcnie(int pin) {
        if (pin <= 0 || (String.valueOf(pin).length() != 4))
            throw new IllegalArgumentException("Pin must have 4 digits");
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "[" +
                " Id='" + id + "'" +
                ", CIN='" + cin + "'" +
                ", Reason='" + reason + "'" +
                ", ObtentionDate='" + obtentionDate + "'" +
                ", ExpirationDate='" + expirationDate + "'" +
                ", PIN='" + pin + "'" +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return id == card.id && idMember == card.idMember && idCity == card.idCity && Objects.equals(cin, card.cin)
                && Objects.equals(reason, card.reason) && Objects.equals(obtentionDate, card.obtentionDate)
                && Objects.equals(expirationDate, card.expirationDate) && pin == card.pin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMember, idCity, cin, reason, obtentionDate, expirationDate, pin);
    }

}
