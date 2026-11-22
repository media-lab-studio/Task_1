package praktikum;

import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseTest {
    @Test
    @DisplayName("В каталоге есть три вида булочек, соусы и начинки")
    void catalogOffersBunsAndBothIngredientTypes() {
        Database database = new Database();

        assertEquals(Set.of("black bun", "white bun", "red bun"), database.availableBuns().stream()
                .map(Bun::getName).collect(Collectors.toSet()));
        assertEquals(Set.of(IngredientType.SAUCE, IngredientType.FILLING), database.availableIngredients().stream()
                .map(Ingredient::getType).collect(Collectors.toSet()));
    }
}
