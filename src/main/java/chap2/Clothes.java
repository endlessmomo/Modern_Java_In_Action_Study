package chap2;

public class Clothes {
    private final Color color;
    private final Kind kind;
    private final int amount;

    public Clothes(Color color, Kind kind, int amount) {
        this.color = color;
        this.kind = kind;
        this.amount = amount;
    }

    public Color getColor() {
        return color;
    }

    public Kind getKind() {
        return kind;
    }

    public int getAmount() {
        return amount;
    }
}
