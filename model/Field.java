package model;

import java.util.Objects;

public class Field {
    private int id;
    private String abbr;
    private String name;
    private String certificate;
    private int duration;

    public Field(int id, String abbr, String name, String certificate, int duration) {
        setId(id);
        setAbbr(abbr);
        setName(name);
        setCertificate(certificate);
        setDuration(duration);
    }

    public Field(Field source) {
        setId(source.id);
        setAbbr(source.abbr);
        setName(source.name);
        setCertificate(source.certificate);
        setDuration(source.duration);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be greater than 0");
        this.id = id;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String abbr) {
        if(abbr == null || abbr.isBlank()) throw new IllegalArgumentException("Abbreviation cannot be null or blank");
        this.abbr = abbr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }

    public String getCertificate() {
        return this.certificate;
    }

    public void setCertificate(String certificate) {
        if (certificate == null || certificate.isBlank())
            throw new IllegalArgumentException("Certificate cannot be null or blank");
        this.certificate = certificate;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0 || duration > 5)
            throw new IllegalArgumentException("Duration must be between 1 and 5");
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "[" +
                " ID='" + id + "'" +
                ", Name='" + name + "'" +
                ", Certificate='" + certificate + "'" +
                ", Duration='" + duration + "'" +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Field)) {
            return false;
        }
        Field field = (Field) o;
        return id == field.id && Objects.equals(name, field.name)
                && Objects.equals(certificate, field.certificate) && duration == field.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, certificate, duration);
    }

}
