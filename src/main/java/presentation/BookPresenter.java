package presentation;

import java.io.Serializable;
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
  
  public void newBook() {
    this.bookRepository.persist(neuesBuch);
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
  
  public void buchLoeschen(Book book)
  {
    this.bookRepository.remove(book);
  }
}
