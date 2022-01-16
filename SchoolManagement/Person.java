package SchoolManagement;

public class Person { public String personName;
    private String personPassword;

    public Person(String personName, String personPassword) {
        this.personName = personName;
        this.personPassword = personPassword;
    }

    public Person(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }
}

