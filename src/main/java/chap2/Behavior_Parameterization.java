package chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chap2.Color.*;
import static chap2.Kind.NEAT;
import static chap2.Kind.SHIRT;

public class Behavior_Parameterization {
    public static void main(String[] args) {
        List <Clothes> basket = Arrays.asList(
                new Clothes(WHITE, NEAT, 10000)
                , new Clothes(BLACK, NEAT, 10000)
                , new Clothes(GREEN, NEAT, 10000)
                , new Clothes(GREEN, NEAT, 20000)
                , new Clothes(GREEN, NEAT, 30000)
                , new Clothes(WHITE, SHIRT, 25000)
                , new Clothes(BLACK, SHIRT, 25000)
                , new Clothes(GREEN, SHIRT, 25000)
        );

        /* 비효율적인 코드 DRY : don't repeat yourself 를 어긴다.

        System.out.println("--------------------------------------");
        for (Clothes clothes : filterGreenClothes(basket)) {
            System.out.println("Color : " + clothes.getColor() + ", Kind " + clothes.getKind() + ", Amount " + clothes.getAmount());
        }
        System.out.println("--------------------------------------");
        for (Clothes clothes : filterNeatClothes(basket)) {
            System.out.println("Color : " + clothes.getColor() + ", Kind " + clothes.getKind() + ", Amount " + clothes.getAmount());
        }
        System.out.println("--------------------------------------");
        for (Clothes clothes : filterAmountClothes(basket)) {
            System.out.println("Color : " + clothes.getColor() + ", Kind " + clothes.getKind() + ", Amount " + clothes.getAmount());
        }
        */

        System.out.println("<---------Predicate를 사용한 확장성 ------------->");

        for (Clothes clothes : filterClothes(basket, new ClothesNeatFilterPredicate())) {
            System.out.println("Color : " + clothes.getColor() + ", Kind " + clothes.getKind() + ", Amount " + clothes.getAmount());
        }

        System.out.println("<-------------익명 객체 ------------->");
        List<Clothes> neatClothes = filterClothes(basket, new ClothesPredicate() {
            @Override
            public boolean test(Clothes clothes) {
                return NEAT.equals(clothes.getKind());
            }
        });

        for(Clothes clothes : neatClothes){
            System.out.println("Color : " + clothes.getColor() + ", Kind " + clothes.getKind() + ", Amount " + clothes.getAmount());
        }

        System.out.println("<-------------익명 객체 및 추상화------------->");
        List<Integer> testing = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> over5 = filter(testing, new Predicate <Integer>() {
            @Override
            public boolean test(Integer value) {
                if(value >= 5)
                    return true;

                return false;
            }
        });

        for(Integer value : over5){
            System.out.print(value + " ");
        }
    }

    public static List <Clothes> filterGreenClothes(List <Clothes> basket) {
        List <Clothes> res = new ArrayList <>();
        for (Clothes clothes : basket) {
            if (GREEN.equals(clothes.getColor())) {
                res.add(clothes);
            }
        }
        return res;
    }
    /*
    public static List <Clothes> filterNeatClothes(List <Clothes> basket) {
        List <Clothes> res = new ArrayList <>();
        for (Clothes clothes : basket) {
            if (NEAT.equals(clothes.getKind())) {
                res.add(clothes);
            }
        }
        return res;
    }

    public static List <Clothes> filterAmountClothes(List <Clothes> basket) {
        List <Clothes> res = new ArrayList <>();
        for (Clothes clothes : basket) {
            if (clothes.getAmount() > 15000) {
                res.add(clothes);
            }
        }
        return res;KL,
    }
    */

    public static List <Clothes> filterClothes(List <Clothes> basket, ClothesPredicate p) {
        List <Clothes> res = new ArrayList <>();
        for (Clothes clothes : basket) {
            if (p.test(clothes)) {
                res.add(clothes);
            }
        }
        return res;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p ){
        List<T> res = new ArrayList <>();
        for(T e : list){
            if(p.test(e)){
                res.add(e);
            }
        }
        return res;
    }
}
