package edu.spring.database.model;



import javax.persistence.*;

@Entity

@NamedQueries(
        {
                @NamedQuery(name = "WheelEntity.getAllWheels", query = "select w from WheelEntity w"),
                @NamedQuery(name = "WheelEntity.getById", query = "select w from WheelEntity w where w.id = :id")
        }
)

public class WheelEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;

    public void setCar(CarEntity car) {
        this.car = car;
    }

    @ManyToOne()
    private CarEntity car;

    @Override
    public String toString() {
         return "WheelEntity{" +
                "id=" + id +
                 '}';
    }
    
    public CarEntity getCar() {
    	return this.car;
    }
    
}
