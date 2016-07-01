package de.gedoplan.auditing_demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.gedoplan.auditing_demo.entity.auditing.AuditListener;
import de.gedoplan.auditing_demo.entity.auditing.AuditingEntity;

@Entity
@EntityListeners({AuditListener.class})
public class Book extends AuditingEntity implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  long id;
  
  
  @ManyToOne
  private Autor autor;
  
  private String titel;  
  
  public Book() {}  
  
  public Book(Autor autor, String titel) {
    this.autor = autor;
    this.titel = titel;
  } 
  
  public long getId()
  {
    return id;
  }

  
  public void setId(long id)
  {
    this.id = id;
  }

  
  public Autor getAutor()
  {
    return autor;
  }

  
  public void setAutor(Autor autor)
  {
    this.autor = autor;
  }

  
  public String getTitel()
  {
    return titel;
  }

  
  public void setTitel(String titel)
  {
    this.titel = titel;
  }

  
   @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }


  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Book other = (Book) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "Autor [id=" + id + "]";
  }  

}
