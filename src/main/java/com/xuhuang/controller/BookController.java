package com.xuhuang.controller;

import com.alibaba.fastjson.JSON;
import com.xuhuang.model.Book;
import com.xuhuang.model.RestResponse;
import com.xuhuang.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.xuhuang.constant.Constants.FAIL;
import static com.xuhuang.constant.Constants.INT_0;
import static com.xuhuang.constant.Constants.INT_1;
import static com.xuhuang.constant.ErrorConstant.INTERNAL_ERROR;
import static com.xuhuang.constant.ErrorConstant.PARAM_ERROR;

@RestController
@RequestMapping("/v1/book")
public class BookController
{
    //没有pull直接 push的后果 
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    //githubæµ‹è¯• 
    @Autowired
    private BookService bookService;

    @GetMapping
    public RestResponse getBooksByCondition(String name, String type, String author, String adaptAge, Integer pageNo, Integer pageSize)
    {
        RestResponse response;
        try
        {
            List<Book> books = bookService.getBooksByCondition(name, type, author, adaptAge, pageNo, pageSize);
            int totalNum = bookService.selectBookCount(name, type, author, adaptAge);
            response = new RestResponse(totalNum, books);
        }
        catch (Exception e)
        {
            LOGGER.error("getBookByCondition error" + e);
            response = new RestResponse(500, INTERNAL_ERROR, e);
        }
        return response;
    }

    @GetMapping("/{id}")
    public RestResponse getSingBook(@PathVariable("id") Long id)
    {
        RestResponse response = new RestResponse(INT_0, null);
        try
        {
            Book book = bookService.getSingleBook(id);
            if (book != null)
            {
                response = new RestResponse(INT_1, book);
            }
        }
        catch (Exception e)
        {
            LOGGER.error("getSingleById error" + e);
            response = new RestResponse(500, PARAM_ERROR, e);
        }
        return response;
    }

    @PostMapping
    public RestResponse addBooks(@RequestBody List<Book> books)
    {
        RestResponse response;
        try
        {
            bookService.addBooks(books);
            response = new RestResponse();
        }
        catch (Exception e)
        {
            LOGGER.error("addBooks error, the param is:" + JSON.toJSONString(books));
            response = new RestResponse(400, FAIL, e);
        }
        return response;
    }

    @PutMapping
    public RestResponse updateSingleBook(@RequestBody Book book)
    {
        RestResponse response;
        try
        {
            bookService.updateSingleBook(book);
            response = new RestResponse();
        }
        catch (Exception e)
        {
            LOGGER.error("updateSingleBook error, param is:" + JSON.toJSONString(book));
            response = new RestResponse(400, FAIL, e.getMessage());
        }
        return response;
    }

    @DeleteMapping
    public RestResponse deleteBooks(@Param("ids") String ids)
    {
        RestResponse response;
        try
        {
            bookService.deleteBooks(ids);
            response = new RestResponse();
        }
        catch (Exception e)
        {
            LOGGER.error("deleteBooks error, param is:" + ids);
            response = new RestResponse(400, FAIL, e.getMessage());
        }
        return response; 
//²âÊÔgit

    }

}
