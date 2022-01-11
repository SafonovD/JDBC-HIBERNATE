package com.javaLesson.CW.lesson_5;

import com.javaLesson.CW.lesson_5.entity.Book;

public class Main {
    public static void main(String[] args) {
        BookFill bookFill = new BookFill();

        Book book = new Book();
        book.setName("Война и мир");
        book.setAuthor_id(1);

       bookFill.addBook(book);

    }
}
