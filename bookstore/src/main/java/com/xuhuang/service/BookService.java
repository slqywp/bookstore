package com.xuhuang.service;

import com.xuhuang.model.Book;

import java.util.List;

public interface BookService
{
    List<Book> getBooksByCondition(String name, String type, String author, String adaptAge, Integer pageNo, Integer pageSize);

    Book getSingleBook(Long id);

    void addBooks(List<Book> books);

    void updateSingleBook(Book book);

    void deleteBooks(String ids);

    int selectBookCount(String name, String type, String author, String adaptAge);
}
