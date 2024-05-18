package manager;

import java.util.ArrayList;

import constants.Role;
import model.Member;

public class SuperUser extends Manager {

    private int id;
    private ArrayList<Manager> managers;
    
    public SuperUser() {
        super();
        this.role = Role.ADMINISTRATOR;
        this.managers = new ArrayList<>();

    }

    public SuperUser(Member member) {
        super(member);
        this.setRole(this, Role.ADMINISTRATOR);
        this.managers = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Manager> getManagers() {
        return this.managers;
    }

    // Make administrator
    public Manager makeManager(String role, int index, ArrayList<Member> members, String city) {
        if(city == null || city.isBlank()) throw new IllegalArgumentException("City cannot be null or blank");
        if (members == null || members.isEmpty())
            throw new IllegalArgumentException("Not a single member is found.");
        if (index < 0 || index > members.size())
            throw new IllegalArgumentException("Index " + index + "out of bounds");

        Manager manager = new Manager(new Member(members.get(index)));
        switch (role) {
            case "ADMINISTRATOR":
                this.setRole(manager, Role.ADMINISTRATOR);
                break;
            case "MODERATOR":
                this.setRole(manager, Role.MODERATOR);
                break;
            default:
                break;
        }
        this.addManager(manager);

        int i = this.managers.indexOf(manager);
        this.managers.get(i).setId(i+1);

        return manager;
    }

    public void changeManageRole(int index) {
        Manager retrievedManager = this.managers.get(index);

        if (retrievedManager.role.name().equals("MODERATOR")) {
            this.setRole(retrievedManager, Role.ADMINISTRATOR);
            this.managers.set(index, retrievedManager);
        } else
            this.setRole(retrievedManager, Role.MODERATOR);
            this.managers.set(index, retrievedManager);
    }

    public void removeManager(int index) {
        if (index <= 0 || index > this.managers.size())
            throw new IllegalArgumentException("Index " + index + "out of bounds");
        if (this.managers == null || this.managers.isEmpty())
            throw new RuntimeException("No manager exists yet, please add one");
        this.managers.remove(index);
    }

    public void setRole(Manager manager, Role role) {
        if (role == null)
            throw new IllegalArgumentException("Role cannot be null");
        manager.role = role;
    }

    public boolean addManager(Manager manager) {
        if (manager == null)
            throw new IllegalArgumentException("Manager cannot be null");
        return this.managers.add(manager);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", managers='" + this.managers.toString() + "'" +
                "}";
    }

}
