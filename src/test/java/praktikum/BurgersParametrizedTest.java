package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class BurgersParametrizedTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "{index}: {0}-{3}")
    public static Iterable<Object[]> getIngredientData() {
        return Arrays.asList(new Object[][]{
                {"black hole bun", "SAUCE", "HoT sAuCe", 227.1369f},
                {"thin bun", "FILLING", "diNosAur", 677.0f}
        });
    }

    @Parameterized.Parameter(0)
    public String nameBun;

    @Parameterized.Parameter(1)
    public String type;

    @Parameterized.Parameter(2)
    public String nameIngredient;

    @Parameterized.Parameter(3)
    public float ingredientPrice;

    @Test
    public void checkGetReceiptReturnsCorrectValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf(type));
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", nameBun, type.toLowerCase(), nameIngredient, nameBun, ingredientPrice);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}