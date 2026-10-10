package com.example.lr3_java_2.Repository;

import jakarta.data.repository.Repository;
import com.example.lr3_java_2.Entity.Client;
import jakarta.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ClientRep extends CrudRepository<Client, Integer>
{
  List<Client> findByFullName (String fullName);

}
