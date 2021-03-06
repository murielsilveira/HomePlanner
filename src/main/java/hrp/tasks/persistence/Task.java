package hrp.tasks.persistence;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String description;
  private int status;
  private UUID uuid;

  public Task() {
    this.status = 0;
    this.uuid = UUID.randomUUID();
  }

  public Task(String description){
    this.status = 0;
    this.uuid = UUID.randomUUID();
  }

  public String getDescription() {
    return description;
  }

  public int getStatus() {
    return status;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}