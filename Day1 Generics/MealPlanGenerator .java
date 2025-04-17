
import java.util.*;

interface MealPlan {
    String getPlan();
}

class VegetarianMeal implements MealPlan {
    public String getPlan() { return "Vegetarian Meal"; }
}

class VeganMeal implements MealPlan {
    public String getPlan() { return "Vegan Meal"; }
}

class KetoMeal implements MealPlan {
    public String getPlan() { return "Keto Meal"; }
}

class HighProteinMeal implements MealPlan {
    public String getPlan() { return "High Protein Meal"; }
}

class Meal<T extends MealPlan> {
    T meal;
    Meal(T meal) { this.meal = meal; }
    static <T extends MealPlan> void generatePlan(T meal) {
        System.out.println(meal.getPlan());
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        VegetarianMeal vegMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();

        Meal.generatePlan(vegMeal);
        Meal.generatePlan(veganMeal);
    }
}

