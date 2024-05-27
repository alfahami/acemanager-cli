package pojo;

import static helpers.Helpers.*;

public class Session {
    private int id;
    private int idMember;
    private String session_start;
    private String session_end;

    public Session(Session source) {
        setId(source.id);
        setIdMember(source.idMember);
        setSession_start(source.session_start);
        setSession_end(source.session_end);

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id < 0)
            throw new IllegalArgumentException("Member ID must be greater than 0");
        this.id = id;
    }

    public int getIdMember() {
        return this.idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getSession_start() {
        return this.session_start;
    }

    public void setSession_start(String session_start) {
        setDateException(session_start);
        this.session_start = session_start;
    }

    public String getSession_end() {
        return this.session_end;
    }

    public void setSession_end(String session_end) {
        setDateException(session_end);
        this.session_end = session_end;
    }
}
