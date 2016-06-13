package repository;

import java.time.LocalDate;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import entity.Book;

@RequestScoped
public class BookRepository {
  
  @PersistenceContext(unitName="auditing")
  EntityManager em;
  
  @Inject
  HttpServletRequest request;
  
  @Transactional
  public void persist(Book book){
    audit(book);
    em.persist(book);
  }
  
  public void merge(Book book){
    em.merge(book);
  }
  
  public void remove(Book book){
    em.remove(book);
  }
  
  public Book find(long id){
    return em.find(Book.class, id);
  }
  
  @PrePersist
  public void audit(Book book) {
    book.setUser(request.getUserPrincipal().toString());
    book.setOperation("PERSIST");
    book.setTimestamp((new Date()).getTime());
  }
}
