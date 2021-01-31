package bg.softuni.mobilele.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
