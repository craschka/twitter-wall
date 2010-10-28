package de.craschka.twitter.api;

public class Author {
    public final String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
