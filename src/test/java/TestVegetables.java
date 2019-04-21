import model.Vegetable;
import model.VegetableType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestVegetables {
    @Test
    void testCreateCucumber(){
        Vegetable cucumber = new Vegetable(VegetableType.Cucumber,0.1);
        assertSame(cucumber.getType(), VegetableType.Cucumber);
        assertEquals(cucumber.getCalories(), VegetableType.Cucumber.caloriesPerKg * 0.1);
        assertEquals(0.1, cucumber.getWeight());
    }
    @Test
    void testCreateAllVegetables(){
        for(VegetableType type:VegetableType.values()){
            double weight = Math.random()*1000;
            tryCreateVegetable(type,weight);

        }
    }

    @Test
    void testCreateAllVegetablesWithWeight0(){
        for(VegetableType type:VegetableType.values()){
            tryCreateVegetable(type,0);

        }
    }

    void tryCreateVegetable(VegetableType type, double weight){
        Vegetable vegetable = new Vegetable(type,weight);
        assertSame(vegetable.getType(), type);
        assertEquals(vegetable.getCalories(), Math.floor(type.caloriesPerKg * weight));
        assertEquals(weight, vegetable.getWeight());
    }
}
