package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceWithIngredients() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(20f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        float price = burger.getPrice();
        Assert.assertEquals(140f, price, 0);
    }
}