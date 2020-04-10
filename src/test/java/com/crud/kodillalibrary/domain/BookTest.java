package com.crud.kodillalibrary.domain;

import com.crud.kodillalibrary.repository.BookRepository;
import com.crud.kodillalibrary.repository.CopyRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CopyRepository copyRepository;

    public void Test(){
        //Given
        Book book = new Book("title 1", "author 1", "2001");
        Copy copy=new Copy(book,Status.AVAILABLE);
        //When
        bookRepository.save(book);
        copyRepository.save(copy);
        //Then

    }


}