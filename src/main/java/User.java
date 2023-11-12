public class User {
    private String firstName;
    private String lastName;
    private String email;
    private TypeOfUser typeOfUser;

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getEmail() {
        return this.email;
    }
    public TypeOfUser getTypeOfUser() {
        return this.typeOfUser;
    }
    public User(String firstName, String lastName, String email, TypeOfUser typeOfUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.typeOfUser = typeOfUser;
    }

    public User(User another) {
        this.firstName = another.firstName;
        this.lastName = another.lastName;
        this.email = another.email;
        this.typeOfUser = another.typeOfUser;
    }

    @Override
    public String toString() {
        return firstName + " | " + lastName + " | " + email + " | "  + typeOfUser;
    }

}
