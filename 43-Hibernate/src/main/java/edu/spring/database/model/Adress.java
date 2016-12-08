package edu.spring.database.model;



import javax.persistence.Embeddable;

@Embeddable
public class Adress {

    private String street;
    private int number;

    public Adress(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public Adress() { }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
