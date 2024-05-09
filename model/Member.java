package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static lib.Helpers.*;
import java.util.Objects;

public class Member {

    private int id;
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
    private int idRole;
    private boolean isMember;


    public Member(int id, String firstName, String lastName, String birthDate, String email, String passport, int matriculeAmci, int idCard, int idCity, int idFaculty, int idField, int idRole, boolean isMember) {
        setId(id);
        setFirstName(firstName); 
        setLastName(lastName);
        setBirthDate(birthDate);
        setAge(age);
        setEmail(email);;
        setPassport(passport);
        setIdCard(idCard);
        setMatriculeAmci(matriculeAmci);
        setIdCity(idCity);
        setIdFaculty(idFaculty);
        setIdField(idField);
        setIdRole(idRole);
        setIsMember(isMember);
    }

    public Member(Member source) {
        setId(source.id);
        setFirstName(source.firstName); 
        setLastName(source.lastName);
        setBirthDate(source.birthDate);
        setAge(source.age);
        setEmail(source.email);;
        setPassport(source.passport);
        setIdCard(source.idCard);
        setMatriculeAmci(source.matriculeAmci);
        setIdCity(source.idCity);
        setIdFaculty(source.idFaculty);
        setIdField(source.idField);
        setIdRole(source.idRole);
        setIsMember(source.isMember);
    }

    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if(id < 0) throw new IllegalArgumentException("Member ID must be greater than 0");
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First name cannot be null or blank");
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be blank or null");
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        if(!isValidDateFormat("dd/MM/yyyy", birthDate)) throw new IllegalArgumentException("Birth date must be in format dd/MM/yyyy and cannot be null or blank. ");
        this.birthDate = birthDate;  
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
        if(!validate(email)) throw new IllegalArgumentException("Email is not valid");
        this.email = email;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        if(passport == null || passport.isBlank() || passport.length() != 9 ) throw new IllegalArgumentException("Passport number must have 9 digits and can't be null nor blank!");
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

    public int getIdRole() {
        return this.idRole;
    }

    public void setIdRole(int role) {
        this.idRole = role;
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


    @Override
    public String toString() {
        return "\n[" +
            "Full Name='" + firstName + " " + lastName + "'" +
            ", age='" + age + "'" +
            ", Email='" + email + "'" +
            ", Passport='" + passport + "'" +
            ", Amci='" + matriculeAmci + "'" +
            ", Member status='" + isMember + "'" +
            "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Member)) {
            return false;
        }
        Member member = (Member) o;
        return id == member.id && Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(birthDate, member.birthDate) && age == member.age && Objects.equals(email, member.email) && Objects.equals(passport, member.passport) && idCard == member.idCard && matriculeAmci == member.matriculeAmci && idCity == member.idCity && idFaculty == member.idFaculty && idField == member.idField && idRole == member.idRole && isMember == member.isMember;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, age, email, passport, idCard, matriculeAmci, idCity, idFaculty, idField, idRole, isMember);
    }
    

}
