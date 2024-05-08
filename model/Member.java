package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import lib.Helpers;

public class Member {

    private int idMember;
    private String firstName;       
    private String lastName;        
    private String birthDate;  // can't be null or not in the format: dd/MM/yyyy
    private int age;           // Should do automatically be calucated from birthdate
    private String email;   
    private String passport;   // NBE388510, MUST: 9 chars max
    private int idCard;
    private int matriculeAmci; // 20111473, MUST: 8 chars
    private int idCity;
    private int idFaculty;
    private int idField;
    private int role;
    private boolean isMember;


    public int getIdMember() {
        return this.idMember;
    }

    public void setIdMember(int idMember) {
        if(idMember < 0) throw new IllegalArgumentException("Member ID must be greater than 0");
        this.idMember = idMember;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.equals(null) || firstName.isBlank()) throw new IllegalArgumentException("First name cannot be null or blank");
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.equals(null) || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be blank or null");
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        toAge(birthDate);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = toAge(this.birthDate);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if(!Helpers.validate(email)) throw new IllegalArgumentException("Email is not valid");
        this.email = email;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        if(passport.length() < 0 || passport.length() > 9) throw new IllegalArgumentException("Passport number must have 9 digits!");
        this.passport = passport;
    }

    public int getIdCard() {
        return this.idCard;
    }

    public void setIdCard(int idCard) {
        if(idCard < 0) throw new IllegalArgumentException("Card ID must be greater than 0");
        this.idCard = idCard;
    }

    public int getMatriculeAmci() {
        return this.matriculeAmci;
    }

    public void setMatriculeAmci(int matriculeAmci) {
        // AMCI matricule MUST be 8 digits
        if(matriculeAmci <= 0 || String.valueOf(matriculeAmci).length() != 8) throw new IllegalArgumentException("AMCI matricule must contain 8 digits");
        this.matriculeAmci = matriculeAmci;
    }

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        if(idCity < 0) throw new IllegalArgumentException("City ID must be greater than 0");
        this.idCity = idCity;
    }

    public int getIdFaculty() {
        return this.idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        if(idFaculty < 0) throw new IllegalArgumentException("Faculty ID must be greater than 0");
        this.idFaculty = idFaculty;
    }

    public int getIdField() {
        return this.idField;
    }

    public void setIdField(int idField) {
        if(idField < 0) throw new IllegalArgumentException("Field ID must be greater than 0");
        this.idField = idField;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isIsMember() {
        return this.isMember;
    }

    public boolean getIsMember() {
        return this.isMember;
    }

    public void setIsMember(boolean isMember) {
        if(!(isMember == true || isMember == false)) throw new IllegalArgumentException("Member is either a member (true) or not(false)");
        this.isMember = isMember;
    }

    public int toAge(String birthDate) {
        // Calculate the date using LocalDate and Period 
        return Period.between(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now()).getYears();
        
    }

}
