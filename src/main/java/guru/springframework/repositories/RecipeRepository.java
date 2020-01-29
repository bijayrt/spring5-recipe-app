package guru.springframework.repositories;
/* BTuladhar created on 1/28/2020 */

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
