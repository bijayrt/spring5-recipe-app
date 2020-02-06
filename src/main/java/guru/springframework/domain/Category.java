package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/* BTuladhar created on 1/28/2020 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    //, fetch = FetchType.EAGER) -- either use fetchType=EAGER or use of @Transactional annotation at the
    // startup resolved the lazy initialization issue.
    private Set<Recipe> recipes;

}
