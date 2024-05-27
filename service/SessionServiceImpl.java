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
        this.repository.createSession(newSession);
    }

    @Override
    public void deleteSession(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSession'");
    }

    @Override
    public Session retrieveSession(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieveSession'");
    }

    @Override
    public List<Session> getSessionList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSessionList'");
    }

    @Override
    public void autoIncrementPK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autoIncrementPK'");
    }
    
}
