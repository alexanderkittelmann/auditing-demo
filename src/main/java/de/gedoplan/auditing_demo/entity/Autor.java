package de.gedoplan.auditing_demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import de.gedoplan.auditing_demo.entity.auditing.AuditListener;
import de.gedoplan.auditing_demo.entity.auditing.AuditingEntity;

@Entity
@EntityListeners({AuditListener.class})
public class Autor extends AuditingEntity implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  private String vorname;

  private String nachname;

  @OneToMany(mappedBy = "autor", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<Book> books;


  public Autor()
  {
  }


  public Autor(String vorname, String nachname)
  {
    this.vorname = vorname;
    this.nachname = nachname;
  }


  public long getId()
  {
    return id;
  }


  public void setId(long id)
  {
    this.id = id;
  }


  public String getVorname()
  {
    return vorname;
  }


  public void setVorname(String vorname)
  {
    this.vorname = vorname;
  }


  public String getNachname()
  {
    return nachname;
  }


  public void setNachname(String nachname)
  {
    this.nachname = nachname;
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
    Autor other = (Autor) obj;
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