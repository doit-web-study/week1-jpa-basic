package doit.jpastudy2.Library.repository;

import doit.jpastudy2.Library.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findByTitleAndAuthor(String title, String author);
    public Book findByIsbn(String isbn);

}
