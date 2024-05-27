package service;

import java.util.List;

import pojo.Session;
import repository.SessionRepository;

public class SessionServiceImpl implements SessionService {

    private SessionRepository repository;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addSession(Session newSession) {
        newSession.setId(autoIncrementPK());
        this.repository.createSession(newSession);
    }

    @Override
    public void deleteSession(int id) {
        this.repository.removeSession(id);
    }

    @Override
    public Session retrieveSession(int id) {
        return repository.retrieveSession(id);
    }

    @Override
    public List<Session> getSessionList() {
        return this.repository.getSessionsList();
    }

    @Override
    public int autoIncrementPK() {
        // get the sorted list of the current repo
        if (this.repository.getSessionsList() != null && this.repository.getSessionsList().size() > 0)
            // return it size the next ID
            return this.repository.getSessionsList().size() + 1;
        else
            return 1;
    }
    
}
