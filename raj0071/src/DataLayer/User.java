package DataLayer;

public class User {
    private int worker_id;
    private String firstName;
    private String lastName;

    public User(int worker_id, String firstName, String lastName) {
        this.worker_id = worker_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
