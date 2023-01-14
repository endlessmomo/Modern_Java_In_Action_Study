package chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chap4.Type.*;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public static void main(String[] args) {
        List <Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT)
                , new Dish("beef", false, 700, MEAT)
                , new Dish("chicken", false, 400, MEAT)
                , new Dish("french fries", true, 530, OTHER)
                , new Dish("rice", true, 350, OTHER)
                , new Dish("season fruit", true, 120, OTHER)
                , new Dish("pizza", true, 550, OTHER)
                , new Dish("prawns", false, 300, FISH)
                , new Dish("salmon", false, 450, FISH)
        );

        /*
        * 상위 칼로리 3개를 찾기
        * */

        List <String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames.toString());

        /*
        *
        * */
    }
}
