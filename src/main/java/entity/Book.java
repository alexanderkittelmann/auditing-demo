package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

@Entity
@EntityListeners({AuditListener.class})
@Audited
public class Book extends AuditingEntity implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  long id;
  
  @NotNull
  @Size(min=2)
  private String autor;
  
  @NotNull
  @Size(min=2)
  private String titel;  
  
  public Book() {}  
  
  public long getId()
  {
    return id;
  }

  
  public void setId(long id)
  {
    this.id = id;
  }

  
  public String getAutor()
  {
    return autor;
  }

  
  public void setAutor(String autor)
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
  
  

}
