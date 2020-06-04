/*In this class we gonna use Attributes and Getters and Setters methods so we can work with problem domain*/
/*We going to use Attributes belonging to each one of columns from our table 'persona' in DB*/
package domain;

public class Person {
    /*Attributes from our DB in MySQL WorkBench*/
    private int id_person;
    private String name;
    private String lastName;
    private String email;
    private String phone;

    /*Getters and Setters methods*/
    public int getId_person() {
        return id_person;
    }
    public void setId_person(int id_person) {
        this.id_person = id_person;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /*toString method to present all our values during program execution*/
    @Override
    public String toString() {
        return "\n\nId: " + id_person + "\nName: " + name + "\nLast Name: " + lastName + "\nEmail: " + email + "\nPhone: " + phone;
    }
}