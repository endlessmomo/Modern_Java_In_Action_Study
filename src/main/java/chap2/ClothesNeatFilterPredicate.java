package chap2;

import static chap2.Kind.NEAT;

public class ClothesNeatFilterPredicate implements ClothesPredicate {
    @Override
    public boolean test(Clothes clothes) {
        return NEAT.equals(clothes.getKind());
    }
}

