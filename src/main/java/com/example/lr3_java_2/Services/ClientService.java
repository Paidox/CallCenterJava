package com.example.lr3_java_2.Services;

import com.example.lr3_java_2.Entity.Client;
import com.example.lr3_java_2.Repository.ClientRep;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientService
{
  @Inject
  private ClientRep clientRep;

  public List<Client> findAll() {
    return clientRep.findAll().collect(Collectors.toList());
  }

  public void addNewClient(Client client) { clientRep.save(client); }


  public List<Client> findClientsByName(String name)
  {
    return clientRep.findByFullName(name);
  }

  public void delete(Integer id)
  {
    clientRep.deleteById(id);
  }


  public void update(List<Client> clients)
  {
    for (Client c : clients) {
      clientRep.save(c);
    }
  }
}
