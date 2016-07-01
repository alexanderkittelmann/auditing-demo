package de.gedoplan.auditing_demo.entity.auditing;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener
{  
  @PrePersist
  public void prepersist(AuditingEntity audit) {
    audit.setOperation("PERSIST");
    audit(audit);
  }
  
  @PreUpdate
  public void preupdate(AuditingEntity audit) {
    audit.setOperation("UPDATE");
    audit(audit);
  }
  
  public void audit(AuditingEntity audit) {
    audit.setTimestamp(LocalDateTime.now());
  }
}
