package de.gedoplan.auditing_demo.presentation;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.gedoplan.auditing_demo.entity.Autor;
import de.gedoplan.auditing_demo.entity.Book;
import de.gedoplan.auditing_demo.repository.BookRepository;

@Named
@RequestScoped
public class BookPresenter {

  @Inject
  BookRepository bookRepository;

  @Inject
  Book neuesBuch;

  public void newBook()
  {
    if(this.neuesBuch.getAutor() == null) {
      Autor nullAutor = new Autor();
      nullAutor.setNachname("nachname");
      nullAutor.setVorname("vorname");
      this.neuesBuch.setAutor(nullAutor);
    }
    
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
