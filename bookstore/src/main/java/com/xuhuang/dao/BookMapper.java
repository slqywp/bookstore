package com.xuhuang.dao;

import com.xuhuang.model.Book;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper
{
    /**
     * 查询所有书
     *
     * @return
     */
    List<Book> queryAllBooks();

    List<Book> queryBooksByCondition(@Param("name") String name, @Param("type") String type, @Param("author") String author, @Param("adaptAge") String adaptAge, @Param("dataStart") int dataStart, @Param("pageSize") int pageSize);

    Book querySingleBook(@Param("id") long id);

    void insertBooks(@Param("books") List<Book> books);

    void updateSingleBook(@Param("book") Book book);

    void deleteBooks(@Param("ids") List<Long> ids);

    int selectBookCount(@Param("name") String name, @Param("type") String type, @Param("author") String author, @Param("adaptAge") String adaptAge);
}
