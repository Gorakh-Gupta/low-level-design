package com.gorakh.lldrunner.librarymanagementsystem;

import javax.swing.plaf.PanelUI;

public class Book {

    private final String ISBN_number;
    private final String title;
    private final String author;
    private final int publication_year;
    private final AvailableStatus status;

    public Book(String ISBN_number, String title, String author, int publication_year) {
        this.ISBN_number = ISBN_number;
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.status = AvailableStatus.AVAILABLE;
    }

    public String getISBN_number() {
        return ISBN_number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public AvailableStatus getStatus() {
        return status;
    }

    public void setStatus(AvailableStatus status){
        status = AvailableStatus.BORROWED;
    }

}
