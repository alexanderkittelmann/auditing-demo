package de.gedoplan.auditing_demo.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import de.gedoplan.auditing_demo.entity.Book;

@ApplicationScoped
public class BookRepository implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @PersistenceContext(unitName = "auditing")
  EntityManager em;

  @Inject
  Book aendernBuch;

  @Transactional
  public void persist(Book book)
  {
    em.persist(book);
  }

  @Transactional
  public void merge()
  {
    Book mergeBook = em.find(Book.class, this.aendernBuch.getId());
    mergeBook.setAutor(this.aendernBuch.getAutor());
    mergeBook.setTitel(this.aendernBuch.getTitel());
    em.merge(mergeBook);
  }

  @Transactional
  public void remove(Book book)
  {
    Book remBook = em.find(Book.class, book.getId());
    em.remove(remBook);
  }

  public Book find(long id)
  {
    return em.find(Book.class, id);
  }

  public List<Book> findAll()
  {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Book> cq = cb.createQuery(Book.class);
    Root<Book> rootEntry = cq.from(Book.class);
    CriteriaQuery<Book> all = cq.select(rootEntry);
    TypedQuery<Book> allQuery = em.createQuery(all);
    List<Book> alleBuecher = allQuery.getResultList();
    return alleBuecher;
  }

  public Book getAendernBuch()
  {
    return aendernBuch;
  }

  public void setAendernBuch(Book aendernBuch)
  {
    this.aendernBuch = aendernBuch;
  }

}
