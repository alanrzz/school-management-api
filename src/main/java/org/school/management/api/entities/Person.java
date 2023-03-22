package org.school.management.api.entities;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Person implements Serializable {

  @Serial
  private static final long serialVersionUID = -3700091707199817762L;

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "gender", nullable = false)
  private String gender;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name = "address", nullable = false)
  private String address;
}
