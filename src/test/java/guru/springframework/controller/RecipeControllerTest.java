package guru.springframework.controller;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    @InjectMocks
    RecipeController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new RecipeController(recipeService);

    }

    @Test
    void testGetRecipe() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(recipeService.findById(anyLong())).thenReturn(recipe);
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }

    @Test
    void showById() {
    }
}