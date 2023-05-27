package fr.nokane.crafting.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum WalkerVariant {
    DEFAULT(0),
    WALKER_1(1),
    WALKER_2(2),
    WALKER_3(3),
    WALKER_4(4);

    private static final WalkerVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(WalkerVariant::getId)).toArray(WalkerVariant[]::new);

    private final int id;

    WalkerVariant(int id) { this.id = id;}

    public int getId() {return this.id;}

    public static WalkerVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
