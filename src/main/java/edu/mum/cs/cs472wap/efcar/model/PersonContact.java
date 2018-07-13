package edu.mum.cs.cs472wap.efcar.model;

public class PersonContact {

    private Long id;
    private Person person;
    private String email;
    private String phoneNumber;

    public PersonContact(Long id, Person person, String email, String phoneNumber) {
        this.id = id;
        this.person = person;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public PersonContact() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
