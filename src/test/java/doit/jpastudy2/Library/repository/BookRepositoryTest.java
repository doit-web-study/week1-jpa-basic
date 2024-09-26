package doit.jpastudy2.Library.repository;

import doit.jpastudy2.Library.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void test(){
        Book book = Book.builder()
                .title("모순")
                .author("양귀자")
                .isbn("9788998441012")
                .publisher("쓰다")
                .build();

        bookRepository.save(book);

        Book book1 = bookRepository.findByTitleAndAuthor("모순","양귀자");

        System.out.println("Member Id = " + book1.getBookId());
    }

}