package com.xuhuang.service.impl;

import com.xuhuang.dao.BookMapper;
import com.xuhuang.model.Book;
import com.xuhuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.xuhuang.constant.Constants.PAGE_SIZE;
import static com.xuhuang.util.PaginationUtil.trans2DataStart;

@Repository
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBooksByCondition(String name, String type, String author, String adaptAge, Integer pageNo, Integer pageSize)
    {
        if (pageSize == null || pageSize <= 0)
        {
            pageSize = PAGE_SIZE;
        }
        int dataStart = trans2DataStart(pageNo, pageSize);
        return bookMapper.queryBooksByCondition(name, type, author, adaptAge, dataStart, pageSize);
    }

    @Override
    public Book getSingleBook(Long id)
    {
        return bookMapper.querySingleBook(id);
    }

    @Override
    public void addBooks(List<Book> books)
    {
        bookMapper.insertBooks(books);
    }

    @Override
    public void updateSingleBook(Book book)
    {
        bookMapper.updateSingleBook(book);
    }

    @Override
    public void deleteBooks(String ids)
    {
        Stream<String> idStream = Arrays.stream(ids.split(","));
        List<Long> idList = idStream.map(Long::parseLong).collect(Collectors.toList());
        bookMapper.deleteBooks(idList);
    }

    @Override
    public int selectBookCount(String name, String type, String author, String adaptAge)
    {
        return bookMapper.selectBookCount(name, type, author, adaptAge);
    }
}
