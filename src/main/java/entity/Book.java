package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  long id;
  
  private String autor;
  
  private String titel;
  
  //Auditing-Details
  private String operation;
  
  private long timestamp;
  
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

    
  public String getOperation()
  {
    return operation;
  }

  
  public void setOperation(String operation)
  {
    this.operation = operation;
  }

  
  public long getTimestamp()
  {
    return timestamp;
  }

  
  public void setTimestamp(long timestamp)
  {
    this.timestamp = timestamp;
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
