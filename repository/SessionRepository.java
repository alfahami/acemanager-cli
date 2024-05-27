package repository;

import java.util.HashMap;

import pojo.Session;

public class SessionRepository {
    private HashMap<Integer, Session> datasource = new HashMap<>();

    public Session createSession(Session newSession) {
        return this.datasource.put(newSession.getId(), new Session(newSession));
    }

    public Session retrieveSession(int id) {
        return new Session(this.datasource.get(id));
    }
}
