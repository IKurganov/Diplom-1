package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "black hole bun", 228);
        Assert.assertEquals("black hole bun", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "black hole bun", 228);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}