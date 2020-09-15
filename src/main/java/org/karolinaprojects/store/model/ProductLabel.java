package org.karolinaprojects.store.model;

public enum ProductLabel {
    ID("Id"),
    NAME("name"),
    TYPE("type"),
    DATE("date");

    String label;

    private ProductLabel(String label) {
         this.label = label;
    }

    public String value() {
        return label;
    }
}
