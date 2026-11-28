package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {
    @ParameterizedTest(name = "Ингредиент {1} сохраняет тип {0} и цену {2}")
    @CsvSource({"SAUCE, mustard, 2.5", "FILLING, cheese, 8.75"})
    void returnsTypeNameAndPriceGivenAtCreation(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice());
    }
}
