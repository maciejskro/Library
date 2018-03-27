package pl.sda.library.entity;

public enum BooksType {

    SF("Science Finction"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    TRAVEL("Travel"),
    SCIENCE("Science"),
    HISTORY("History"),
    FANTASY("Fantasy");

    private String description;
    public String getDescription() {
        return description;
    }

    BooksType(String description) {
        this.description = description;
    }
}
