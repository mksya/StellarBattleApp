package mksya.stellar.Stellar.Games.entities.enums;

public enum SHIPCLASS {
    CORVETTE(1), DESTROYER(2), CRUISER(4), CARRIER(6), SUBMARINE(1);

    public final int value;

    SHIPCLASS(int value) {
        this.value = value;
    }
}
