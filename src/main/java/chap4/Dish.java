package chap4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chap4.Type.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

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
    }
}
