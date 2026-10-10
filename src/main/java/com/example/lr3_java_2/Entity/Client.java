package com.example.lr3_java_2.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Client")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "client_fullname")
  private String fullName;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  private String city;

  private String country;

  public Client() {}

  public Client(String fullName, String phoneNumber, LocalDate birthDate, String city, String country) {
    this.fullName = fullName;
    this.phoneNumber = phoneNumber;
    this.birthDate = birthDate;
    this.city = city;
    this.country = country;
  }

  public Integer getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}