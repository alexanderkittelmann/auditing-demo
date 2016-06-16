package repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
  
  public List<Book> findAll() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Book> cq = cb.createQuery(Book.class);
    Root<Book> rootEntry = cq.from(Book.class);
    CriteriaQuery<Book> all = cq.select(rootEntry);
    TypedQuery<Book> allQuery = em.createQuery(all);
    List<Book> alleBuecher = allQuery.getResultList();
    return alleBuecher;
  }
}
