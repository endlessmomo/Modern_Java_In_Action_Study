package chap2;

import static chap2.Kind.SHIRT;

public class ClothesShirtFilterPredicate implements ClothesPredicate {
    @Override
    public boolean test(Clothes clothes) {
        return SHIRT.equals(clothes.getKind());
    }
}
