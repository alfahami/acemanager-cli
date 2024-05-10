package model.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.Member;

public class Moderator extends Member implements Acemanager {
    private String session_start;
    private String session_end;

    public Moderator() {
        super();
    }

    public String getSession_start() {
        return this.session_start;
    }

    public void setSession_start() {
        this.session_start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy' at 'HH:mm:ss")).toString();
    }

    public String getSession_end() {
        return this.session_end;
    }

    public void setSession_end() {
        this.session_end = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy' at 'HH:mm:ss")).toString();
    }

}
