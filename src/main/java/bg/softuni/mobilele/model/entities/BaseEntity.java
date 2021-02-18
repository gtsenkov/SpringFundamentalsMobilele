package bg.softuni.mobilele.model.entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected Instant updated;

    @Column(nullable = false)
    protected Instant created;

    public BaseEntity() {
    }

    @PrePersist
    public void prePersist() {
        setCreated(Instant.now());
        setUpdated(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        setUpdated(Instant.now());
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
