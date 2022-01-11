package com.javaLesson.CW.lesson_5;

import com.javaLesson.CW.lesson_5.entity.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BookFill bookFill = new BookFill();
        // Добаление книги

        Book book = new Book();
        book.setName("Война и мир");
        book.setAuthor_id(1);

        Book book1 = new Book();
        book1.setName("Отцы и дети");
        book1.setAuthor_id(2);

        bookFill.addBook(book);
        bookFill.addBook(book1);

        Book book2 = new Book();
        book2.setName("12 Месяцев");
        book2.setAuthor_id(3);
        book2.setTheme("Новый год");

        bookFill.addBook(book2);

        System.out.println("----Вывод в консоль всех ниг------");
        //Вывод в консоль всех ниг
        List<Book> getAllBooks = bookFill.getAllBookList();
        for (Book books: getAllBooks) {
            System.out.println(books);
        }

        Book updateBook = getAllBooks.get(0);

        updateBook.setName("Новая Книга");
        updateBook.setTheme(" Новая тема");

        bookFill.updateBook(updateBook);

        System.out.println("---- вывод в консоль часть полей ------");

        // вывод в консоль часть полей
        List<Book> getBooklList = bookFill.getBookList();
        for(Book otherBook : getBooklList){
            System.out.println( otherBook.getName() + " "+ otherBook.getTheme());
        }



    }
}
