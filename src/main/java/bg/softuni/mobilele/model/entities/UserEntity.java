package bg.softuni.mobilele.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    private String username;
    private String lastName;
    private boolean isActive;
    private String imageUrl;
    @ManyToMany
    private List<UserRoleEntity> userRoles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", userRoles=" + userRoles +
                ", id=" + id +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
