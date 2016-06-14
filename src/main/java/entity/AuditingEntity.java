package entity;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class AuditingEntity
{
  @Transient
  @Inject
  HttpServletRequest request;

  // Auditing-Details
  @NotNull
  private String user;

  @NotNull
  private String operation;

  @NotNull
  private LocalDateTime timestamp;


  public String getUser()
  {
    return user;
  }


  @PostConstruct
  public void setUser()
  {
    // Sollte eientlich in AuditListener geschehen, jedoch kommt es zu einer Exception sobald in der
    // Listener-Klasse eine Injektion durchgeführt wird
    this.user = request.getUserPrincipal().toString();
  }


  public void setUser(String user)
  {
    this.user = user;
  }


  public String getOperation()
  {
    return operation;
  }


  public void setOperation(String operation)
  {
    this.operation = operation;
  }


  public LocalDateTime getTimestamp()
  {
    return timestamp;
  }


  public void setTimestamp(LocalDateTime timestamp)
  {
    this.timestamp = timestamp;
  }

}
