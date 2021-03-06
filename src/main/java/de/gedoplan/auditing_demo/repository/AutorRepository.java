package de.gedoplan.auditing_demo.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import de.gedoplan.auditing_demo.entity.Autor;

@ApplicationScoped
public class AutorRepository implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @PersistenceContext(unitName = "auditing")
  EntityManager em;

  @Inject
  Autor aendernAutor;


  @Transactional
  public void persist(Autor autor)
  {
    em.persist(autor);
  }


  @Transactional
  public void merge()
  {
    Autor mergeAutor = em.find(Autor.class, this.aendernAutor.getId());
    mergeAutor.setNachname(this.aendernAutor.getNachname());
    mergeAutor.setVorname(this.aendernAutor.getVorname());
    em.merge(mergeAutor);
  }


  @Transactional
  public void remove(Autor autor)
  {
    Autor remAutor = em.find(Autor.class, autor.getId());
    em.remove(remAutor);
  }


  public Autor find(long id)
  {
    return em.find(Autor.class, id);
  }


  public List<Autor> findAll()
  {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
    Root<Autor> rootEntry = cq.from(Autor.class);
    CriteriaQuery<Autor> all = cq.select(rootEntry);
    TypedQuery<Autor> allQuery = em.createQuery(all);
    List<Autor> alleAutoren = allQuery.getResultList();
    return alleAutoren;
  }


  public Autor getAendernAutor()
  {
    return aendernAutor;
  }


  public void setAendernAutor(Autor aendernAutor)
  {
    this.aendernAutor = aendernAutor;
  }

}