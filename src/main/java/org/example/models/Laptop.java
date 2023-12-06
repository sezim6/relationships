package org.example.models;

import jakarta.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String invented_by;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInvented_by() {
        return invented_by;
    }

    public void setInvented_by(String invented_by) {
        this.invented_by = invented_by;
    }
    public Laptop() {
    }

    public Laptop( String model, String invented_by) {
        this.model = model;
        this.invented_by = invented_by;
    }

    @Override
    public String toString() {
        return "Laptop " +
                "id " + id +
                "model " + model + '\'' +
                "invented_by " + invented_by + '\'' ;
    }
}
