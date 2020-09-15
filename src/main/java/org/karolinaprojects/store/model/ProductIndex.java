package org.karolinaprojects.store.model;

public enum ProductIndex {
    ID(0),
    NAME(1),
    TYPE(2),
    DATE(3);

    int index;

    ProductIndex(int index) {
        this.index = index;
    }

    public int value() {
        return index;
    }
}
