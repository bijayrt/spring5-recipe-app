package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

/* BTuladhar created on 1/28/2020 */
@Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;
}
