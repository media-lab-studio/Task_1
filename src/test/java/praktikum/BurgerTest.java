package praktikum;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BurgerTest {
    private final Burger burger = new Burger();
    private final Ingredient cheese = new Ingredient(IngredientType.FILLING, "cheese", 3.5f);
    private final Ingredient mustard = new Ingredient(IngredientType.SAUCE, "mustard", 2f);

    @Test
    void priceIncludesBothBunHalvesAndEachIngredient() {
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(10f);
        burger.setBuns(bun);
        burger.addIngredient(cheese);
        burger.addIngredient(mustard);

        assertEquals(25.5f, burger.getPrice());
    }

    @Test
    void removingIngredientAtIndexKeepsOtherIngredients() {
        burger.addIngredient(cheese);
        burger.addIngredient(mustard);

        burger.removeIngredient(1);

        assertEquals(List.of(cheese), burger.ingredients);
    }

    @Test
    void movingIngredientPreservesRelativeOrderOfOthers() {
        Ingredient onion = new Ingredient(IngredientType.FILLING, "onion", 1f);
        burger.addIngredient(cheese);
        burger.addIngredient(mustard);
        burger.addIngredient(onion);

        burger.moveIngredient(0, 2);

        assertEquals(List.of(mustard, onion, cheese), burger.ingredients);
    }

    @Test
    void receiptListsBunIngredientsInOrderAndTotalPrice() {
        burger.setBuns(new Bun("sesame", 4f));
        burger.addIngredient(mustard);
        burger.addIngredient(cheese);

        String expected = String.format("(==== sesame ====)%n= sauce mustard =%n= filling cheese =%n"
                + "(==== sesame ====)%n%nPrice: %f%n", 13.5f);
        assertEquals(expected, burger.getReceipt());
    }
}
