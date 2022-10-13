package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price, Ingredient ingredient) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][] {
                { SAUCE,"тест сoус",1.0F,new Ingredient(SAUCE,"тест сoус",1.0F)},
                { FILLING,"тест начинка",1.0F,new Ingredient(FILLING,"тест начинка",1.0F)},
        };
    }

    @Test
    public void getPrice() {
        assertEquals(price,ingredient.getPrice(),0);
    }

    @Test
    public void getName() {
        assertEquals(name,ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(type,ingredient.getType());
    }
}