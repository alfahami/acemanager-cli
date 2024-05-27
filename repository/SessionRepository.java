package repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import pojo.Session;

public class SessionRepository {
    private HashMap<Integer, Session> datasource = new HashMap<>();

    public Session createSession(Session newSession) {
        return this.datasource.put(newSession.getId(), new Session(newSession));
    }

    public Session retrieveSession(int id) {
        return new Session(this.datasource.get(id));
    }

    public void removeSession(int id) {
        this.datasource.remove(id);
    }

    public List<Session> getSessionsList() {
        return this.datasource.values().stream()
                .sorted((session1, session2) -> Integer.compare(session1.getId(), session2.getId()))
                .collect(Collectors.toList());
    }
}
