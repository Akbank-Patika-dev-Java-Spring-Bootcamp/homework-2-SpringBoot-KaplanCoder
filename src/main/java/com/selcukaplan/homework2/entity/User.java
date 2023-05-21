package com.selcukaplan.homework2.entity;
import com.selcukaplan.homework2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//TODO: how columns' length must be set

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User extends BaseEntity {

  @Id
  @GeneratedValue(generator = "User", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
  private Long id;

  @NotBlank
  @Column(name = "USERNAME", length = 100, nullable = false, unique = true)
  private String username;

  @Email
  @Column(name = "EMAIL", length = 50, unique = true)
  private String email;

  @Size(min= 10,max = 10, message = "phone number should be exact 10 characters")
  @Column(name = "PHONENUMBER", length = 10, unique = true)
  private String phoneNumber;


  @Column(name = "USERTYPE", length = 30)
  @Enumerated(EnumType.STRING)
  private UserType status;
}
