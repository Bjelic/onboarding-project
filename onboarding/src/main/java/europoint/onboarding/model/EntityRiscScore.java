package europoint.onboarding.model;

import lombok.Data;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class EntityRiscScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Date createdAt;
    @NonNull
    private Date lastUpdatedAt;
    // ko je kreirao???

    public EntityRiscScore(String name, String description, Date createdAt, Date lastUpdatedAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public EntityRiscScore() {

    }
}
