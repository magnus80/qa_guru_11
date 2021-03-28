package helpers;

public enum SearchItems {

    LEROY_MERLIN("Леруа Мерлен"),
    RETAIL("Ритейл"),
    SIMPLE("Simple");

    SearchItems(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    private final String element;
}
