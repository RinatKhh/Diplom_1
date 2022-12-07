package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;
    @Mock
    Bun bun;

    Burger burger = new Burger();

    @Before
    public void setUp(){
        Mockito.when(ingredientSauce.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientFilling.getName()).thenReturn("sour cream");
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        assertEquals(2,burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertEquals(0,burger.ingredients.size());
    }

    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(10F);
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        assertEquals(210,burger.getPrice(),0);
    }
    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0,1);
        assertEquals(burger.ingredients.get(1).getName(),ingredientSauce.getName());
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("green bun");
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING).toString().toLowerCase();
        Mockito.when(ingredientFilling.getName()).thenReturn("cheese");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(50F);
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
   //     burger.getPrice();
        String actual = "(==== green bun ====)\r\n" +
                "= filling cheese =\r\n" +
                "(==== green bun ====)\r\n" +
                "\r\n" +
                "Price: 250,000000\r\n";
        assertEquals(burger.getReceipt(),actual);
    }
}