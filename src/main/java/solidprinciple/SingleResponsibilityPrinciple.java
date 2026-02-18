package solidprinciple;


// A class should have only one reason to change.
public class SingleResponsibilityPrinciple {

    //dont do
    private String name;
    private String email;

    // ❌ User class is doing too many things
    public void getUserInfo() {
        System.out.println(name + " - " + email);
    }

    public void saveToDatabase() {
        System.out.println("Saving " + name + " to DB..."); // DB logic here
    }

    public void sendWelcomeEmail() {
        System.out.println("Sending email to " + email); // Email logic here
    }

    //do
    private String name1;
    private String email1;

    public SingleResponsibilityPrinciple(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class UserRepository {
    public void save(SingleResponsibilityPrinciple user) {
        System.out.println("Saving " + user.getName() + " to DB..."); // Only DB logic
    }
}

class EmailService {
    public void sendWelcome(SingleResponsibilityPrinciple user) {
        System.out.println("Sending email to " + user.getEmail()); // Only email logic
    }
}
