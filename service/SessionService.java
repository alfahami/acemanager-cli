package service;

import java.util.List;

import pojo.Session;

public interface SessionService {
    public void addSession(Session newSession);
    public void deleteSession(int id);
    public Session retrieveSession(int id);
    public List<Session> getSessionList();
    public void autoIncrementPK();
}
