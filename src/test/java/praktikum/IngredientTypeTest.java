package praktikum;

import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTypeTest {
    @Test
    void supportsSaucesAndFillings() {
        assertEquals(Set.of(IngredientType.SAUCE, IngredientType.FILLING), Set.of(IngredientType.values()));
    }
}
