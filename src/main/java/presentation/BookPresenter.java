package presentation;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Book;
import repository.BookRepository;

@Named
@RequestScoped
public class BookPresenter {

  @Inject
  BookRepository bookRepository;

  @Inject
  Book neuesBuch;

  public void newBook()
  {
    this.bookRepository.persist(neuesBuch);
  }

  public String saveBook(Book book)
  {
    bookRepository.getAendernBuch().setId(book.getId());
    bookRepository.getAendernBuch().setAutor(book.getAutor());
    bookRepository.getAendernBuch().setTitel(book.getTitel());
    return "buchAendern.xhtml";
  }

  public Book getNeuesBuch()
  {
    return neuesBuch;
  }

  public void setNeuesBuch(Book neuesBuch)
  {
    this.neuesBuch = neuesBuch;
  }

  public List<Book> findeAlleBuecher()
  {
    return this.bookRepository.findAll();
  }

  public void buchAktualisieren()
  {
    this.bookRepository.merge();
  }

  public void buchLoeschen(Book book)
  {
    this.bookRepository.remove(book);
  }

  public BookRepository getBookRepository()
  {
    return bookRepository;
  }

  public void setBookRepository(BookRepository bookRepository)
  {
    this.bookRepository = bookRepository;
  }

}
