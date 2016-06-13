package presentation;

import java.io.Serializable;

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
}
