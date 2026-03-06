package com.gorakh.lldrunner.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class LibraryManager {

    private static LibraryManager instance;

    private Map<String, Book> books;
    private Map<String, Member> members;
    private final int MAX_BOOKS_PER_MEMBER = 5;
    private final int LOAN_DURATION_DAYS = 14;

    private LibraryManager(){
        books = new ConcurrentHashMap<>();
        members = new ConcurrentHashMap<>();
    }

    public static synchronized LibraryManager getInstance(){
        if(instance == null){
            instance = new LibraryManager();
        }
        return instance;
    }


    public void addBook(Book book) {
        books.put(book.getISBN_number(), book);
    }

    public void removeBook(String isbn){
        books.remove(isbn);
    }

    public void registerMember(Member member) {
        members.put(member.getMember_id(), member);
    }

    public void unregisterMember(Member id){
        members.remove(id);
    }

    public void borrowBook(String member, String book) {

        Member m = members.get(member);
        Book b = books.get(book);
        if(m!=null && b!= null && b.getStatus() == AvailableStatus.AVAILABLE) {
            b.setStatus(AvailableStatus.BORROWED);
            m.getBorrowed_books().add(b);
            System.out.println("Book is borrowed successfully");
        }
        else{
            System.out.println("Book or member not found, or book is not available.");
        }
    }

    public void returnBook(String member, String book) {
        Member m = members.get(member);
        Book b = books.get(book);
        if(m!=null && b!= null ) {
            b.setStatus(AvailableStatus.AVAILABLE);
            m.getBorrowed_books().remove(b);
            System.out.println("Book returned successfully.");
        }
        else{
            System.out.println("Book or member was not borrowed");
        }
        return;
    }

    public List<Book> searchBooks(String book) {
        List<Book> matchingBooks =  new ArrayList<>();
        for(Book b: books.values()){
            if(b.getTitle().contains(book) || b.getAuthor().contains(book)){
                matchingBooks.add(b);
            }
        }
        return matchingBooks;

    }
}
