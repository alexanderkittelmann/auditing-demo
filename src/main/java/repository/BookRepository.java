package repository;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import entity.Book;

@RequestScoped
public class BookRepository {
  
  @PersistenceContext(unitName="auditing")
  EntityManager em;  
  
  @Transactional
  public void persist(Book book){
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
}
