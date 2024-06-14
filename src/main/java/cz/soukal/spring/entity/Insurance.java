package cz.soukal.spring.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // client ID, auto-generated
    @Column(name = "id_insurance")
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate validFrom;
    @Column(nullable = false)
    private LocalDate validTo;
    @Column(nullable = false)
    private int sum;
    @Column(nullable = false)
    private String subjectOfInsurance;

    // auto-generated time of addition into the database
    @CreationTimestamp
    private LocalDateTime timeOfAddition;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

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

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getSubjectOfInsurance() {
        return subjectOfInsurance;
    }

    public void setSubjectOfInsurance(String subjectOfInsurance) {
        this.subjectOfInsurance = subjectOfInsurance;
    }

    public LocalDateTime getTimeOfAddition() {
        return timeOfAddition;
    }

    public void setTimeOfAddition(LocalDateTime timeOfAddition) {
        this.timeOfAddition = timeOfAddition;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
