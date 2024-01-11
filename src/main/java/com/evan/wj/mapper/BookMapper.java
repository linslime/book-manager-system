package com.evan.wj.mapper;

import com.evan.wj.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from book")
    List<Book> findAll();

    @Delete("delete * from book where id = #{id}")
    void deleteById(int id);

//    @Update("insert into book (id,cid,cover,title,author,date,press,abs) values (#{book.getId()},#{book.getCid()},#{book.getCover()},#{book.getTitle()},#{book.getAuthor()},#{book.getDate()},#{book.getPress()},#{book.getAbs()})")
//    @Transactional
//    void addOrUpdate(Book book);

    @Update("insert into book (id) values (#{book.getId()},#{book.getCid()},#{book.getCover()},#{book.getTitle()},#{book.getAuthor()},#{book.getDate()},#{book.getPress()},#{book.getAbs()})")
    @Transactional
    void addOrUpdate(Book book);

    @Select("select * from book where cid = #{cid}")
    List<Book> listByCategory(int cid);
}
