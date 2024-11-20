package models;

import java.util.ArrayList;

public class Library {

  private Long id;
    private String name;
    private String address;
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;

    public Library(){}
    public Library(Long id, String name, String address, ArrayList<Book> books, ArrayList<Reader> readers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(ArrayList<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                        ", name='" + name + '\'' +
                        ", address='" + address + '\'' +
                        ", books=" + books +
                        ", readers=" + readers ;
    }
}
