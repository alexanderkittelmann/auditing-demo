package entity;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditListener
{  
  @PrePersist
  public void prepersist(Book book) {
    book.setOperation("PERSIST");
    audit(book);
  }
  
  @PreUpdate
  public void preupdate(Book book) {
    book.setOperation("UPDATE");
    audit(book);
  }
  
  public void audit(Book book) {
    book.setTimestamp(LocalDateTime.now());
  }
}
