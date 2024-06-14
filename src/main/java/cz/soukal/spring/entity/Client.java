package cz.soukal.spring.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // client ID, auto-generated
    @Column(name = "id_client")
    private long id;
    // client name
    @Column(nullable = false)
    private String name;
    //client surname
    @Column(nullable = false)
    private String surname;
    // client phone number
    @Column(nullable = false)
    private int phoneNumber;
    // client email
    @Column(nullable = false)
    private String email;
    // client adress, street and street number
    @Column(nullable = false)
    private String street;
    // client address, city
    @Column(nullable = false)
    private String city;
    // client address, postal code
    @Column(nullable = false)
    private int psc;
    // auto-generated time of addition into the database
    @CreationTimestamp
    private LocalDateTime timeOfAddition;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Insurance> insurance;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTimeOfAddition() {
        return timeOfAddition;
    }

    public void setTimeOfAddition(LocalDateTime timeOfAddition) {
        this.timeOfAddition = timeOfAddition;
    }

    public List<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<Insurance> insurance) {
        this.insurance = insurance;
    }
}
