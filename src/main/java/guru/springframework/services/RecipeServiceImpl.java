package guru.springframework.services;
/* BTuladhar created on 1/29/2020 */

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository receipeRepository;

    public RecipeServiceImpl(RecipeRepository receipeRepository) {
        this.receipeRepository = receipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        receipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
