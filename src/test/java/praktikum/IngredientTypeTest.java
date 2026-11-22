package praktikum;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTypeTest {
    @Test
    @DisplayName("Доступны два типа ингредиентов: соус и начинка")
    void supportsSaucesAndFillings() {
        assertEquals(Set.of(IngredientType.SAUCE, IngredientType.FILLING), Set.of(IngredientType.values()));
    }
}
