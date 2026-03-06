package com.gorakh.lldrunner.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String member_id;
    private final String name;
    private final String contact_info;
    private List<Book> borrowed_books;

    public Member(String member_id, String name, String contact_info) {
        this.member_id = member_id;
        this.name = name;
        this.contact_info = contact_info;
        this.borrowed_books = new ArrayList<>();
    }

    public String getMember_id() {
        return member_id;
    }

    public String getName() {
        return name;
    }

    public String getContact_info() {
        return contact_info;
    }

    public List<Book> getBorrowed_books() {
        return borrowed_books;
    }

    public void setBorrowed_books(List<Book> borrowed_books) {
        this.borrowed_books = borrowed_books;
    }
}
