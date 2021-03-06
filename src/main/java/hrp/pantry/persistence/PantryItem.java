package hrp.pantry.persistence;

import hrp.pantry.enums.MeasurementUnits;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;

@Entity
public class PantryItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;
  private Integer quantity;

  @Enumerated(EnumType.STRING)
  private MeasurementUnits unit;

  @Column(nullable = false)
  private UUID uuid;

  @Column
  private Timestamp createdAt;

  @Column
  private Timestamp updatedAt;

  @PreUpdate
  public void adjustUpdateDate(){
    this.updatedAt = new Timestamp(System.currentTimeMillis());
  }

  public PantryItem(String name, Integer quantity, MeasurementUnits unit){
    this.name = name;
    this.quantity = quantity;
    this.unit = unit;
    this.uuid = UUID.randomUUID();
    this.createdAt = new Timestamp(System.currentTimeMillis());
    this.updatedAt = new Timestamp(System.currentTimeMillis());
  }

  public PantryItem(){
    this.uuid = UUID.randomUUID();
    this.createdAt = new Timestamp(System.currentTimeMillis());
    this.updatedAt = new Timestamp(System.currentTimeMillis());
  }


  public UUID getUuid() {
    return uuid;
  }

  public MeasurementUnits getUnit() {
    return unit;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public String getName() {
    return name;
  }

  public Timestamp getCreatedAt(){
    return createdAt;
  }

  public Timestamp getUpdatedAt(){
    return updatedAt;
  }
}
